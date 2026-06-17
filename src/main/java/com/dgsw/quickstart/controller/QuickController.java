package com.dgsw.quickstart.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class QuickController {
    @GetMapping("/dummy1")
    public String dummy1(){
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        return "dummy2";
    }
}