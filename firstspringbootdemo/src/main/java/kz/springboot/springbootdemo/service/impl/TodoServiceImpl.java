package kz.springboot.springbootdemo.service.impl;

import kz.springboot.springbootdemo.entities.Todo;
import kz.springboot.springbootdemo.repositories.TodoRepository;
import kz.springboot.springbootdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo getTodoist(Long id) {
        return todoRepository.getOne(id);
    }

    @Override
    public Todo addTodoist(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }


    @Override
    public void deleteTodoist(Todo todo) {
        todoRepository.delete(todo);
    }

    @Override
    public Todo saveTodoist(Todo todo) {
        return todoRepository.save(todo);
    }
}
