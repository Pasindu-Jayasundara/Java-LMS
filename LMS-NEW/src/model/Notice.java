package model;

import java.time.LocalDateTime;

public class Notice {
    private int noticeId;
    private LocalDateTime postDate;
    private String content;
    private String title;
    private int statusId;
    private int adminUserId;

    // Constructors, getters, and setters
    public Notice() {}

    public Notice(int noticeId, LocalDateTime postDate, String content, String title, int statusId, int adminUserId) {
        this.noticeId = noticeId;
        this.postDate = postDate;
        this.content = content;
        this.title = title;
        this.statusId = statusId;
        this.adminUserId = adminUserId;
    }

    // Getters and Setters
    public int getNoticeId() { return noticeId; }
    public void setNoticeId(int noticeId) { this.noticeId = noticeId; }
    public LocalDateTime getPostDate() { return postDate; }
    public void setPostDate(LocalDateTime postDate) { this.postDate = postDate; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getStatusId() { return statusId; }
    public void setStatusId(int statusId) { this.statusId = statusId; }
    public int getAdminUserId() { return adminUserId; }
    public void setAdminUserId(int adminUserId) { this.adminUserId = adminUserId; }
}
