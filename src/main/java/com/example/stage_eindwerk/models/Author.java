package com.example.stage_eindwerk.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    private String userName;
    @Column (nullable = false)
    private String passWord;
    @OneToMany(mappedBy = "author")
    private List<Blogpost> blogposts;
    private String imageLocation;

    public Author(String userName) {
        this.userName = userName;
    }

    public Author() {
    }

    public Author(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List getBlogposts() {
        return blogposts;
    }

    public void setBlogposts(List blogposts) {
        this.blogposts = blogposts;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    @Override
    public String toString() {
        return "Author{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                '}';
    }
}

