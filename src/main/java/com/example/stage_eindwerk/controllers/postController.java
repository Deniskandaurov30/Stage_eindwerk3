package com.example.stage_eindwerk.controllers;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Blogpost;
import com.example.stage_eindwerk.models.Comment;
import com.example.stage_eindwerk.models.Rating;
import com.example.stage_eindwerk.services.AuthorService;
import com.example.stage_eindwerk.services.BlogpostService;
import com.example.stage_eindwerk.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
public class postController {

    @Autowired
    private BlogpostService blogpostService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/post")
    public String ShowIndex(Model model) {
        Blogpost blogpost = new Blogpost("","",new Date());
        model.addAttribute("blogpost",blogpost);
        return "post";}


    @GetMapping("/indexBlogs")
    public String getblogPosts(Model model){
        List<Blogpost> blogposts = blogpostService.getAllBlogposts();
        model.addAttribute("blogposts",blogposts);
        return "index";
    }

    @GetMapping("post/{id}")
    public String showBlogpost(@PathVariable String id, Model model) {
        Integer idInInt = Integer.parseInt(id);
        Blogpost blogpost = blogpostService.getBlogpostById(idInInt);
        model.addAttribute("author",blogpost.getAuthor());
        model.addAttribute("blogpost", blogpost);
        model.addAttribute("fullComment",new Comment());
        model.addAttribute("comments",blogpost.getBlogpostComment());
        model.addAttribute("likes",blogpost.getBlogpostRating().size());
        return "post";
    }

    @GetMapping("like/{id}")
    public String blogpostLike(@PathVariable String id, Model model){
        Integer idInInt = Integer.parseInt(id);
        Blogpost blogpost = blogpostService.getBlogpostById(idInInt);
        Rating rating = new Rating();
        rating.setBlogpost(blogpost);
        ratingService.createRating(rating);
        return "redirect:/post/"+id;
    }

    @GetMapping("/createBlogpost")
    public String createBlogpost(@ModelAttribute ("blogpost") Blogpost blogpost,Model model){
        blogpost.setDate(new Date());
        Author author = authorService.getAuthorByUsername("Alan Savage");
        blogpost.setAuthor(author);
        blogpostService.createBlogpost(blogpost);
        model.addAttribute("blogpost",blogpost);
        return "newBlogpost";
    }



}
