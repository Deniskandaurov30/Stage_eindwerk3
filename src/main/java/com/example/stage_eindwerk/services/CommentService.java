package com.example.stage_eindwerk.services;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Comment;
import com.example.stage_eindwerk.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List <Comment> findCommentsByAuthor (Author author){
        return commentRepository.findCommentByAuthor(author.getUserName());
    }

    public void createComment (Comment comment){
        commentRepository.save(comment);
    }
}
