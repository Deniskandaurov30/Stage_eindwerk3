package com.example.stage_eindwerk.controllers;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.repository.AuthorRepository;
import com.example.stage_eindwerk.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
public class AuthorController {




    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
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

}
