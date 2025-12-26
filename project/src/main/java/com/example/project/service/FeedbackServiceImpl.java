package com.example.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Feedback;
import com.example.project.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private  FeedbackRepo feedbackRepo;
    @Override
    public Feedback addFeedback(Feedback feedback){
        return feedbackRepo.save(feedback);
    }
    @Override
    public List<Feedback> getAllFeedbacks(){
        return feedbackRepo.findAll();
    }
    @Override
    public Feedback getFeedbackById(Long id){
        return feedbackRepo.findById(id).orElse(null);
    }
}