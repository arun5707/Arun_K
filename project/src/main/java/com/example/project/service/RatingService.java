package com.example.project.service;

import java.util.List;

import com.example.project.model.Rating;

public interface RatingService {
    Rating addRating(Rating rating);
    List<Rating> getAllRatings();
    Rating getRatingById(Long id);
}