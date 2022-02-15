package com.example.stage_eindwerk.repository;

import com.example.stage_eindwerk.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Integer> {

    List <Comment> findCommentByAuthor (String author);


}
