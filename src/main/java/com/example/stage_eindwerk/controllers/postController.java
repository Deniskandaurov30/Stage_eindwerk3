package com.example.stage_eindwerk.controllers;

import com.example.stage_eindwerk.models.Blogpost;
import com.example.stage_eindwerk.services.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;


@Controller
public class postController {

    @GetMapping("/post")
    public String ShowIndex(Model model) {
        Blogpost blogpost = new Blogpost("","",new Date());
        model.addAttribute("blogpost",blogpost);
        return "post";}

    @Autowired
    private BlogpostService blogpostService;

    @GetMapping("/indexBlogs")
    public String getblogPosts(Model model){
        List<Blogpost> blogposts = blogpostService.getAllBlogposts();
        model.addAttribute("blogposts",blogposts);
        return "index";
    }

    @GetMapping("post/{id}")
    public String showBlogpost(@PathVariable String id, Model model){
        Integer idInInt = Integer.parseInt(id);
        Blogpost blogpost = blogpostService.getBlogpostById(idInInt);
        model.addAttribute("blogpost",blogpost);
        return "post";
    }


}
