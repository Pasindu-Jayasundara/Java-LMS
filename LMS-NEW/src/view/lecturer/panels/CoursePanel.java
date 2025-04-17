package view.lecturer.panels;

import controller.DBConnection;
import controller.FileSelect;
import controller.FileUpload;
import controller.Validation;
import model.*;
import view.lecturer.dialog.CourseDetailDialog;
import view.lecturer.LecturerDashboard;
import view.lecturer.dialog.PDFPreviewDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

public class CoursePanel extends JPanel {

    private JPanel panel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
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
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;


    private int timetableRowCount;
    private boolean isFirstTimeTableRow;

    public static HashMap<String, CourseModel> courseHashMap = new HashMap<>();
    public static HashMap<String, DepartmentModel> departmentHashMap = new HashMap<>();
    public static HashMap<String, SemesterModel> semesterHashMap = new HashMap<>();
    public static HashMap<String, UndergraduateLevelModel> levelHashMap = new HashMap<>();

    private static HashMap<String,String> lecturerHashMap = new HashMap<>();

    private HashMap<String, String> selectedPdfFile;
    private CourseModel courseModel;

    private void createUIComponents() {
        initComponents();

        loadCourses("");
        loadLecturers();
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
        jLabel18 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

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
                        "#", "Code", "Name", "Credit", "Days"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(347, 347, 347)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
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
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Courses", jPanel1);

        jLabel2.setText("Course Code:");

        jLabel3.setText("Course Name:");

        jLabel4.setText("Credit:");

        jLabel5.setText("Course Days:");

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

        jLabel18.setText("Lecturer:");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Exam Details");

        jLabel20.setText("Total Quiz:");

        jLabel21.setText("Quize For CA:");

        jLabel22.setText("Assessment For CA:");

        jLabel23.setText("Total Assessment:");

        jLabel24.setText("Quize Marks Percenage:");

        jLabel25.setText("Assessment Marks Percenage:");

        jLabel26.setText("Mid Exam Percentage:");

        jLabel27.setText("Final Theory Exam Percentage:");

        jLabel28.setText("Final Practical Exam Percentage:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel14)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel18)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jTextField3))
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel4)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel20)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel23)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel22)
                                                                        .addComponent(jLabel21))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel25)
                                                                        .addComponent(jLabel24)
                                                                        .addComponent(jLabel26)
                                                                        .addComponent(jLabel27)
                                                                        .addComponent(jLabel28))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(204, 204, 204))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel20)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel23)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(139, 139, 139)
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
                                                .addComponent(jButton4))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel21)
                                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel22)
                                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel24)
                                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel25)
                                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel26)
                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel27)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel28)
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add New Course", jPanel2);

        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        jLabel15.setText("Select Course:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel16.setText("Meterial Type:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF" }));

        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Selected File Name ....");

        jButton6.setText("Choose File");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 102, 0));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Upload");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "#", "File Name", "Uploaded At", "", ""
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6)
                                        .addComponent(jButton7))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton8)
                                                .addGap(69, 69, 69)
                                                .addComponent(jButton9))
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16)
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8)
                                        .addComponent(jButton9))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 257, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Course Materials ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        if (!Validation.isValidTime(from)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Time From", "Invalid Time", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!Validation.isValidTime(to)) {
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

        if (isCourseDetailsCorrect()) {

            String newCourseCode = jTextField2.getText();
            String newCourseName = jTextField3.getText();
            String credit = jTextField4.getText();
            String hours = jTextField5.getText();

            String department = String.valueOf(jComboBox1.getSelectedItem());
            String level = String.valueOf(jComboBox2.getSelectedItem());
            String semester = String.valueOf(jComboBox3.getSelectedItem());

            String lecturer = String.valueOf(jComboBox7.getSelectedItem());
            AtomicReference<String> lecturerId = new AtomicReference<>("");
            String totalQuiz = jTextField6.getText();
            String totalAssessment = jTextField8.getText();
            String quizForCa = jTextField7.getText();
            String assessmentForCa = jTextField9.getText();
            String quizMarksPercentage = jTextField10.getText();
            String assessmentMarksPercentage = jTextField11.getText();
            String midExamMarksPercentage = jTextField12.getText();
            String finalTheoryExamMarksPercentage = jTextField13.getText();
            String finalPracticalExamMarksPercentage = jTextField14.getText();

            lecturerHashMap.forEach((lecturerName, lecturerIds) -> {

                if(lecturerName.equals(lecturer)){
                    lecturerId.set(lecturerIds);
                }
            });

            // department has undergraduate level table
            String q1 = "SELECT * FROM `department_has_undergraduate_level` " +
                    "INNER JOIN `department` ON `department`.`department_id`=`department_has_undergraduate_level`.`department_department_id` " +
                    "INNER JOIN `semester` ON `semester`.`semester_id`=`department_has_undergraduate_level`.`semester_semester_id` " +
                    "INNER JOIN `undergraduate_level` ON `undergraduate_level`.`level_id`=`department_has_undergraduate_level`.`undergraduate_level_level_id` " +
                    "WHERE `department`.`name`=? AND `undergraduate_level`.`level`=? AND `semester`.`semester`=? AND `status_status_id`=? ";
            ResultSet resultSet = DBConnection.search(q1, department, level, semester, '1');
            if (resultSet != null) {

                try {
                    resultSet.last();
                    int row = resultSet.getRow();
                    resultSet.first();

                    String dhulID = "";

                    if (row == 0) {

                        String q2 = "INSERT INTO `department_has_undergraduate_level`(`department_department_id`,`undergraduate_level_level_id`,`semester_semester_id`,`status_status_id) " +
                                "VALUES(?,?,?,?)";

                        Integer insertedId = DBConnection.iud(q2, departmentHashMap.get(department), levelHashMap.get(level), semesterHashMap.get(semester), '1');
                        dhulID = String.valueOf(insertedId);

                    } else {
                        dhulID = resultSet.getString("department_has_undergraduate_level.id");
                    }

                    // course table
                    String query = "INSERT INTO " +
                            "`course`(`course`,`credit`,`course_code`,`course_hours`,`department_has_undergraduate_level_id`,`lecturer_user_id`,`total_quiz`,`total_assessment`,`ca_use_quiz_count`," +
                            "`ca_use_assessment_count`,`quiz_marks_percentage`,`assessment_marks_percentage`,`mid_marks_percentage`,`final_theory_marks_percentage`,`final_practical_marks_percentage`) " +
                            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    Integer courseId = DBConnection.iud(query, newCourseName, credit, newCourseCode, dhulID,
                            lecturerId,totalQuiz,totalAssessment,quizForCa,assessmentForCa,quizMarksPercentage,
                            assessmentMarksPercentage,midExamMarksPercentage,finalTheoryExamMarksPercentage,finalPracticalExamMarksPercentage);

                    // course hashmap
                    String departmentId = departmentHashMap.get(department).getId();
                    String semesterId = semesterHashMap.get(semester).getId();
                    String undergraduateLevelId = levelHashMap.get(level).getId();

                    addToCourseHashMap(departmentId, department, semesterId, semester, undergraduateLevelId, level, dhulID, newCourseCode, String.valueOf(courseId), newCourseName, credit, hours);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // all course table click

        if (evt.getClickCount() == 2) {

            String courseCode = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2));
            if (courseHashMap.containsKey(courseCode)) {

                CourseModel courseModel = courseHashMap.get(courseCode);

                CourseDetailDialog courseDetailDialog = new CourseDetailDialog(this, courseModel);
                courseDetailDialog.setVisible(true);
            }
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // choose material:

        selectedPdfFile = FileSelect.getPDFFile();
        if (selectedPdfFile.get("pdf").equals("1")) {
            jLabel17.setText(selectedPdfFile.get("filename"));
        }
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // upload:

        if(selectedPdfFile != null) {

            HashMap<String, String> uploaded = FileUpload.upload(selectedPdfFile,FileUpload.PDF_FILE);
            if(uploaded.get("status").equals(FileUpload.SUCCESS)){

                String query = "INSERT INTO `material`(`datetime`,`url`,`course_course_id`,`type_type_id`,`name`) " +
                        "VALUES(?,?,?,?,?)";

                DBConnection.iud(
                        query,
                        new SimpleDateFormat("yyyy-MM-dd HH:ii:ss").format(new Date()),
                        uploaded.get("url"),
                        courseModel.getCourseId(),
                        '1',
                        selectedPdfFile.get("filename")
                );

                loadCourseMaterials();

                JOptionPane.showMessageDialog(this,"File Upload Success","Success",JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(this,"File Upload Failed","Failed",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {
        // select course change:

        loadCourseMaterials();
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // search material:

        loadCourseMaterials();
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // reset search material:

        jComboBox5.setSelectedIndex(0);
        jLabel17.setText("Selected File Name ....");
        selectedPdfFile = null;

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

    }

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {
        // add material panel focus gained:

        loadCourseNameList();
    }

    private void loadLecturers() {

        String query = "SELECT * FROM `lecturer` WHERE `status_status_id`=?";
        ResultSet resultSet = DBConnection.search(query, "1");

        if(resultSet != null){

            Vector<String> v = new Vector<>();
            try{

                while(resultSet.next()){

                    String username = resultSet.getString("username");
                    String userId = resultSet.getString("user_id");

                    v.add(username);
                    lecturerHashMap.put(username,userId);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>(v);
            jComboBox7.setModel(defaultComboBoxModel);

        }

    }

    private void removeMaterial(String materialId, String url, String name) {
        // remove material:

        File fileToDelete = new File(url);

        if (fileToDelete.exists()) {

            boolean deleted = fileToDelete.delete();
            if (deleted) {

                String query = "DELETE FROM `material` WHERE `material_id`=?";
                DBConnection.iud(query, materialId);

                loadCourseMaterials();

                JOptionPane.showMessageDialog(this,"File Deleted","Success",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,"Failed to delete the file: " + name,"Failed",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,"File Not Found","File Not Found",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void loadPreview(String url) {
        // preview material:

        PDFPreviewDialog pdfPreviewDialog = new PDFPreviewDialog(CoursePanel.this,url);
        pdfPreviewDialog.setVisible(true);

    }

    private void loadCourseNameList() {

        Vector<String> vector = new Vector<>();
        vector.add("Select course");

        courseHashMap.forEach((key, courseModel) -> {

            vector.add(courseModel.getCourseName());
        });

        jComboBox5.setModel(new DefaultComboBoxModel(vector));
        jComboBox5.setSelectedIndex(0);

    }

    private void loadCourseMaterials() {

        if (jComboBox5.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please select a course first", "Select Course", JOptionPane.WARNING_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);

            return;
        }

        String selectedCourse = String.valueOf(jComboBox5.getSelectedItem());
        courseHashMap.forEach((key, courseModel) -> {

            if (courseModel.getCourseName().equals(selectedCourse)) {

                this.courseModel = courseModel;

                String query = "SELECT * FROM `material` INNER JOIN `course` ON `course`.`course_id`=`material`.`course_course_id` " +
                        "WHERE `course`.`course_code`=?";

                ResultSet resultSet = DBConnection.search(query, courseModel.getCourseCode());
                if (resultSet != null) {

                    DefaultTableModel defaultTableModel = (DefaultTableModel) jTable3.getModel();
                    defaultTableModel.setRowCount(0);

                    try {

                        while (resultSet.next()) {

                            String materialId = resultSet.getString("material_id");
                            String url = resultSet.getString("url");
                            String name = resultSet.getString("name");

                            Vector<Object> materialList = new Vector<>();
                            materialList.add(materialId);
                            materialList.add(name);
                            materialList.add(resultSet.getString("datetime"));

                            JButton previewBtn = new JButton("Preview");
                            previewBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    loadPreview(url);
                                }
                            });
                            materialList.add(previewBtn);

                            JButton deleteBtn = new JButton("Remove");
                            deleteBtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    removeMaterial(materialId, url,name);
                                }
                            });
                            materialList.add(deleteBtn);

                            defaultTableModel.addRow(materialList);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }

    private boolean isCourseDetailsCorrect() {

        String newCourseCode = jTextField2.getText();
        String newCourseName = jTextField3.getText();
        String credit = jTextField4.getText();
        String hours = jTextField5.getText();

        int lecturer = jComboBox7.getSelectedIndex();
        String totalQuiz = jTextField6.getText();
        String totalAssessment = jTextField8.getText();
        String quizForCa = jTextField7.getText();
        String assessmentForCa = jTextField9.getText();
        String quizMarksPercentage = jTextField10.getText();
        String assessmentMarksPercentage = jTextField11.getText();
        String midExamMarksPercentage = jTextField12.getText();
        String finalTheoryExamMarksPercentage = jTextField13.getText();
        String finalPracticalExamMarksPercentage = jTextField14.getText();

        if (newCourseCode.isBlank()) {
            JOptionPane.showMessageDialog(this, "Course Code Cannot be Empty", "Missing Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (newCourseName.isBlank()) {
            JOptionPane.showMessageDialog(this, "Course Name Cannot be Empty", "Missing Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (credit.isBlank()) {
            JOptionPane.showMessageDialog(this, "Course Credit Cannot be Empty", "Missing Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (hours.isBlank()) {
            JOptionPane.showMessageDialog(this, "Course Hours Cannot be Empty", "Missing Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(credit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Course Credit Must Be a Number", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.parseDouble(hours);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Course Hours Must Be a Number", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (courseHashMap.containsKey(newCourseCode)) {
            JOptionPane.showConfirmDialog(this, "Course Code Already Exists", "Invalid Course Code", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (lecturer == 0) {
            JOptionPane.showConfirmDialog(this, "Please Select Lecturer", "Missing Lecturer", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (totalQuiz.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Total Quiz", "Invalid Total Quiz", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(totalQuiz);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Total Quiz Count Must Be a Number", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (totalAssessment.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Total Assessment", "Invalid Total Assessment", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(totalAssessment);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Total Assessment Count Must Be a Number", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (quizForCa.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing CA Quiz", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(quizForCa);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Total Quiz for CA Count Must Be a Number", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (assessmentForCa.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing CA Assessment", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(assessmentForCa);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Total Assessment for CA Count Must Be a Number", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (quizMarksPercentage.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Quiz Marks Percentage", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.parseDouble(quizMarksPercentage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Quiz Marks Percentage", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (assessmentMarksPercentage.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Assessment Marks Percentage", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.parseDouble(assessmentMarksPercentage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Assessment Marks Percentage", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (midExamMarksPercentage.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Mid Exam Marks Percentage", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.parseDouble(midExamMarksPercentage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Mid Exam Marks Percentage", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (finalTheoryExamMarksPercentage.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Final Theory Marks Percentage", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.parseDouble(finalTheoryExamMarksPercentage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Final Theory Exam Marks Percentage", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (finalPracticalExamMarksPercentage.isBlank()) {
            JOptionPane.showConfirmDialog(this, "Missing Final Practical Marks Percentage", "Missing Details", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Double.parseDouble(finalPracticalExamMarksPercentage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Final Practical Exam Marks Percentage", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

    private void loadCourses(String enteredCourseCode) {

        if (courseHashMap.isEmpty()) {
            loadCoursesFormDB(enteredCourseCode);
        } else {
            loadCoursesFromHashMap(enteredCourseCode);
        }

    }

    private void loadCoursesFromHashMap(String enteredCourseCode) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.setRowCount(0);

        courseHashMap.forEach((key, courseModel) -> {

            Vector<String> row = new Vector<>();

            if (enteredCourseCode.isBlank()) {

                row.add(courseModel.getCourseId());
                row.add(courseModel.getCourseCode());
                row.add(courseModel.getCourseName());
                row.add(courseModel.getCredit());
                row.add(courseModel.getHours());

            } else {

                if (enteredCourseCode.equals(courseModel.getCourseCode())) {

                    row.add(courseModel.getCourseId());
                    row.add(courseModel.getCourseCode());
                    row.add(courseModel.getCourseName());
                    row.add(courseModel.getCredit());
                    row.add(courseModel.getHours());
                }

            }

            defaultTableModel.addRow(row);

        });

    }

    private void loadCoursesFormDB(String enteredCourseCode) {

        String code = "%"+enteredCourseCode+"%";
        String query = "SELECT * FROM `course` WHERE `lecturer_user_id`=? AND `course_code` LIKE ? ";

        ResultSet resultSet = DBConnection.search(query, LecturerDashboard.loginLecturerModel.getId(), code);
        if (resultSet == null) {
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
                addToCourseHashMap(departmentId, department, semesterId, semester, undergraduateLevelId, undergraduateLevel, dhulId, courseCode, courseId, courseName, credit, courseHours);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void addToCourseHashMap(String departmentId, String department, String semesterId, String semester, String undergraduateLevelId, String undergraduateLevel, String dhulId, String courseCode, String courseId, String courseName, String credit, String courseHours) {
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

        courseHashMap.put(courseCode, courseModel);
    }
}
