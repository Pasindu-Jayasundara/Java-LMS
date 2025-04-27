package controller;

import model.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {
    private Connection connection;

    public NoticeDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new notice
    public boolean addNotice(Notice notice) throws SQLException {
        String query = "INSERT INTO notice (post_date, content, title, status_status_id, admin_user_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, Timestamp.valueOf(notice.getPostDate()));
            stmt.setString(2, notice.getContent());
            stmt.setString(3, notice.getTitle());
            stmt.setInt(4, notice.getStatusId());
            stmt.setInt(5, notice.getAdminUserId());
            return stmt.executeUpdate() > 0;
        }
    }

    // Get all notices
    public List<Notice> getAllNotices() throws SQLException {
        List<Notice> notices = new ArrayList<>();
        String query = "SELECT * FROM notice";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Notice notice = new Notice(
                        rs.getInt("notice_id"),
                        rs.getTimestamp("post_date").toLocalDateTime(),
                        rs.getString("content"),
                        rs.getString("title"),
                        rs.getInt("status_status_id"),
                        rs.getInt("admin_user_id")
                );
                notices.add(notice);
            }
        }
        return notices;
    }

    // Update a notice
    public boolean updateNotice(Notice notice) throws SQLException {
        String query = "UPDATE notice SET post_date=?, content=?, title=?, status_status_id=?, admin_user_id=? WHERE notice_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, Timestamp.valueOf(notice.getPostDate()));
            stmt.setString(2, notice.getContent());
            stmt.setString(3, notice.getTitle());
            stmt.setInt(4, notice.getStatusId());
            stmt.setInt(5, notice.getAdminUserId());
            stmt.setInt(6, notice.getNoticeId());
            return stmt.executeUpdate() > 0;
        }
    }

    // Delete a notice
    public boolean deleteNotice(int noticeId) throws SQLException {
        String query = "DELETE FROM notice WHERE notice_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, noticeId);
            return stmt.executeUpdate() > 0;
        }
    }

    // Get notice by ID
    public Notice getNoticeById(int noticeId) throws SQLException {
        String query = "SELECT * FROM notice WHERE notice_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, noticeId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Notice(
                            rs.getInt("notice_id"),
                            rs.getTimestamp("post_date").toLocalDateTime(),
                            rs.getString("content"),
                            rs.getString("title"),
                            rs.getInt("status_status_id"),
                            rs.getInt("admin_user_id")
                    );
                }
            }
        }
        return null;
    }
}
