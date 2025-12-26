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

import com.example.project.model.Rating;
import com.example.project.service.RatingService;


@RestController
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        Rating createdRating = ratingService.addRating(rating);
        if(createdRating!=null){
            return new ResponseEntity<>(createdRating,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id){
        Rating rating = ratingService.getRatingById(id);
        if(rating!=null){
            return new ResponseEntity<>(rating,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> list = ratingService.getAllRatings();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
