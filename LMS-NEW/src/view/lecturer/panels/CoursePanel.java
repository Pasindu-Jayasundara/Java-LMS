package view.lecturer.panels;

import controller.DBConnection;
import controller.Validation;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class CoursePanel extends JPanel {

    private JPanel panel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;


    private int timetableRowCount;
    private boolean isFirstTimeTableRow;

    private HashMap<String, CourseModel> courseHashMap = new HashMap<>();

    private void createUIComponents() {
        initComponents();
        loadCourses("");
    }

    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("Search By Course Code:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "Code", "Name", "Credit", "Hourse"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jButton2.setText("Reset");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("All Courses", jPanel1);

        jLabel2.setText("Course Code:");

        jLabel3.setText("Course Name:");

        jLabel4.setText("Credit:");

        jLabel5.setText("Course Hours:");

        jLabel6.setText("Department:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel7.setText("Level:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(64, 22));

        jLabel8.setText("Semester:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Timetable");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Corse Details");

        jLabel11.setText("Day of the Week:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("From:");

        jLabel13.setText("To:");

        jButton3.setText("Add +");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "Day", "From", "To"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(2);
        }

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Double Click to Remove From TImetable");

        jButton4.setBackground(new java.awt.Color(0, 102, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Save Course");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(204, 204, 204)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel4))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jTextField2)
                                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel5)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(jTextField5))
                                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel3)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel11)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel12)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel13)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jButton3))
                                                                .addComponent(jScrollPane2))
                                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add New Course", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
    }// </editor-fold>

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // reset
        jTextField1.setText("");
        loadCourses("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // search
        String courseCode = jTextField1.getText();
        if (courseCode.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Course Code", "Missing Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        courseCode = courseCode.toLowerCase();

        loadCourses(courseCode);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // add timetable

        if (!isFirstTimeTableRow) {
            isFirstTimeTableRow = true;
        }

        String selectedDay = String.valueOf(jComboBox4.getSelectedItem());
        String from = jFormattedTextField1.getText();
        String to = jFormattedTextField2.getText();

        if(!Validation.isValidTime(from)){
            JOptionPane.showMessageDialog(this, "Please enter a valid Time From", "Invalid Time", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!Validation.isValidTime(to)){
            JOptionPane.showMessageDialog(this, "Please enter a valid Time To", "Invalid Time", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date fromTime = sdf.parse(from);
            Date toTime = sdf.parse(to);

            boolean before = fromTime.before(toTime);
            if (!before) {
                JOptionPane.showMessageDialog(this, "Time From Cannot be after Time To", "Invalid Time Duration", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        timetableRowCount++;

        Vector<String> row = new Vector<>();
        row.add(String.valueOf(timetableRowCount));
        row.add(selectedDay);
        row.add(from);
        row.add(to);

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable2.getModel();
        defaultTableModel.addRow(row);

    }

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {
        // table
        if (evt.getClickCount() == 2) {

            int confirm = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Remove This From Timetable ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                jTable2.remove(jTable2.getSelectedRow());

                timetableRowCount--;
                if (timetableRowCount == 0) {
                    isFirstTimeTableRow = false;
                }
            }
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // save course

        if(isCourseDetailsCorrect()){

            String newCourseCode = jTextField2.getText();
            String newCourseName = jTextField3.getText();
            String credit = jTextField4.getText();
            String hours = jTextField5.getText();

            String department = String.valueOf(jComboBox1.getSelectedItem());
            String level = String.valueOf(jComboBox2.getSelectedItem());
            String semester = String.valueOf(jComboBox3.getSelectedItem());



            // course table
            String query = "INSERT INTO `course`(`course`,`credit`,`course_code`,`course_hours`,`department_has_undergraduate_level_id`) VALUES(?,?,?,?,?)";
            DBConnection.iud(query, newCourseName,credit,newCourseCode,dhulId);

        }

    }

    private boolean isCourseDetailsCorrect() {

        String newCourseCode = jTextField2.getText();
        String newCourseName = jTextField3.getText();
        String credit = jTextField4.getText();
        String hours = jTextField5.getText();

        if(newCourseCode.isBlank()){
            JOptionPane.showMessageDialog(this,"Course Code Cannot be Empty","Missing Data",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(newCourseName.isBlank()){
            JOptionPane.showMessageDialog(this,"Course Name Cannot be Empty","Missing Data",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(credit.isBlank()){
            JOptionPane.showMessageDialog(this,"Course Credit Cannot be Empty","Missing Data",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(hours.isBlank()){
            JOptionPane.showMessageDialog(this,"Course Hours Cannot be Empty","Missing Data",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try{
            Integer.parseInt(credit);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Course Credit Must Be a Number","Invalid Data",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try{
            Double.parseDouble(hours);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Course Hours Must Be a Number","Invalid Data",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(courseHashMap.containsKey(newCourseCode)){
            JOptionPane.showConfirmDialog(this,"Course Code Already Exists","Invalid Course Code",JOptionPane.ERROR_MESSAGE)
            return false;
        }

        return true;

    }

    private void loadCourses(String enteredCourseCode) {

        if(courseHashMap.isEmpty()){
            loadCoursesFormDB(enteredCourseCode);
        }else{
            loadCoursesFromHashMap(enteredCourseCode);
        }

    }

    private void loadCoursesFromHashMap(String enteredCourseCode) {

    }

    private void loadCoursesFormDB(String enteredCourseCode) {

        String query = "SELECT * FROM `course` WHERE `course_code` LIKE '%?%' ";

        ResultSet resultSet = DBConnection.search(query, enteredCourseCode);
        if(resultSet == null){
            JOptionPane.showMessageDialog(this, "Course Code Not Found", "Missing Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

        defaultTableModel.setRowCount(0);

        try {
            while (resultSet.next()) {

                String courseCode = resultSet.getString("course_code");
                String courseId = resultSet.getString("course_id");
                String courseName = resultSet.getString("course");
                String credit = resultSet.getString("credit");
                String courseHours = resultSet.getString("course_hours");

                String departmentId = resultSet.getString("semester_id");
                String department = resultSet.getString("semester");

                String semesterId = resultSet.getString("semester_id");
                String semester = resultSet.getString("semester");

                String undergraduateLevelId = resultSet.getString("semester_id");
                String undergraduateLevel = resultSet.getString("semester");

                String dhulId = resultSet.getString("semester_id");


                // load table
                Vector<String> row = new Vector<>();

                row.add(courseId);
                row.add(courseCode);
                row.add(courseName);
                row.add(credit);
                row.add(courseHours);

                defaultTableModel.addRow(row);


                // load hashmap

                DepartmentModel departmentModel = new DepartmentModel();
                departmentModel.setId(departmentId);
                departmentModel.setName(department);

                SemesterModel semesterModel = new SemesterModel();
                semesterModel.setId(semesterId);
                semesterModel.setSemester(semester);

                UndergraduateLevelModel undergraduateLevelModel = new UndergraduateLevelModel();
                undergraduateLevelModel.setId(undergraduateLevelId);
                undergraduateLevelModel.setLevel(undergraduateLevel);

                DepartmentHasUndergraduateLevelModel dhulm = new DepartmentHasUndergraduateLevelModel();
                dhulm.setDepartment(departmentModel);
                dhulm.setId(dhulId);
                dhulm.setSemester(semesterModel);
                dhulm.setUndergraduateLevel(undergraduateLevelModel);

                CourseModel courseModel = new CourseModel();
                courseModel.setCourseCode(courseCode);
                courseModel.setCourseId(courseId);
                courseModel.setCourseName(courseName);
                courseModel.setCredit(credit);
                courseModel.setHours(courseHours);
                courseModel.setDepartmentHasUndergraduateLevelModel(dhulm);

                courseHashMap.put(courseCode,courseModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
