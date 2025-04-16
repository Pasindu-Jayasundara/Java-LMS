package view.lecturer.dialog;

import controller.DBConnection;
import controller.FileSelect;
import controller.FileUpload;
import controller.callback.MarksUpdateCallBack;
import model.ExamModel;
import model.IndividualMarksModel;
import view.lecturer.panels.ExamPanel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MarksDialog extends JDialog {
    private JPanel contentPane;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;

    private ExamModel examModel;
    private HashMap<String, String> pdfFile;
    private MarksUpdateCallBack marksUpdateCallBack;

    private static HashMap<String, String> individualMarksChangedHashMap = new HashMap<>();
    private static ArrayList<IndividualMarksModel> individualMarksModelArrayList = new ArrayList<>();

    public MarksDialog(ExamPanel examPanel, ExamModel examModel, MarksUpdateCallBack marksUpdateCallBack) {

        setLocationRelativeTo(examPanel);
        setModal(true);

        this.examModel = examModel;
        this.marksUpdateCallBack = marksUpdateCallBack;
    }

    private void createUIComponents() {
        initComponents();
        setUpMarksFileTab();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Exam Id:");

        jLabel2.setText("jLabel2");

        jLabel3.setText("Course:");

        jLabel4.setText("jLabel2");

        jLabel5.setText("Course Code:");

        jLabel6.setText("jLabel2");

        jLabel7.setText("Exam Date & Time:");

        jLabel8.setText("jLabel2");

        jLabel9.setText("Description:");

        jScrollPane1.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jButton1.setText("Choose Marks File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Mark File Name ...");
        jLabel11.setEnabled(false);

        jButton2.setText("Clear");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Upload");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "#", "File Name", "", ""
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jLabel11)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Marks Files", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "#", "Reg Number", "Name", "Marks"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jButton4.setBackground(new java.awt.Color(0, 102, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton4)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Add Individual Marks", jPanel3);

        jLabel12.setText("Exam Type:");

        jLabel13.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTabbedPane1)
                                        .addComponent(jLabel9)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel12)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addGap(19, 19, 19)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // choose file

        HashMap<String, String> pdfFile1 = FileSelect.getPDFFile();
        if (pdfFile1.get("pdf").equals("1")) {
            pdfFile = pdfFile1;

            jButton2.setEnabled(true);
            jButton3.setEnabled(true);

        }
        jLabel11.setText(pdfFile.get("filename"));

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // clear
        setUpMarksFileTab();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // upload

        HashMap<String, String> uploadMap = FileUpload.upload(pdfFile, FileUpload.PDF_FILE);

        if (uploadMap.get("status").equals(FileUpload.SUCCESS)) {
            // success
            // add to db
            // update table

            String query = "INSERT INTO `marks_document`(`url`,`file_name`,`exam_exam_id`) VALUES(?,?,?)";
            DBConnection.iud(query, uploadMap.get("url"), pdfFile.get("filename"), examModel.getId());

            JOptionPane.showMessageDialog(this, "Marks File added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            setUpMarksFileTab();

            marksUpdateCallBack.onUpdateMarks(true);

        } else {
            // failed
            JOptionPane.showMessageDialog(this, "Marks File adding failed", "Failed", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {
        // tab changed:

        int selectedTabIndex = jTabbedPane1.getSelectedIndex();
        if (selectedTabIndex == 0) {
            setUpMarksFileTab();
        } else if (selectedTabIndex == 1) {
            setUpAddIndividualMarksTab();
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // upload individual marks:

        String updateQuery = "UPDATE `marks` SET `marks`.`marks`=? WHERE `student_user_id`=? AND `exam_exam_id`=?";
        String insertQuery = "INSERT INTO `marks`(`student_user_id`,`exam_exam_id`,`marks`) VALUES(?,?,?)";

        individualMarksChangedHashMap.forEach((studentId,marks)->{

            AtomicBoolean isFound = new AtomicBoolean(false);
            individualMarksModelArrayList.forEach(individualMarksModel -> {

                if(individualMarksModel.getStudentRegisterNumber().equals(studentId)){
                    isFound.set(true);
                    return;
                }
            });

            if(isFound.get()){
                DBConnection.iud(updateQuery,marks,studentId,examModel.getId());
            }else{
                DBConnection.iud(insertQuery,marks,studentId,examModel.getId());
            }
        });

        JOptionPane.showMessageDialog(this,"Marks Update Success","Done",JOptionPane.INFORMATION_MESSAGE);
    }

    private void setUpAddIndividualMarksTab() {

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.setRowCount(0);

        addListenerToTable(defaultTableModel);
        loadTable(defaultTableModel);

    }

    private void loadTable(DefaultTableModel defaultTableModel) {

        String query = "SELECT * FROM `student` " +
                "INNER JOIN `student_has_department_has_undergraduate_level` ON `student_has_department_has_undergraduate_level`.`student_user_id`=`student`.`user_id`  " +
                "INNER JOIN `department_has_undergraduate_level` ON `student_has_department_has_undergraduate_level`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "INNER JOIN `exam` ON `exam`.`department_has_undergraduate_level_id`=`department_has_undergraduate_level`.`id` " +
                "WHERE `exam`.`id`=?";

        ResultSet resultSet = DBConnection.search(query, examModel.getId());
        if (resultSet != null) {

            int num = 1;
            try {

                while (resultSet.next()) {

                    String regNumber = resultSet.getString("user_id");
                    String name = resultSet.getString("username");
                    String marks = "";

                    String marksQuery = "SELECT * FROM `marks` WHERE `exam_exam_id`=?";
                    ResultSet marksResultset = DBConnection.search(marksQuery, examModel.getId());
                    if (marksResultset != null) {

                        while (marksResultset.next()) {
                            marks = marksResultset.getString("marks");
                        }
                    }

                    Vector<String> row = new Vector<>();
                    row.add(String.valueOf(num++));
                    row.add(regNumber);
                    row.add(name);
                    row.add(marks);

                    defaultTableModel.addRow(row);

                    // array list
                    IndividualMarksModel individualMarksModel = new IndividualMarksModel();
                    individualMarksModel.setStudentRegisterNumber(regNumber);
                    individualMarksModel.setName(name);
                    individualMarksModel.setMarks(marks);

                    individualMarksModelArrayList.add(individualMarksModel);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void addListenerToTable(DefaultTableModel defaultTableModel) {

        defaultTableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                if (e.getType() == TableModelEvent.UPDATE) {

                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    String studentId = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1));

                    String newValue = (String) defaultTableModel.getValueAt(row, column);
                    if (newValue == null || newValue.trim().isBlank()) {

                        individualMarksChangedHashMap.remove(studentId);
                        return;
                    }
                    individualMarksChangedHashMap.put(studentId, newValue);

                }
            }
        });
    }

    private void setUpMarksFileTab() {

        jLabel2.setText(examModel.getId());
        jLabel8.setText(examModel.getDateTime());
        jLabel4.setText(examModel.getCourseName());
        jLabel6.setText(examModel.getCourseCode());
        jTextArea1.setText(examModel.getDescription());
        jLabel13.setText(examModel.getExamType());
        jLabel11.setText("Marks File Name ...");


        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable2.getModel();
        defaultTableModel.setRowCount(0);

        AtomicInteger i = new AtomicInteger(1);
        examModel.getMarksModel().forEach(marksModel -> {

            JButton viewMarksButton = new JButton("View Marks");
            viewMarksButton.addActionListener(e -> {
                previewFile(marksModel.getUrl());
            });

            JButton deleteFileButton = new JButton("Delete File");
            deleteFileButton.addActionListener(e -> {
                deleteFile(marksModel.getId());
            });

            Vector<Object> row = new Vector<>();
            row.add(i.getAndIncrement());
            row.add(marksModel.getFileName());
            row.add(viewMarksButton);
            row.add(deleteFileButton);

            defaultTableModel.addRow(row);

        });

    }

    private void deleteFile(String id) {

        String query = "DELETE FROM `marks_document` WHERE `id` =?";
        DBConnection.iud(query, id);

        // load table
        marksUpdateCallBack.onUpdateMarks(true);
        setUpMarksFileTab();
    }

    private void previewFile(String url) {
        PDFPreviewDialog pdfPreviewDialog = new PDFPreviewDialog(MarksDialog.this, url);
        pdfPreviewDialog.setVisible(true);
    }
}
