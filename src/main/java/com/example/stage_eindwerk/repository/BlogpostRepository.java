package com.example.stage_eindwerk.repository;

import com.example.stage_eindwerk.models.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogpostRepository extends JpaRepository <Blogpost,Integer> {

    List<Blogpost> findBlogpostByAuthor (String author);
    List<Blogpost> findBlogpostByBlogpostTitle(String blogpost);

}
