package com.example.stage_eindwerk.repository;


import com.example.stage_eindwerk.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <Author,String> {

    Author findAuthorByUserNameAndPassWord (String username, String password);


}
