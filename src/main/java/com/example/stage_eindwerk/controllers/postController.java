package com.example.stage_eindwerk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class postController {
    @GetMapping("post")
    public String ShowAbout(){return "post";}
}
