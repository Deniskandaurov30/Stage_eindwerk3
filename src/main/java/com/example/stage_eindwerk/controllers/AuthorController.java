package com.example.stage_eindwerk.controllers;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Comment;
import com.example.stage_eindwerk.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.concurrent.CompletionException;
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("login")
    public String goToLoginPage(Model model){
        model.addAttribute("author", new Author());

        return "login";
    }

    @PostMapping("login")
    public String reDirectToLoginPage(@ModelAttribute("author") Author authorReceived, HttpSession session){
        System.out.println(authorReceived.getUserName());
        System.out.println(authorReceived.getPassWord());

       Author author = authorService.findAuthorByUserNameAndPassWord(authorReceived.getUserName(), authorReceived.getPassWord());

        if(author!=null) {
            session.setAttribute("currentUser", author.getUserName());
            return "redirect:about";
        }
        else return "redirect:about";
    }

}
