package com.example.todo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.models.Todo;
import com.example.todo.repository.TodoRepository;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepo;
    
    @GetMapping("/todo/{id}")
    public Optional<Todo> findAllById( @PathVariable Long id){
        return todoRepo.findById(id);
    }
}
