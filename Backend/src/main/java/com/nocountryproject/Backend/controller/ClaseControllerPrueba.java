package com.nocountryproject.Backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class ClaseControllerPrueba {
    @GetMapping
    public String hide(){return "prueba";}
}
