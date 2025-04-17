package view.lecturer.panels;

import controller.DBConnection;
import view.lecturer.dialog.PDFPreviewDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AttendancePanel extends JPanel{
    private JPanel panel1;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;

    private void createUIComponents() {
        initComponents();
        loadAttendanceTable("");
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Search Student:");

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
                        "#", "Student Id", "Subject", "Attendance Count", "Medicals"
                }
        ) {
            final boolean[] canEdit = new boolean [] {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // search btn:

        String text = jTextField1.getText();
        if(text.isBlank()){

            JOptionPane.showMessageDialog(this,"Please Enter Student ID OR Username","Missing Info",JOptionPane.WARNING_MESSAGE);
            return;
        }
        loadAttendanceTable(text);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // reset btn

        jTextField1.setText("");
        loadAttendanceTable("");
    }

    private void loadAttendanceTable(String searchText) {

        String stext = "%"+searchText+"%";

        String query = "SELECT * FROM `student` " +
                "INNER JOIN `student_has_department_has_undergraduate_level` ON `student`.`user_id`=`student_has_department_has_undergraduate_level`.`student_user_id` " +
                "INNER JOIN `department_has_undergraduate_level` ON `student_has_department_has_undergraduate_level`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `course` ON `course`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "WHERE `user_id` LIKE ? OR `username` LIKE ?";

        ResultSet resultSet = DBConnection.search(query, stext, stext);
        if(resultSet != null){

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            int index = 0;

            try{

                while(resultSet.next()){

                    String userId = resultSet.getString("user_id");
                    String courseId = resultSet.getString("course_id");
                    String dhulId = resultSet.getString("department_has_undergraduate_level.id");
                    String shdhslID = resultSet.getString("student_has_department_has_undergraduate_level.id");

                    Vector<Object> row = new Vector<>();
                    row.add(String.valueOf(++index));
                    row.add(userId);
                    row.add(resultSet.getString("course"));

                    String q2 = "SELECT COUNT(`attendance`.`id`) AS `attendance_count` FROM `attendance` " +
                            "INNER JOIN `timetable` ON `attendance`.`timetable_timetable_id`=`timetable`.`timetable_id` " +
                            "INNER JOIN `course` ON `course`.`course_id`=`timetable`.`course_course_id` " +
                            "INNER JOIN `department_has_undergraduate_level` ON `department_has_undergraduate_level`.`id`=`course`.`department_has_undergraduate_level_id` " +
                            "WHERE `student_user_id`=? AND `course`.`course_id`=? AND `department_has_undergraduate_level`.`id`=?";

                    ResultSet rs = DBConnection.search(q2, userId, courseId, dhulId);
                    if(rs != null){

                        while(rs.next()){
                            row.add(rs.getString("attendance_count"));
                        }
                    }
                    row.add(resultSet.getString("course"));

                    String q3 = "SELECT * FROM `medical_record` " +
                            "INNER JOIN `student` ON `student`.`user_id`=`medical_record`.`student_user_id` " +
                            "INNER JOIN `student_has_department_has_undergraduate_level` ON `student`.`user_id`=`student_has_department_has_undergraduate_level`.`student_user_id` " +
                            "WHERE `student`.`user_id`=? AND `student_has_department_has_undergraduate_level`.`id`=?";

                    ResultSet rs2 = DBConnection.search(q3, userId, shdhslID);

                    JTable jTable = new JTable();
                    DefaultTableModel defaultTableModel = new DefaultTableModel();
                    jTable.setModel(defaultTableModel);
                    jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                    jTable.addColumn(new TableColumn());

                    if(rs2 != null){

                        while (rs2.next()){

                            JButton button = new JButton(rs2.getString("record_id"));
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    try {
                                        openMedical(rs2.getString("url"));
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });

                            Vector<JButton> row2 = new Vector<>();
                            row2.add(button);

                            defaultTableModel.addRow(row2);
                        }
                    }
                    row.add(jTable);

                    dtm.addRow(row);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    private void openMedical(String url) {

        PDFPreviewDialog pdfPreviewDialog = new PDFPreviewDialog(AttendancePanel.this,url);
        pdfPreviewDialog.setVisible(true);
    }
}
