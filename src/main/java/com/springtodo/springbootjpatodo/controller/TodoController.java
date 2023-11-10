package com.springtodo.springbootjpatodo.controller;

import com.springtodo.springbootjpatodo.models.Todo;
import com.springtodo.springbootjpatodo.request.TodoRequest;
import com.springtodo.springbootjpatodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> getUserTodo(@PathVariable int userId) {
        return todoService.findAll(userId);
    }
    @PostMapping
    public List<Todo> addTodo(@RequestBody TodoRequest todo){
        return todoService.addTodo(todo);
    }
    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todo){
        return todoService.updateTodo(todo);
    }
    @DeleteMapping("/delete/{id}")
    public List<Todo> deleteTodo(@PathVariable int id){
        return todoService.deleteTodo(id);
    }
}