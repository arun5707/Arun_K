package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.repository.RatingRepo;
import com.example.project.model.Rating;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating addRating(Rating rating){
        return ratingRepo.save(rating);
    }
    @Override
    public List<Rating> getAllRatings(){
        return ratingRepo.findAll();
    }
    @Override
    public Rating getRatingById(Long id){
        return ratingRepo.findById(id).orElse(null);
    }
}