import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class Student extends JFrame {
    private int userId;
    private String firstName;

    private JPanel MainPanel;
    private JTextField Stud_ID;
    private JTextField Stud_Name;
    private JTextField Stud_Email;
    private JTextField Stud_Number;
    private JLabel Stud_Photo;
    private JLabel welcomeMsgLabel;
    private JTable table1;
    private JTextArea courseTextArea;
    private JTable table2;

    String selectedImagePath = null;

    // Constructor for Student class
    public Student(int userId, String firstName) {
        this.userId = userId;
        this.firstName = firstName;

        setContentPane(MainPanel);
        setTitle("Student");
        setSize(600, 600);
        setVisible(true);

        welcomeMsgLabel.setText("Welcome " + firstName);  // Display first name on the profile

        setborder();
        showProfile();
        createTable();
        timetable();
        styleTimetable();
        createTable2();
        noticeTable();
        getCourseAsArray();
        showCoursesInTextArea();

        // Action listeners
        uploadPhotoButton.addActionListener(e -> imageUpload());
        saveButton.addActionListener(e -> saveData());
        deletePhotoButton.addActionListener(e -> {
            selectedImagePath = null;
            Stud_Photo.setIcon(null); // removes the photo from the frame
        });
        cancelButton.addActionListener(e -> dispose());
    }

    // Set border for photo
    private void setborder() {
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        Stud_Photo.setBorder(border);
    }

    // Show Profile Data
    private void showProfile() {
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM allusers WHERE user_id=?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Stud_ID.setText(rs.getString("username"));
                Stud_Name.setText(rs.getString("first_name"));
                Stud_Email.setText(rs.getString("email"));
                Stud_Number.setText(rs.getString("phone"));

                selectedImagePath = rs.getString("profile_picture");
                if (selectedImagePath != null) {
                    ImageIcon ii = new ImageIcon(selectedImagePath);
                    Image image = ii.getImage().getScaledInstance(135, 172, Image.SCALE_SMOOTH);
                    Stud_Photo.setIcon(new ImageIcon(image));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Image Upload
    public void imageUpload() {
        JFileChooser chooser = new JFileChooser("C:\\Users\\Ishana\\Desktop\\Pictures");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Image File", "jpg", "png");
        chooser.addChoosableFileFilter(fnef);
        int showOpenDialog = chooser.showOpenDialog(null);

        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = chooser.getSelectedFile();
            selectedImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, selectedImagePath);

            ImageIcon ii = new ImageIcon(selectedImagePath);
            Image image = ii.getImage().getScaledInstance(135, 172, Image.SCALE_SMOOTH);
            Stud_Photo.setIcon(new ImageIcon(image));
        }
    }

    // Save Data to Database
    private void saveData() {
        if (Stud_Email.getText().isEmpty() || Stud_Number.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("UPDATE allusers SET email=?, phone=?, profile_picture=? WHERE user_id=?");
            pst.setString(1, Stud_Email.getText());
            pst.setString(2, Stud_Number.getText());
            pst.setString(3, selectedImagePath);
            pst.setInt(4, userId);

            int result = pst.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Student has been saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Student has not been saved successfully", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Create Timetable Table
    void createTable() {
        table1.setModel(new DefaultTableModel(null, new String[]{"day_of_week", "course_name", "start_time", "end_time", "location", "session_type"}));
    }

    // Load Timetable Data from Database
    void timetable() {
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT timetables.day_of_week, courses.course_name, timetables.start_time, timetables.end_time, timetables.location, timetables.session_type " +
                    "FROM timetables " +
                    "INNER JOIN courses ON timetables.course_id = courses.course_id " +
                    "ORDER BY CASE timetables.day_of_week " +
                    "WHEN 'Monday' THEN 1 " +
                    "WHEN 'Tuesday' THEN 2 " +
                    "WHEN 'Wednesday' THEN 3 " +
                    "WHEN 'Thursday' THEN 4 " +
                    "WHEN 'Friday' THEN 5 END, timetables.start_time");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= count; i++) {
                    v2.add(rs.getString("day_of_week"));
                    v2.add(rs.getString("course_name"));
                    v2.add(rs.getString("start_time"));
                    v2.add(rs.getString("end_time"));
                    v2.add(rs.getString("location"));
                    v2.add(rs.getString("session_type"));
                }
                dtm.addRow(v2);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Style the Timetable Table
    private void styleTimetable() {
        table1.setRowHeight(30);
        table1.setFont(new Font("Times New Roman", Font.BOLD, 12));
        table1.setShowGrid(false);
        table1.setFocusable(false);
        table1.setRowSelectionAllowed(false);

        JTableHeader header = table1.getTableHeader();
        header.setFont(new Font("Times New Roman", Font.BOLD, 14));
        header.setBackground(new Color(80, 135, 185));
        header.setForeground(Color.blue);

        table1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(244, 244, 240));
                c.setForeground(Color.BLACK);
                return c;
            }
        });
    }

    // Create Notices Table
    void createTable2() {
        table2.setModel(new DefaultTableModel(null, new String[]{"title", "content", "publish_date"}));
    }

    // Load Notices from Database
    void noticeTable() {
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM notices");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) table2.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= count; i++) {
                    v2.add(rs.getString("title"));
                    v2.add(rs.getString("content"));
                    v2.add(rs.getString("publish_date"));
                }
                dtm.addRow(v2);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Get Course List as Array
    private ArrayList<String> getCourseAsArray() {
        ArrayList<String> courseArray = new ArrayList<>();

        try {
            Connection con = dbconnection.getConnection();
            String sql = "SELECT course_code, course_name, lecturer_in_charge FROM courses";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String course_code = rs.getString("course_code");
                String course_name = rs.getString("course_name");
                String lecture = rs.getString("lecturer_in_charge");

                String formattedcourse = course_code + " " + course_name + " " + lecture + "\n ____________________\n";
                courseArray.add(formattedcourse);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return courseArray;
    }

    // Show Course List in Text Area
    private void showCoursesInTextArea() {
        ArrayList<String> courses = getCourseAsArray();
        StringBuilder allcourses = new StringBuilder();

        for (String course : courses) {
            allcourses.append(course).append("\n");
        }
        courseTextArea.setText(allcourses.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Student(1, "John Doe"));
    }
}


public class ViewMedicals extends JFrame {
    private JPanel MedicalPanel;
    private JTextField c_code;
    private JButton viewMedicalsButton;
    private JTable MedicalTable;
    private JButton resetButton;
    private JLabel ccode;

    public ViewMedicals() {
        setTitle("View Medical Submissions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(950, 550);
        setLocationRelativeTo(null); // Center window

        // ===== Main Panel =====
        MedicalPanel = new JPanel(new BorderLayout(10, 10));
        MedicalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(MedicalPanel);

        // ===== Top Input Panel =====
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JLabel ccode = new JLabel("Course Code:");
        ccode.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(ccode);

        c_code = new JTextField(10);
        c_code.setFont(new Font("Arial", Font.PLAIN, 14));
        inputPanel.add(c_code);

        viewMedicalsButton = new JButton("View Medicals");
        viewMedicalsButton.setPreferredSize(new Dimension(140, 35));
        viewMedicalsButton.setFont(new Font("Arial", Font.BOLD, 13));
        inputPanel.add(viewMedicalsButton);

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 35));
        resetButton.setFont(new Font("Arial", Font.BOLD, 13));
        inputPanel.add(resetButton);

        MedicalPanel.add(inputPanel, BorderLayout.NORTH);

        // ===== Table =====
        MedicalTable = new JTable();
        MedicalTable.setFont(new Font("Arial", Font.PLAIN, 13));
        MedicalTable.setRowHeight(25);
        MedicalTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane tableScrollPane = new JScrollPane(MedicalTable);
        tableScrollPane.setPreferredSize(new Dimension(900, 400));
        MedicalPanel.add(tableScrollPane, BorderLayout.CENTER);

        // ===== Button Actions =====
        viewMedicalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseCode = c_code.getText().trim();

                if (courseCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a course code.");
                    return;
                }

                try {
                    Connection con = dbconnection.getConnection();
                    String sql = "SELECT medical_id, username, Description, Sub_date, State, c_code, c_type, cut_lec_hour FROM Medical WHERE c_code = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, courseCode);

                    ResultSet rs = ps.executeQuery();

                    DefaultTableModel model = new DefaultTableModel(
                            new String[]{"Medical ID", "Username", "Description", "Submitted Date", "State", "Course Code", "Course Type", "Cut Lecture Hours"}, 0
                    );

                    while (rs.next()) {
                        model.addRow(new Object[]{
                                rs.getInt("medical_id"),
                                rs.getString("username"),
                                rs.getString("Description"),
                                rs.getDate("Sub_date"),
                                rs.getString("State"),
                                rs.getString("c_code"),
                                rs.getString("c_type"),
                                rs.getInt("cut_lec_hour")
                        });
                    }

                    MedicalTable.setModel(model);

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error fetching medical records.");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c_code.setText("");
                MedicalTable.setModel(new DefaultTableModel());
            }
        });
    }

    public JPanel getViewMedicals() {
        return MedicalPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewMedicals().setVisible(true));
    }
}