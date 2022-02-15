package com.example.stage_eindwerk.services;

import com.example.stage_eindwerk.models.Author;
import com.example.stage_eindwerk.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void createAuthor (Author author){
        System.out.println(author);
        authorRepository.save(author);
    }

    public Author findAuthorByUserNameAndPassWord(String username, String password){
        return authorRepository.findAuthorByUserNameAndPassWord(username,password);
    }
}
