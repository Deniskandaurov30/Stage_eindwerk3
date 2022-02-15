package com.example.stage_eindwerk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contactController {
    @RequestMapping({"/","contact"})
    public String ShowAbout(){return "contact";}
}
