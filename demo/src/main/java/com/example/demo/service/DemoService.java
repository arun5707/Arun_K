package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;


@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public Demo saveDemo(Demo demo) {
        return demoRepository.save(demo);
    }
    public List<Demo> getAllDemos() {
        return demoRepository.findAll();
    }
}