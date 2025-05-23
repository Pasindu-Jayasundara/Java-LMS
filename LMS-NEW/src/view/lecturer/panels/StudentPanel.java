package view.lecturer.panels;

import controller.callback.lecturer.MoreInfoCallback;
import controller.common.DBConnection;
import controller.lecturer.coursePanel.ButtonRenderer;
import controller.lecturer.studentPanel.MoreInfoButtonEditor;
import model.StudentFullDetailModel;
import view.lecturer.dialog.StudentDetailDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class StudentPanel extends JPanel{
    private JPanel panel1;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;

    private final HashMap<String, StudentFullDetailModel> studentModelHashMap = new HashMap<>();

    public StudentPanel() {
        if(!studentModelHashMap.isEmpty()){
            loadFromHashMap("");
        }else{
            loadFromDB("");
        }
    }

    private void createUIComponents() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Search Student:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select search option", "By Id", "By Name", "By Level" }));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "TG Number", "Name", "Year", "Contact", ""
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                .addGap(19, 19, 19))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // search:

        if(jComboBox1.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Please Select Search Option","Missing Search Option",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String enteredValue = jTextField1.getText();
        if(enteredValue.isBlank()){
            JOptionPane.showMessageDialog(this, "Please enter a the value","Missing Value",JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(!studentModelHashMap.isEmpty()){
            loadFromHashMap(enteredValue);
        }else{
            loadFromDB(enteredValue);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // reset:

        if(!studentModelHashMap.isEmpty()){

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            defaultTableModel.setRowCount(0);

            studentModelHashMap.forEach((key,studentFullDetailModel)->{

                addRowToTable(studentFullDetailModel,defaultTableModel);
            });

            tableMoreInfoBtn();

            jComboBox1.setSelectedIndex(0);
            jTextField1.setText("");

        }

    }

    private void tableMoreInfoBtn() {

        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        jTable1.getColumnModel().getColumn(4).setCellEditor(new MoreInfoButtonEditor(new JCheckBox(), new MoreInfoCallback() {
            @Override
            public void onMoreInfoCallback(String studentId) {
                StudentDetailDialog studentDetailDialog = new StudentDetailDialog(StudentPanel.this,studentModelHashMap.get(studentId));
                studentDetailDialog.setVisible(true);
            }
        }));
    }

    private void loadFromHashMap(String enteredValue) {

        int selectedIndex = jComboBox1.getSelectedIndex();
        String searchFrom = "id";

        switch (selectedIndex){
            case 1:{ // by id

                searchFrom = "id";
                break;
            }
            case 2:{ // by name

                searchFrom = "name";
                break;
            }
            case 3:{ // by year

                searchFrom = "year";
                break;
            }
            default:{
                break;
            }
        }

        String finalSearchFrom = searchFrom;
        AtomicBoolean isFound = new AtomicBoolean(false);

        studentModelHashMap.forEach((key, studentFullDetailModel) -> {

            if(
                    (finalSearchFrom.equals("id") && String.valueOf(studentFullDetailModel.getId()).toLowerCase().contains(enteredValue.toLowerCase())) ||
                    (finalSearchFrom.equals("name") && studentFullDetailModel.getUsername().toLowerCase().contains(enteredValue.toLowerCase())) ||
                    (finalSearchFrom.equals("year") && studentFullDetailModel.getLevel().equals(enteredValue))
            ){

                DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();

                if(!isFound.get()){

                    isFound.set(true);
                    defaultTableModel.setRowCount(0);
                }

                addRowToTable(studentFullDetailModel,defaultTableModel);

            }

        });

        if(!isFound.get()){
            JOptionPane.showMessageDialog(this, "No Student Found", "Could not find", JOptionPane.WARNING_MESSAGE);

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            defaultTableModel.setRowCount(0);

            studentModelHashMap.forEach((key, studentFullDetailModel) -> {
                addRowToTable(studentFullDetailModel,defaultTableModel);
            });

        }
        tableMoreInfoBtn();

    }

    private void loadFromDB(String enteredValue) {

        String query = "SELECT * FROM `student` " +
                "INNER JOIN `student_has_department_has_undergraduate_level` ON `student`.`user_id`=`student_has_department_has_undergraduate_level`.`student_user_id` " +
                "INNER JOIN `department_has_undergraduate_level` ON `student_has_department_has_undergraduate_level`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `undergraduate_level` ON `department_has_undergraduate_level`.`undergraduate_level_level_id`=`undergraduate_level`.`level_id` " +
                "INNER JOIN `department` ON `department`.`department_id`=`department_has_undergraduate_level`.`department_department_id` " +
                "INNER JOIN `semester` ON `semester`.`semester_id`=`department_has_undergraduate_level`.`semester_semester_id` ";

        int selectedIndex = jComboBox1.getSelectedIndex();
        switch (selectedIndex){
            case 1:{ // by id

                query+="WHERE `student`.`user_id`=?";
                break;
            }
            case 2:{ // by name

                query+="WHERE `student`.`username`=?";
                break;
            }
            case 3:{ // by year

                query+="WHERE `undergraduate_level`.`level`=?";
                break;
            }
            default:{

                query+="WHERE `student`.`user_id`!=?";
                break;
            }
        }

        loadTable(query,enteredValue);
    }

    private void loadTable(String query, String enteredValue){

        ResultSet resultSet = DBConnection.search(query, enteredValue);
        if(resultSet != null){

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            defaultTableModel.setRowCount(0);

            try{

                while(resultSet.next()){

                    String userId = resultSet.getString("user_id");
                    String username = resultSet.getString("username");
                    String level = resultSet.getString("level");
                    String contactNum = resultSet.getString("contact_number");
                    String email = resultSet.getString("email");
                    String enrolledDate = resultSet.getString("enrollment_date");
                    String profilePicture = resultSet.getString("profile_picture");
                    String semester = resultSet.getString("semester");
                    String department = resultSet.getString("name");

                    // hashmap
                    HashMap<String,String> subjectMap = new HashMap<>();

                    String q2 = "SELECT * FROM `course` " +
                            "INNER JOIN `department_has_undergraduate_level` ON `course`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                            "INNER JOIN `undergraduate_level` ON `undergraduate_level`.`level_id`=`department_has_undergraduate_level`.`undergraduate_level_level_id` " +
                            "WHERE `level`<=?";
                    ResultSet rs = DBConnection.search(q2, level);
                    if(rs != null){
                        while(rs.next()){
                            subjectMap.put(rs.getString("course_code"),rs.getString("course"));
                        }
                    }

                    StudentFullDetailModel studentFullDetailModel = new StudentFullDetailModel();
                    studentFullDetailModel.setId(Integer.parseInt(userId));
                    studentFullDetailModel.setUsername(username);
                    studentFullDetailModel.setEmail(email);
                    studentFullDetailModel.setContactNumber(contactNum);
                    studentFullDetailModel.setEnrollmentDate(enrolledDate);
                    studentFullDetailModel.setProfilePicture(profilePicture);
                    studentFullDetailModel.setLevel(level);
                    studentFullDetailModel.setSemester(semester);
                    studentFullDetailModel.setDepartment(department);
                    studentFullDetailModel.setSubjectList(subjectMap);

                    // table
                    addRowToTable(studentFullDetailModel,defaultTableModel);

                    studentModelHashMap.put(userId, studentFullDetailModel);

                }
                tableMoreInfoBtn();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    private void addRowToTable(StudentFullDetailModel studentFullDetailModel, DefaultTableModel defaultTableModel){

        Vector<Object> row = new Vector<>();
        row.add(studentFullDetailModel.getId());
        row.add(studentFullDetailModel.getUsername());
        row.add(studentFullDetailModel.getLevel());
        row.add(studentFullDetailModel.getContactNumber());
        row.add("More Info");

        defaultTableModel.addRow(row);
    }

}
