package com.example.stage_eindwerk.services;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Blogpost;
import com.example.stage_eindwerk.models.Comment;
import com.example.stage_eindwerk.models.Rating;
import com.example.stage_eindwerk.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List <Rating> findRatingsByBlogpost (Blogpost blogpost){
        return ratingRepository.getRatingByBlogpost(blogpost.getBlogpostTitle());

    }

    public void createRating (Rating rating){
        ratingRepository.save(rating);
    }
}
