package view.lecturer.panels;

import controller.common.DBConnection;
import controller.lecturer.NoticeListRenderer;
import model.CustomNoticeListModel;
import model.NoticeListItemModel;

import javax.swing.*;
import java.sql.ResultSet;

public class NoticePanel extends JPanel{

    private JPanel panel1;

    private JList<NoticeListItemModel> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jButton1;

    private void createUIComponents() {
        initComponents();
        loadNotices();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

//        jList1.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Reload Notices");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton1)
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // reload
        loadNotices();
    }


    private void loadNotices() {
        String query = "SELECT * FROM `notice` WHERE `status_status_id`=? ORDER BY `post_date` DESC";
        ResultSet resultSet = DBConnection.search(query, 1);

        if (resultSet != null) {
            CustomNoticeListModel model = new CustomNoticeListModel();
            model.removeAllElements();
            try {
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    String postDate = resultSet.getString("post_date");

                    NoticeListItemModel item = new NoticeListItemModel(title, content, postDate);
                    model.addElement(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            jList1.setCellRenderer(new NoticeListRenderer());
            jList1.setModel(model);
        }
    }
}
