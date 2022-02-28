package com.example.stage_eindwerk.services;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Blogpost;
import com.example.stage_eindwerk.repository.BlogpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogpostService {

    @Autowired
    private BlogpostRepository blogpostRepository;

    public List <Blogpost> getAllBlogposts(){
        return blogpostRepository.findAll();
    }

    public Blogpost getBlogpostById(Integer id){
        return blogpostRepository.findById(id).get();}

    public List <Blogpost> getBlogpostbyAuthor(Author author) {
        return blogpostRepository.findBlogpostByAuthor(author.getUserName());
    }

    public List <Blogpost> getBlogpostByBlogpostTitle(Blogpost blogpost){
        return blogpostRepository.findBlogpostByBlogpostTitle(blogpost.getBlogpostTitle());
    }

    public void createBlogpost(Blogpost blogpost){
        blogpostRepository.save(blogpost);
    }

    public void editBlogpost(Blogpost blogpost){}

    public void deleteBlogpost(Blogpost blogpost){}
}
