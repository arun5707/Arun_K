package com.example.project.service;

import java.util.List;

import com.example.project.model.Feedback;


public interface FeedbackService {
    Feedback addFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long id);
}