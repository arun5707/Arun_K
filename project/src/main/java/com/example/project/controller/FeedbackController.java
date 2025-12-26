package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Feedback;
import com.example.project.service.FeedbackService;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
        Feedback createdFeedback = feedbackService.addFeedback(feedback);
        if(createdFeedback!=null){
            return new ResponseEntity<>(createdFeedback,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id){
        Feedback feedback = feedbackService.getFeedbackById(id);
        if(feedback!=null){
            return new ResponseEntity<>(feedback,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        List<Feedback> list = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}