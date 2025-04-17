package view.lecturer.panels;

import controller.DBConnection;
import controller.callback.MarksUpdateCallBack;
import model.ExamModel;
import model.MarksModel;
import view.lecturer.LecturerDashboard;
import view.lecturer.dialog.MarksDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ExamPanel extends JPanel {
    private JPanel panel1;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;

    private final HashMap<String, ExamModel> examModelHashMap = new HashMap<>();

    private void createUIComponents() {
        initComponents();
        loadExams();
    }

    private void loadExams() {

        String query = "SELECT * FROM `exam` " +
                "INNER JOIN `exam_type` ON `exam`.`exam_type_type_id`=`exam_type`.`type_id` " +
                "INNER JOIN `marks` ON `marks`.`exam_exam_id`=`exam`.`exam_id` " +
//                "INNER JOIN `marks_document` ON `marks_document`.`exam_exam_id`=`exam`.`exam_id` " +
                "INNER JOIN `department_has_undergraduate_level` ON `department_has_undergraduate_level`.`id`=`exam`.`department_has_undergraduate_level_id` " +
                "INNER JOIN `course` ON `department_has_undergraduate_level`.`id`=`course`.`department_has_undergraduate_level_id` " +
                "INNER JOIN `lecturer` ON `course`.`lecturer_user_id`=`lecturer`.`user_id` " +
                "WHERE `lecturer`.`user_id`=?";

        ResultSet resultSet = DBConnection.search(query, LecturerDashboard.loginLecturerModel.getId());
        if (resultSet != null) {

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
            defaultTableModel.setRowCount(0);

            try {

                while (resultSet.next()) {

                    String examId = resultSet.getString("exam.id");
                    String courseName = resultSet.getString("course.course");
                    String courseCode = resultSet.getString("course.course_code");
                    String dateTime = resultSet.getString("exam.date_time");
                    String venue = resultSet.getString("exam.venue");
                    String desc = resultSet.getString("exam.description");
                    String examType = resultSet.getString("exam_type.type");

                    String q2 = "SELECT * FROM `marks_document` WHERE `exam_exam_id`=?";
                    ResultSet rs = DBConnection.search(q2, examId);

                    Vector<MarksModel> marksModelVector = new Vector<>();

                    if(rs != null) {

                        while (rs.next()) {

                            MarksModel marksModel = new MarksModel();
                            marksModel.setFileName(rs.getString("file_name"));
                            marksModel.setUrl(rs.getString("url"));
                            marksModel.setId(rs.getString("id"));

                            marksModelVector.add(marksModel);
                        }

                    }

                    ExamModel examModel = new ExamModel();
                    examModel.setId(examId);
                    examModel.setCourseName(courseName);
                    examModel.setDateTime(dateTime);
                    examModel.setVenue(venue);
                    examModel.setDescription(desc);
                    examModel.setCourseCode(courseCode);
                    examModel.setExamType(examType);
                    examModel.setMarksModel(marksModelVector);

                    JButton updateMarksBtn = new JButton("Update Marks");
                    updateMarksBtn.addActionListener(e -> {
                        showMarksDialog(examModel);
                    });

                    Vector<Object> row = new Vector<>();
                    row.add(examId);
                    row.add(courseName);
                    row.add(dateTime);
                    row.add(venue);
                    row.add(desc);
                    row.add(examType);
                    row.add(updateMarksBtn);

                    defaultTableModel.addRow(row);

                    examModelHashMap.put(examId, examModel);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Search Exam:");

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
                        "#", "Subject", "Date & Time", "Venue", "Description", "Type", ""
                }
        ) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
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
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // reset:

        jTextField1.setText("");

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.setRowCount(0);

        examModelHashMap.forEach((examId, examModel) -> {

            loadTableRows(examModel,defaultTableModel);

        });
    }

    private void loadTableRows(ExamModel examModel, DefaultTableModel defaultTableModel) {

        JButton updateMarksBtn = new JButton("Update Marks");
        updateMarksBtn.addActionListener(e -> {
            showMarksDialog(examModel);
        });

        Vector<Object> row = new Vector<>();
        row.add(examModel.getId());
        row.add(examModel.getCourseName());
        row.add(examModel.getDateTime());
        row.add(examModel.getVenue());
        row.add(examModel.getDescription());
        row.add(examModel.getExamType());
        row.add(updateMarksBtn);

        defaultTableModel.addRow(row);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // search:

        String searchText = jTextField1.getText();
        if (searchText.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please Enter Exam ID or Course Name");
            return;
        }

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.setRowCount(0);

        examModelHashMap.forEach((examId, examModel) -> {

            if (examModel.getId().equals(searchText) || examModel.getCourseName().equals(searchText)) {

                loadTableRows(examModel,defaultTableModel);

            }
        });

    }

    private void showMarksDialog(ExamModel examModel) {

        MarksDialog marksDialog = new MarksDialog(ExamPanel.this,examModel,new MarksUpdateCallBack(){
            @Override
            public void onUpdateMarks(boolean isUpdated) {
                if(isUpdated){
                    examModelHashMap.clear();
                    loadExams();
                }
            }
        });
        marksDialog.setVisible(true);

    }

}
