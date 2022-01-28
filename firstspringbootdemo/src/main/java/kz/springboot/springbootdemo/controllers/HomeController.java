package kz.springboot.springbootdemo.controllers;

import kz.springboot.springbootdemo.entities.Todo;
import kz.springboot.springbootdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Todo> todos = todoService.getAllTodo();
        model.addAttribute("todoist", todos);

        return "index";
    }


    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestParam(name = "id", defaultValue = "No id") Long id,
                          @RequestParam(name = "name", defaultValue = "No Task") String name,
                          @RequestParam(name = "description", defaultValue = "No Decription") String description,
                          @RequestParam(name = "addedDate", defaultValue = "No AddedDate") String addedDate,
                          @RequestParam(name = "priority", defaultValue = "No Priority") String priority) {

        {
            Todo td = todoService.getTodoist(id);

            if (td != null) {
                td.setName(name);
                td.setDescription(description);
                td.setAddedDate(addedDate);
                td.setPriority(priority);

                todoService.addTodoist(td);
            }
        }
        return "redirect:/";
    }


    @PostMapping(value = "/editTodo")
    public String editTodo(@RequestParam(name = "id", defaultValue = "No id") Long id,
                           @RequestParam(name = "name", defaultValue = "No Task") String name,
                           @RequestParam(name = "description", defaultValue = "No Decription") String description,
                           @RequestParam(name = "addedDate", defaultValue = "No AddedDate") String  addedDate,
                           @RequestParam(name = "priority", defaultValue = "No Priority") String priority) {
        {    Todo td = todoService.getTodoist(id);

        if (td != null) {
            td.setName(name);
            td.setDescription(description);
            td.setAddedDate(addedDate);
            td.setPriority(priority);

            todoService.saveTodoist(td);
        }
    }
    return"redirect:/";
}



    @GetMapping(value = "/deleteItem")
    public String deleteTodo(Model model, @RequestParam(name = "id") Long id)
    {
        Todo td = todoService.getTodoist(id);
        todoService.deleteTodoist(td);
        return "about";
    }
}
