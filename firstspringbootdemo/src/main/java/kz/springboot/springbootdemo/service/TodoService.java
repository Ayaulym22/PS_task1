package kz.springboot.springbootdemo.service;


import kz.springboot.springbootdemo.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {

    Todo addTodoist (Todo todo);
    List<Todo> getAllTodo();
    Todo getTodoist(Long id);
    void deleteTodoist(Todo todo);
    Todo saveTodoist(Todo todo);

}
