package com.example.stage_eindwerk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class contactController {
    @GetMapping("contact")
    public String ShowAbout(){return "contact";}
}
