package view.lecturer.panels;

import javax.swing.*;

public class NoticeItem extends JPanel {
    private JPanel contentPane;

    private javax.swing.JLabel noticeTitle;
    private javax.swing.JLabel postTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea content;

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle.setText(noticeTitle);
    }

    public void setPostTime(String postTime) {
        this.postTime.setText(postTime);
    }

    public void setContent(String content) {
        this.content.setText(content);
    }

    private void createUIComponents() {
        initComponents();
    }

    private void initComponents() {

        noticeTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();
        postTime = new javax.swing.JLabel();

        noticeTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        noticeTitle.setText("jLabel1");

        content.setColumns(20);
        content.setRows(5);
        content.setEnabled(false);
        jScrollPane1.setViewportView(content);

        postTime.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        postTime.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        postTime.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(noticeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                                                .addComponent(postTime, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(noticeTitle)
                                        .addComponent(postTime))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>
}
