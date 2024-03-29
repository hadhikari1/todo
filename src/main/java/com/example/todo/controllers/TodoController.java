package com.example.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.todo.models.Todo;
import com.example.todo.repository.TodoRepository;

@RestController
@CrossOrigin({"http://localhost:3000/"})
public class TodoController {
    @Autowired
    private TodoRepository todoRepo;
    
    @GetMapping("/todo/{id}")
    public Optional<Todo> findAllById( @PathVariable Long id){
        return todoRepo.findById(id);
    }

    @GetMapping("/todo")
    public List<Todo> getListOfTodos() {
        return todoRepo.findAll();
    }
    @PostMapping("/todo")
    public Todo saveTodo(@RequestBody Todo todo) {
        try {
            Todo savedTodo = todoRepo.save(todo);
            return savedTodo;
        } catch (Exception e) {
            return null;
        }
    }
    @DeleteMapping("/todo/{id}")
    public Iterable<Todo> deleteTodo(@PathVariable long id){
        Todo newTodos = todoRepo.findById(id).get();
        todoRepo.delete(newTodos);
        return todoRepo.findAll();
    }

    @PatchMapping("/todo/{id}")
    public Iterable<Todo> updateTodoItem(@PathVariable long id, @RequestBody String todoItem){
        Todo newTodo = todoRepo.findById(id).get();
        newTodo.setTodoItem(todoItem);
        todoRepo.save(newTodo);
        return todoRepo.findAll();
    }
}
