package com.example.stage_eindwerk.services;

import com.example.stage_eindwerk.models.Blogpost;

import java.util.List;

public interface BlogpostInt {

    List<Blogpost> findAll();
    List<Blogpost> findLatest5();
    Blogpost findById(Long id);
    Blogpost create(Blogpost blogpost);
    Blogpost edit(Blogpost blogpost);
    void deleteById(Long id);
}
