package view.lecturer;

import model.LecturerModel;
import view.common.Welcome;

import javax.swing.*;

public class LecturerDashboard extends JFrame {

    public static LecturerModel loginLecturerModel;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private view.lecturer.panels.ProfilePanel profilePanel1;

    // panels
    private view.lecturer.panels.AttendancePanel attendancePanel1;
    private view.lecturer.panels.CoursePanel coursePanel1;
    private view.lecturer.panels.ExamPanel examPanel1;
    private view.lecturer.panels.NoticePanel noticePanel1;
    private view.lecturer.panels.StudentPanel studentPanel1;

    public LecturerDashboard(LecturerModel loginLecturerModel) {
        LecturerDashboard.loginLecturerModel = loginLecturerModel;
    }

    private void createUIComponents() {
        initComponents();
        changeUI("course");
    }

    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        profilePanel1 = new view.lecturer.panels.ProfilePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setDividerLocation(150);
        jSplitPane2.setDividerSize(3);

        jButton1.setText("Course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exam");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Attendance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("UOR Lecturer");

        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Notices");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton5)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5)
                                        .addComponent(jButton6))
                                .addContainerGap())
        );

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel3.setLayout(new java.awt.CardLayout());
        jPanel3.add(profilePanel1, "card2");

        jScrollPane1.setViewportView(jPanel3);

        jSplitPane2.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // course
        changeUI("course");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // exam
        changeUI("exam");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // student
        changeUI("student");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // attendance
        changeUI("attendance");
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // notice
        changeUI("notice");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // logout
        new Welcome().setVisible(true);
        this.dispose();
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // settings
        changeUI("setting");
    }

    private void changeUI(String type){

        switch(type){
            case "course":{

                // panels
                attendancePanel1.setVisible(false);
                examPanel1.setVisible(false);
                noticePanel1.setVisible(false);
                studentPanel1.setVisible(false);
                profilePanel1.setVisible(false);

                coursePanel1.setVisible(true);

                // buttons
                jButton2.setSelected(false);
                jButton3.setSelected(false);
                jButton4.setSelected(false);
                jButton5.setSelected(false);
                jButton6.setSelected(false);
                jButton7.setSelected(false);

                jButton1.setSelected(true);

                break;
            }
            case "exam":{

                // panels
                attendancePanel1.setVisible(false);
                coursePanel1.setVisible(false);
                noticePanel1.setVisible(false);
                studentPanel1.setVisible(false);
                profilePanel1.setVisible(false);

                examPanel1.setVisible(true);

                // buttons
                jButton1.setSelected(false);
                jButton3.setSelected(false);
                jButton4.setSelected(false);
                jButton5.setSelected(false);
                jButton6.setSelected(false);
                jButton7.setSelected(false);

                jButton2.setSelected(true);

                break;
            }
            case "notice":{

                // panels
                attendancePanel1.setVisible(false);
                examPanel1.setVisible(false);
                studentPanel1.setVisible(false);
                coursePanel1.setVisible(false);
                profilePanel1.setVisible(false);

                noticePanel1.setVisible(true);

                // buttons
                jButton1.setSelected(false);
                jButton2.setSelected(false);
                jButton3.setSelected(false);
                jButton4.setSelected(false);
                jButton5.setSelected(false);
                jButton6.setSelected(false);

                jButton7.setSelected(true);

                break;
            }
            case "student":{

                attendancePanel1.setVisible(false);
                examPanel1.setVisible(false);
                noticePanel1.setVisible(false);
                coursePanel1.setVisible(false);
                profilePanel1.setVisible(false);

                studentPanel1.setVisible(true);

                // buttons
                jButton1.setSelected(false);
                jButton2.setSelected(false);
                jButton4.setSelected(false);
                jButton5.setSelected(false);
                jButton6.setSelected(false);
                jButton7.setSelected(false);

                jButton3.setSelected(true);

                break;
            }
            case "attendance":{

                examPanel1.setVisible(false);
                noticePanel1.setVisible(false);
                studentPanel1.setVisible(false);
                coursePanel1.setVisible(false);
                profilePanel1.setVisible(false);

                attendancePanel1.setVisible(true);

                // buttons
                jButton1.setSelected(false);
                jButton2.setSelected(false);
                jButton3.setSelected(false);
                jButton5.setSelected(false);
                jButton6.setSelected(false);
                jButton7.setSelected(false);

                jButton4.setSelected(true);

                break;
            }
            case "setting":{

                examPanel1.setVisible(false);
                noticePanel1.setVisible(false);
                studentPanel1.setVisible(false);
                coursePanel1.setVisible(false);
                attendancePanel1.setVisible(false);

                profilePanel1.setVisible(true);

                // buttons
                jButton1.setSelected(false);
                jButton2.setSelected(false);
                jButton3.setSelected(false);
                jButton4.setSelected(false);
                jButton5.setSelected(false);
                jButton7.setSelected(false);

                jButton6.setSelected(true);

                break;
            }
            default:{
                break;
            }
        }

    }

}
