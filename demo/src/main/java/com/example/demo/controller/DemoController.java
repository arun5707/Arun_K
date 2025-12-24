package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demo;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;
    @PostMapping("/add")
    public Demo addDemo(@RequestBody Demo demo) {
        return demoService.saveDemo(demo);
    }
    @GetMapping("/all")
    public List<Demo> viewDemos() {
        return demoService.getAllDemos();
    }
}
