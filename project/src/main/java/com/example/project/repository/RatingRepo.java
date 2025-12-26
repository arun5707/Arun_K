package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Rating;


@Repository
public interface RatingRepo extends JpaRepository<Rating,Long>{
    
}