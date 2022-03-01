package com.example.stage_eindwerk.services;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.models.Comment;
import com.example.stage_eindwerk.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    public CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }
}
