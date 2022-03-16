package com.example.stage_eindwerk.controllers;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Blogpost;
import com.example.stage_eindwerk.models.Comment;
import com.example.stage_eindwerk.services.AuthorService;
import com.example.stage_eindwerk.services.BlogpostService;
import com.example.stage_eindwerk.services.CommentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@Controller
public class AuthorController {




    private final AuthorService authorService;
    private final CommentService commentService;
    private final BlogpostService blogpostService;


    public AuthorController(AuthorService authorService, CommentService commentService, BlogpostService blogpostService) {
        this.authorService = authorService;
        this.commentService = commentService;
        this.blogpostService = blogpostService;
    }


    @GetMapping("login")
    public String goToLoginPage(Model model){
        model.addAttribute("author", new Author());

        return "login";
    }

    @PostMapping("login2")
    public String reDirectToLoginPage(@ModelAttribute("author") Author authorReceived, HttpSession session){
        System.out.println(authorReceived.getUserName());
        System.out.println(authorReceived.getPassWord());
//
       Author author = authorService.getAuthorByUsername(authorReceived.getUserName());

        if(author!=null) {
            session.setAttribute("currentUser", author.getUserName());
            return "redirect:indexBlogs";
        }
        else return "redirect:login";
    }

    @PostMapping("register")
    public String registerAuthor(@ModelAttribute("author")Author received) {
        System.out.println(received.getUserName());
        System.out.println(received.getPassWord());
        authorService.createAuthor(received);
        return "redirect:login";
    }

    @GetMapping("contact")
    public String ShowAbout(Model model) {
        model.addAttribute("author", new Author());
        return "contact";}


    @GetMapping("logout")
    public String LogAuthorOut(HttpSession httpSession) throws ServletException, IOException {
        if (httpSession.getAttribute("author") != null) {
            httpSession.removeAttribute("author");

        }
        return "redirect:login";
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String displayComment(@ModelAttribute ("fullComment") Comment fullComment,
                                 @ModelAttribute ("blogpost") Blogpost blogpost, @ModelAttribute ("author")Author author) {
        fullComment.setBlogpost(blogpostService.getBlogpostById(blogpost.getId()));
        fullComment.setAuthor(authorService.getAuthorByUsername(author.getUserName()));
        fullComment.setId(0);
        fullComment.setCommentDate(new Date());
       commentService.save(fullComment);
        return "redirect:post/"+fullComment.getBlogpost().getId();
    }

    @RequestMapping(value = "/Comment", method = RequestMethod.GET)
    public String displayComment(Model model) {
       model.addAttribute("fullComment",new Comment());
        return "comment";
    }


}
