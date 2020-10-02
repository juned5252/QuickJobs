package com.Team4.example.QuickJobs.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Comment")
public class Comment {
    @Id
    private int commentId;
    private String Description;
    private String Date;

    public Comment() {
    }

    public Comment(int commentId, String description, String date) {
        this.commentId = commentId;
        Description = description;
        Date = date;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}

