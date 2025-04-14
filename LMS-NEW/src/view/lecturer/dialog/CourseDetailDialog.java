package view.lecturer.dialog;

import controller.DBConnection;
import model.CourseMaterialModel;
import model.CourseModel;
import view.lecturer.panels.CoursePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

public class CourseDetailDialog extends JDialog {
    private JPanel contentPane;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;

    private CourseModel courseModel;
    private HashMap<String, CourseMaterialModel> courseMaterialModelHashMap = new HashMap<>();

    public CourseDetailDialog(CoursePanel parent, CourseModel courseModel) {
        setLocationRelativeTo(parent);
        setModal(true);

        this.courseModel = courseModel;
    }

    private void createUIComponents() {
        initComponents();
        loadData();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Course:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setText("Department:");

        jLabel4.setText("Level:");

        jLabel5.setText("Semester:");

        jLabel6.setText("Code:");

        jLabel7.setText("Credit:");

        jLabel8.setText("Hours:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Timetable");

        jLabel10.setText("jLabel2");

        jLabel11.setText("jLabel2");

        jLabel12.setText("jLabel2");

        jLabel13.setText("jLabel2");

        jLabel14.setText("jLabel2");

        jLabel15.setText("jLabel2");

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
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Course Meterials");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "Type", "Name", " ", " "
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setEnabled(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(145, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel5))
                                                        .addComponent(jSeparator1)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel13))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel10))
                                .addGap(25, 25, 25)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void loadData() {

        jLabel2.setText(courseModel.getCourseName());
        jLabel15.setText(courseModel.getCourseCode());
        jLabel14.setText(courseModel.getCredit());
        jLabel13.setText(courseModel.getHours());
        jLabel12.setText(courseModel.getDepartmentHasUndergraduateLevelModel().getDepartment().getName());
        jLabel11.setText(courseModel.getDepartmentHasUndergraduateLevelModel().getUndergraduateLevel().getLevel());
        jLabel10.setText(courseModel.getDepartmentHasUndergraduateLevelModel().getSemester().getSemester());

        loadTimeTable(courseModel.getCourseId());

        loadMaterialList(courseModel.getCourseId());

    }

    private void loadMaterialList(String courseId) {

        String query = "SELECT * FROM `material` INNER JOIN `type` ON `material`.`type_type_id`=`type`.`type_id` " +
                "WHERE `course_course_id`=?";
        ResultSet resultSet = DBConnection.search(query, courseId);

        if(resultSet != null) {

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable3.getModel();
            defaultTableModel.setRowCount(0);

            try{

                while(resultSet.next()){

                    JButton previewBtn = new JButton("Preview");
                    previewBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                previewPDFMaterial(resultSet.getString("material_id"));
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });

                    JButton deleteBtn = new JButton("Delete");
                    deleteBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                deleteMaterial(resultSet.getString("material_id"),resultSet.getString("name"));
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });

                    String materialId = resultSet.getString("material_id");
                    String type = resultSet.getString("type.type");
                    String name = resultSet.getString("name");

                    Vector<Object> row = new Vector<>();
                    row.add(materialId);
                    row.add(type);
                    row.add(name);
                    row.add(previewBtn);
                    row.add(deleteBtn);

                    defaultTableModel.addRow(row);

                    // hash map
                    CourseMaterialModel courseMaterialModel = new CourseMaterialModel();
                    courseMaterialModel.setId(materialId);
                    courseMaterialModel.setName(name);
                    courseMaterialModel.setType(type);

                    courseMaterialModelHashMap.put(materialId, courseMaterialModel);

                }

            }catch (SQLException e){
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void deleteMaterial(String materialId, String name) {

        int confirmDialog = JOptionPane.showConfirmDialog(this, "Are You Sure, You Want to Delete Material: " + name + "?");
        if(confirmDialog == JOptionPane.YES_OPTION) {

            String query = "DELETE FROM `material` WHERE `material_id`=?";
            DBConnection.iud(query, materialId);

            updateCourseMaterialTable(materialId);

        }

    }

    private void updateCourseMaterialTable(String materialId) {

    }

    private void previewPDFMaterial(String filePath) {

        PDFPreviewDialog previewDialog = new PDFPreviewDialog(CourseDetailDialog.this, filePath);
        previewDialog.setVisible(true);

    }

    private void loadTimeTable(String courseId) {

        String query = "SELECT * FROM `timetable` WHERE `course_course_id`=?";
        ResultSet resultSet = DBConnection.search(query, courseId);
        if (resultSet != null) {

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTable2.getModel();
            defaultTableModel.setRowCount(0);

            try{

                while(resultSet.next()){

                    Vector<String> row = new Vector<>();
                    row.add(resultSet.getString("day"));
                    row.add(resultSet.getString("from"));
                    row.add(resultSet.getString("to"));

                    defaultTableModel.addRow(row);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO remove material from list:
    }

}
