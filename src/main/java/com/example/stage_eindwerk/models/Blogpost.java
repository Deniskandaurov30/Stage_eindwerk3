package com.example.stage_eindwerk.models;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String blogpostTitle;
    @OneToMany(mappedBy = "blogpost")
    private List <Rating> blogpostRating;
    @OneToMany(mappedBy = "blogpost")
    private List<Comment> blogpostComment;
    private String content;
    private Date date;
    @ManyToOne
    private Author author;

    public Blogpost() {
    }

    public Blogpost(int id, String blogpostTitle, List blogpostRating, List blogpostComment, String content, Date date, Author author) {
        this.id = id;
        this.blogpostTitle = blogpostTitle;
        this.blogpostRating = blogpostRating;
        this.blogpostComment = blogpostComment;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public String getBlogpostTitle() {
        return blogpostTitle;
    }

    public void setBlogpostTitle(String blogpostTitle) {
        this.blogpostTitle = blogpostTitle;
    }

    public List getBlogpostRating() {
        return blogpostRating;
    }

    public void setBlogpostRating(List blogpostRating) {
        this.blogpostRating = blogpostRating;
    }

    public List getBlogpostComment() {
        return blogpostComment;
    }

    public void setBlogpostComment(List blogpostComment) {
        this.blogpostComment = blogpostComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
