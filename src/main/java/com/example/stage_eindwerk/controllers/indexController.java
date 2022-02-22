package com.example.stage_eindwerk.controllers;

import com.example.stage_eindwerk.models.Blogpost;
import com.example.stage_eindwerk.services.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class indexController {
   @GetMapping("/index")
    public String ShowIndex(){return "index";}
}
