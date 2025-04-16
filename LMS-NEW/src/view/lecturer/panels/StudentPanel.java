package view.lecturer.panels;

import controller.DBConnection;
import model.StudentFullDetailModel;
import view.lecturer.dialog.StudentDetailDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private HashMap<String, StudentFullDetailModel> studentModelHashMap = new HashMap<>();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By Id", "By Name", "By Year", "By Level" }));

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
                    false, false, false, false, false
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // search:

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

        }

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
                    (finalSearchFrom.equals("id") && studentFullDetailModel.getId() == Integer.parseInt(enteredValue)) ||
                    (finalSearchFrom.equals("name") && studentFullDetailModel.getUsername().equals(enteredValue)) ||
                    (finalSearchFrom.equals("year") && studentFullDetailModel.getLevel().equals(enteredValue))
            ){

                isFound.set(true);

                DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
                defaultTableModel.setRowCount(0);

                addRowToTable(studentFullDetailModel,defaultTableModel);

                return;
            }

        });

        if(!isFound.get()){
            JOptionPane.showMessageDialog(this, "No Student Found", "Could not find", JOptionPane.WARNING_MESSAGE);
        }

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
                    String department = resultSet.getString("department");

                    // hashmap
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

                    // table
                    addRowToTable(studentFullDetailModel,defaultTableModel);

                    studentModelHashMap.put(userId, studentFullDetailModel);

                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    private void addRowToTable(StudentFullDetailModel studentFullDetailModel, DefaultTableModel defaultTableModel){

        JButton moreInfoBtn = new JButton("More Info");
        moreInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StudentDetailDialog studentDetailDialog = new StudentDetailDialog(StudentPanel.this,studentFullDetailModel);
                studentDetailDialog.setVisible(true);

            }
        });

        Vector<Object> row = new Vector<>();
        row.add(studentFullDetailModel.getId());
        row.add(studentFullDetailModel.getUsername());
        row.add(studentFullDetailModel.getLevel());
        row.add(studentFullDetailModel.getContactNumber());
        row.add(moreInfoBtn);

        defaultTableModel.addRow(row);
    }

}
