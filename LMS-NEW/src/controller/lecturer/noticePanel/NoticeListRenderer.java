package controller.lecturer.noticePanel;

import model.NoticeListItemModel;
import view.lecturer.panels.NoticeItem;

import javax.swing.*;
import java.awt.*;

public class NoticeListRenderer extends NoticeItem implements ListCellRenderer<NoticeListItemModel> {
    @Override
    public Component getListCellRendererComponent(
            JList<? extends NoticeListItemModel> list,
            NoticeListItemModel value, int index, boolean isSelected, boolean cellHasFocus) {

        this.setNoticeTitle(value.getTitle());
        this.setContent(value.getContent());
        this.setPostTime(value.getDate());

        return this;
    }
}
