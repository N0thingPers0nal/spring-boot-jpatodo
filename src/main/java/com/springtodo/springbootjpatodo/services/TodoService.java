package com.springtodo.springbootjpatodo.services;

import com.springtodo.springbootjpatodo.models.AppUser;
import com.springtodo.springbootjpatodo.models.Todo;
import com.springtodo.springbootjpatodo.repository.TodoRepository;
import com.springtodo.springbootjpatodo.repository.UserRepository;
import com.springtodo.springbootjpatodo.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Todo> findAll(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> addTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        originalTodo.setUser(userRepository.findById(todo.getUserId()).get());
        todoRepository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> updateTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        originalTodo.setId(todo.getId());
        originalTodo.setUser(userRepository.findById(todo.getUserId()).get());
        todoRepository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> deleteTodo(int id) {
        int userId=todoRepository.findById(id).get().getUser().getId();
        todoRepository.deleteById(id);
        return findAll(userId);
    }
}
