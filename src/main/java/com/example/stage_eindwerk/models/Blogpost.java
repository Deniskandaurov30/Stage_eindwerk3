package com.example.stage_eindwerk.models;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String blogpostTitle;
    @OneToMany(mappedBy = "blogpost")
    private List <Rating> blogpostRating;
    @OneToMany(mappedBy = "blogpost")
    private List<Comment> blogpostComment;
    @Lob
    private String content;
    private Date date;
    @ManyToOne
    private Author author;
    private String imageLocation;

    public Blogpost(String blogpostTitle, String content, Date date) {
        this.blogpostTitle = blogpostTitle;
        this.content = content;
        this.date = date;
    }

    public Blogpost() {
    }

    public Blogpost(int id, String blogpostTitle, String content, Date date, Author author) {
        this.id = id;
        this.blogpostTitle = blogpostTitle;
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

    public List<Rating> getBlogpostRating() {
        return blogpostRating;
    }

    public void setBlogpostRating(List<Rating> blogpostRating) {
        this.blogpostRating = blogpostRating;
    }

    public List<Comment> getBlogpostComment() {
        return blogpostComment;
    }

    public void setBlogpostComment(List<Comment> blogpostComment) {
        this.blogpostComment = blogpostComment;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
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

    @Override
    public String toString() {
        return "Blogpost{" +
                "id=" + id +
                ", blogpostTitle='" + blogpostTitle + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", author=" + author +
                '}';
    }
}
