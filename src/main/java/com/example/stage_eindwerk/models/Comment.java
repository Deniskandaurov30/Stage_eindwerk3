package com.example.stage_eindwerk.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Blogpost blogpost;
    @ManyToOne
    private Author author;
    private String comment;
    private Date commentDate;

    public Comment() {
    }

    public Comment(int id, Blogpost blogpost, Author author, String comment, Date commentDate) {
        this.id = id;
        this.blogpost = blogpost;
        this.author = author;
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public Blogpost getBlogpost() {
        return blogpost;
    }

    public void setBlogpost(Blogpost blogpost) {
        this.blogpost = blogpost;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
