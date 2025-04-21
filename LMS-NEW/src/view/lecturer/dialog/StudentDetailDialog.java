package view.lecturer.dialog;

import controller.common.DBConnection;
import model.StudentFullDetailModel;
import view.lecturer.panels.StudentPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentDetailDialog extends JDialog {
    private JPanel contentPane;

    private main.JImagePanel jImagePanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;

    private final StudentFullDetailModel studentFullDetailModel;

    public StudentDetailDialog(StudentPanel studentPanel, StudentFullDetailModel studentFullDetailModel) {
        setModal(true);
        setLocationRelativeTo(studentPanel);

        this.studentFullDetailModel = studentFullDetailModel;
        setUpStudentProfile();

    }

    private void createUIComponents() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jImagePanel1 = new main.JImagePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jImagePanel1Layout = new javax.swing.GroupLayout(jImagePanel1);
        jImagePanel1.setLayout(jImagePanel1Layout);
        jImagePanel1Layout.setHorizontalGroup(
                jImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jImagePanel1Layout.setVerticalGroup(
                jImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Name:");

        jLabel2.setText("Email:");

        jLabel3.setText("Contact:");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel4");

        jLabel6.setText("jLabel4");

        jLabel7.setText("Department:");

        jLabel8.setText("Level:");

        jLabel9.setText("Semester:");

        jLabel10.setText("jLabel4");

        jLabel11.setText("jLabel4");

        jLabel12.setText("jLabel4");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Personal Info");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Academic Info");

        jLabel15.setText("Enrollment:");

        jLabel16.setText("jLabel4");

        jLabel17.setText("Covered Curriculum");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel15)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(29, 29, 29)
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(35, 35, 35)
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(35, 35, 35)
                                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel13)
                                                                        .addComponent(jLabel14)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel17))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addGap(38, 38, 38)
                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(0, 10, Short.MAX_VALUE))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel16)))
                                        .addComponent(jImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel12)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student Profile", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "Subject", "Eligibility for Final Exam"
                }
        ) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eligibility", jPanel3);

        jLabel18.setText("Department:");

        jLabel19.setText("jLabel4");

        jLabel20.setText("Level:");

        jLabel21.setText("jLabel4");

        jLabel22.setText("Semester:");

        jLabel23.setText("jLabel4");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("CGPA:");

        jLabel25.setForeground(new java.awt.Color(153, 0, 0));
        jLabel25.setText("00");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "Subject", "Exam Id", "Marks", "Grade"
                }
        ) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("SGPA:");

        jLabel27.setForeground(new java.awt.Color(153, 0, 0));
        jLabel27.setText("00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel22)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel18)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel24)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel26)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel26)
                                                .addComponent(jLabel27)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel23))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Academic Performance", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {
        // tab changed:

        int selectedTabIndex = jTabbedPane1.getSelectedIndex();
        switch (selectedTabIndex) {
            case 0:
                if(this.studentFullDetailModel !=null){
                    setUpStudentProfile();
                }
                break;
            case 1:
                setUpEligibility();
                break;
            case 2:
                setUpAcademicPerformance();
                break;
        }
    }

    private void setUpAcademicPerformance() {

        jLabel19.setText(studentFullDetailModel.getDepartment());
        jLabel21.setText(studentFullDetailModel.getLevel());
        jLabel23.setText(studentFullDetailModel.getSemester());
        jLabel25.setText(cgpa());
        jLabel27.setText(sgpa());

        loadAcademicPerformanceTable();
    }

    private String sgpa() {
        // todo
        return "00";
    }

    private String cgpa() {
        // todo
        return "00";
    }

    private void loadAcademicPerformanceTable() {

        String query = "SELECT * FROM `course` " +
                "INNER JOIN `department_has_undergraduate_level` ON `course`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `undergraduate_level` ON `department_has_undergraduate_level`.`undergraduate_level_level_id`=`undergraduate_level`.`level_id` " +
                "INNER JOIN `semester` ON `semester`.`semester_id`=`department_has_undergraduate_level`.`semester_semester_id` " +
                "INNER JOIN `student_has_department_has_undergraduate_level` ON `student_has_department_has_undergraduate_level`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `student` ON `student`.`user_id`=`student_has_department_has_undergraduate_level`.`student_user_id` " +
                "WHERE `student`.`user_id`=?";

        ResultSet resultSet = DBConnection.search(query, studentFullDetailModel.getId());
        if(resultSet!=null) {

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable2.getModel();
            defaultTableModel.setRowCount(0);

            try{

                while(resultSet.next()){

                    String courseId = resultSet.getString("course_id");

                    Vector<Object> row = new Vector<>();
                    row.add(courseId);
                    row.add(resultSet.getString("course"));

                    String q2 = "SELECT * FROM `marks` " +
                            "INNER JOIN `exam` ON `marks`.`exam_exam_id`=`exam`.`exam_id` " +
                            "INNER JOIN `student` ON `student`.`user_id`=`marks`.`student_user_id` " +
                            "INNER JOIN `department_has_undergraduate_level` ON `department_has_undergraduate_level`.`id`=`exam`.`department_has_undergraduate_level_id` " +
                            "INNER JOIN `course` ON `course`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                            "WHERE `student`.`user_id`=? AND `course`.`course_id`=?";
                    ResultSet rs = DBConnection.search(q2, studentFullDetailModel.getId(), courseId);

                    JTable jTable = new JTable();
                    DefaultTableModel tableModel = new DefaultTableModel();
                    jTable.setModel(tableModel);
                    jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                    jTable.addColumn(new TableColumn());

                    ArrayList<String> mal = new ArrayList<>();
                    if(rs!=null) {

                        while (rs.next()){
                            Vector<String> r = new Vector<>();
                            r.add(rs.getString("exam.exam_id"));

                            tableModel.addRow(r);

                            mal.add(rs.getString("marks.marks"));
                        }
                    }
                    row.add(jTable);

                    JTable jTable2 = new JTable();
                    DefaultTableModel tableModel2 = new DefaultTableModel();
                    jTable2.setModel(tableModel2);
                    jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                    jTable2.addColumn(new TableColumn());

                    mal.forEach(mark->{
                        Vector<String> r = new Vector<>();
                        r.add(mark);

                        tableModel2.addRow(r);
                    });
                    row.add(jTable2);

                    JTable jTable3 = new JTable();
                    DefaultTableModel tableModel3 = new DefaultTableModel();
                    jTable3.setModel(tableModel3);
                    jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                    jTable3.addColumn(new TableColumn());

                    mal.forEach(mark->{
                        Vector<String> r = new Vector<>();
                        r.add(gradeMark(Double.parseDouble(mark)));

                        tableModel3.addRow(r);
                    });
                    row.add(jTable3);

                    defaultTableModel.addRow(row);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    private String gradeMark(double mark) {

        if(mark >= 75){
            return "A";
        }
        if(mark <75 && mark >= 50){
            return "B";
        }
        if(mark <50 && mark >= 40){
            return "C";
        }
        if(mark <40 && mark >= 30){
            return "D";
        }
        return "F";

    }

    private void setUpEligibility() {

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.setRowCount(0);

        AtomicInteger i = new AtomicInteger(1);
        studentFullDetailModel.getSubjectList().forEach((courseCode,subject) -> {

            Vector<String> row = new Vector<>();
            row.add(String.valueOf(i.getAndIncrement()));
            row.add(subject);
            row.add(completeEligibility(courseCode));

            defaultTableModel.addRow(row);

        });
    }

    private Double caEligibility(String courseCode) {

        String query = "SELECT * FROM `exam` " +
                "INNER JOIN `exam_type` ON `exam`.`exam_type_type_id`=`exam_type`.`type_id` " +
                "INNER JOIN `department_has_undergraduate_level` ON `exam`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `course` ON `course`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `marks` ON `exam`.`exam_id`=`marks`.`exam_exam_id` " +
                "WHERE `course`.`course_code`=? AND `exam_type`.`type_id`!=?";

        int caUseQuizCount = 0,caUseAssessmentCount = 0;// currentQuizCount = 0,currentAssessmentCount = 0,currentMidCount = 0,totalQuiz = 0,totalAssessment = 0,
        double quizMarksPercentage = 0.0, assessmentMarksPercentage = 0.0, midMarksPercentage = 0.0, midMarks = 0.0;

        ArrayList<Double> quizMarksArrayList = new ArrayList<>();
        ArrayList<Double> assessmentMarksArrayList = new ArrayList<>();

        boolean isFirstRound = true;

        ResultSet resultSet = DBConnection.search(query, courseCode, "4");//4 => final
        if(resultSet !=null) {

            try{

                while(resultSet.next()){

                    if(isFirstRound){
                        quizMarksPercentage = resultSet.getDouble("quiz_marks_percentage");
                        assessmentMarksPercentage = resultSet.getDouble("assessment_marks_percentage");
                        midMarksPercentage = resultSet.getDouble("mid_marks_percentage");

                        caUseQuizCount = resultSet.getInt("ca_use_quiz_count");
                        caUseAssessmentCount = resultSet.getInt("ca_use_assessment_count");

//                    totalQuiz = resultSet.getInt("total_quiz");
//                    totalAssessment = resultSet.getInt("total_assessment");

                        isFirstRound = false;
                    }

                    String examType = resultSet.getString("exam_type.type_id");
                    switch (examType){
                        case "1":{ // quiz

//                        currentQuizCount++;
                            quizMarksArrayList.add(resultSet.getDouble("marks.marks"));

                            break;
                        }
                        case "2":{ // assessment

//                        currentAssessmentCount++;
                            assessmentMarksArrayList.add(resultSet.getDouble("marks.marks"));

                            break;
                        }
                        case "3":{ //mid

//                        currentMidCount++;
                            midMarks = resultSet.getDouble("marks.marks");

                            break;
                        }
                        default:{
                            break;
                        }
                    }

                }

            }catch (SQLException e){
                e.printStackTrace();
            }

            quizMarksArrayList.sort(Collections.reverseOrder());
            assessmentMarksArrayList.sort(Collections.reverseOrder());

            caUseQuizCount = Math.min(caUseQuizCount, quizMarksArrayList.size());
            caUseAssessmentCount = Math.min(caUseAssessmentCount, assessmentMarksArrayList.size());

            List<Double> topMarksQuiz = quizMarksArrayList.subList(0, caUseQuizCount);
            List<Double> topMarksAssessment = assessmentMarksArrayList.subList(0, caUseAssessmentCount);

            // Calculate averages
            double quizAvg = topMarksQuiz.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double assessmentAvg = topMarksAssessment.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            // Calculate final CA marks
            return (quizAvg * quizMarksPercentage / 100.0) +
                    (assessmentAvg * assessmentMarksPercentage / 100.0) +
                    (midMarks * midMarksPercentage / 100.0);

        }

        return 0.0;

    }

    private Double attendanceEligibility(String courseCode){

        String attendanceQuery = "SELECT * FROM `attendance` " +
                "INNER JOIN `timetable` ON `attendance`.`timetable_timetable_id`=`timetable`.`timetable_id` " +
                "INNER JOIN `course` ON `course`.`course_id`=`timetable`.`course_course_id` " +
                "INNER JOIN `attendance_status` ON `attendance`.`attendance_status_id`=`attendance_status`.`id` " +
                "WHERE `course`.`course_code`=? AND `attendance`.`student_user_id`=?";

        String medicalQuery = "SELECT * FROM `medical_record` " +
                "WHERE `student_user_id`=? AND `status_status_id`=?";

        int attendanceCount = 0;
        double fullAttendanceCount = 0;

        ResultSet resultSet = DBConnection.search(attendanceQuery, courseCode, studentFullDetailModel.getId());
        if(resultSet != null){

            try{

                while(resultSet.next()){

                    String attendanceStatusId = resultSet.getString("attendance_status_id");
                    if(attendanceStatusId.equals("1")){// attended

                        attendanceCount++;
                    }else{

                        ResultSet medicalRS = DBConnection.search(medicalQuery,studentFullDetailModel.getId(),"2");
                        if(medicalRS != null){

                            while(resultSet.next()){

                                attendanceCount++;
                            }
                        }
                    }

                    if(fullAttendanceCount == 0){
                        fullAttendanceCount = resultSet.getDouble("course_hours");
                    }
                }

            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        return (attendanceCount / fullAttendanceCount)*100;

    }

    private String completeEligibility(String courseCode){

        double completeEligibility = attendanceEligibility(courseCode) + caEligibility(courseCode);
        if(completeEligibility >= 50){
            return "Eligible";
        }
        return "Not-Eligible";

    }

    private void setUpStudentProfile() {

        String path = "";
        if(studentFullDetailModel.getProfilePicture() == null){
            path = "/resources/designImages/profileIco.png";
        }else{
            path = studentFullDetailModel.getProfilePicture();
        }

        jImagePanel1.setImageIcon(new ImageIcon(getClass().getResource(path)));
        jLabel6.setText(studentFullDetailModel.getUsername());
        jLabel5.setText(studentFullDetailModel.getEmail());
        jLabel4.setText(studentFullDetailModel.getContactNumber());
        jLabel16.setText(studentFullDetailModel.getEnrollmentDate());
        jLabel10.setText(studentFullDetailModel.getDepartment());
        jLabel11.setText(studentFullDetailModel.getLevel());
        jLabel12.setText(studentFullDetailModel.getSemester());

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addAll(studentFullDetailModel.getSubjectList().values());
        jList1.setModel(model);

    }

}
