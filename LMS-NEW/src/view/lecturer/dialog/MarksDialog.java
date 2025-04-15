package view.lecturer.dialog;

import controller.DBConnection;
import controller.FileSelect;
import controller.FileUpload;
import controller.callback.MarksUpdateCallBack;
import model.ExamModel;
import view.lecturer.panels.ExamPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class MarksDialog extends JDialog {
    private JPanel contentPane;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;

    private ExamModel examModel;
    private HashMap<String,String> pdfFile;
    private MarksUpdateCallBack marksUpdateCallBack;

    public MarksDialog(ExamPanel examPanel, ExamModel examModel, MarksUpdateCallBack marksUpdateCallBack) {

        setLocationRelativeTo(examPanel);
        setModal(true);

        this.examModel = examModel;
        this.marksUpdateCallBack = marksUpdateCallBack;
    }

    private void createUIComponents() {
        initComponents();

        setUpBg();
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
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Exam Marks");

        jButton1.setText("Choose Marks File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Mark File Name ...");
        jLabel11.setEnabled(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "File Name", "", ""
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3))
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1)
                                        .addComponent(jLabel10)
                                        .addComponent(jScrollPane3))
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
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jLabel11)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void setUpBg() {

        jLabel2.setText(examModel.getId());
        jLabel8.setText(examModel.getDateTime());
        jLabel4.setText(examModel.getCourseName());
        jLabel6.setText(examModel.getCourseCode());
        jTextArea1.setText(examModel.getDescription());
        jLabel11.setText("Marks File Name ...");


        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable2.getModel();
        defaultTableModel.setRowCount(0);

        AtomicInteger i = new AtomicInteger(1);
        examModel.getMarksModel().forEach(marksModel->{

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

        String query = "DELETE FROM `marks` WHERE `id` =?";
        DBConnection.iud(query,id);

        // load table
        marksUpdateCallBack.onUpdateMarks(true);
        setUpBg();
    }

    private void previewFile(String url) {
        PDFPreviewDialog pdfPreviewDialog = new PDFPreviewDialog(MarksDialog.this,url);
        pdfPreviewDialog.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // choose file

        pdfFile = FileSelect.getPDFFile();
        jLabel11.setText(pdfFile.get("filename"));

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // clear
        setUpBg();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // upload

        HashMap<String, String> uploadMap = FileUpload.upload(pdfFile,FileUpload.PDF_FILE);

        if(uploadMap.get("status").equals(FileUpload.SUCCESS)){
            // success
            // add to db
            // update table

            String query = "INSERT INTO `marks`(`url`,`file_name`,`exam_exam_id`) VALUES(?,?,?)";
            DBConnection.iud(query,uploadMap.get("url"),pdfFile.get("filename"),examModel.getId());

            JOptionPane.showMessageDialog(this,"Marks added successfully","Success",JOptionPane.INFORMATION_MESSAGE);
            setUpBg();

            marksUpdateCallBack.onUpdateMarks(true);

        }else{
            // failed
            JOptionPane.showMessageDialog(this,"Marks added failed","Failed",JOptionPane.ERROR_MESSAGE);

        }
    }
}
