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

    private void createUIComponents() {
        initComponents();
        loadNotices();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new JList<NoticeListItemModel>();

//        jList1.setModel(new AbstractListModel<NoticeListItemModel>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void loadNotices() {
        String query = "SELECT * FROM `notice` WHERE `status_status_id`=? ORDER BY `post_date` DESC";
        ResultSet resultSet = DBConnection.search(query, 1);

        if (resultSet != null) {
            CustomNoticeListModel model = new CustomNoticeListModel();
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
