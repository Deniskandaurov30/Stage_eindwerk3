package com.example.stage_eindwerk.repository;

import com.example.stage_eindwerk.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository <Rating, Integer> {

    List<Rating> getRatingByBlogpost (String blogpost);

}
