package pl.sda.springzdjavapol92.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springzdjavapol92.model.Todo;
import pl.sda.springzdjavapol92.service.TodoService;

@Controller
public class HomeController {
    private final TodoService todoService;

    public HomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/todo/add")
    public String todoAddForm(){
        return "todo-add-form";
    }

    @PostMapping("/todo/add")
    public String todoAdd(@ModelAttribute Todo todo, Model model){
        model.addAttribute("todo", todoService.add(todo));
        return "confirm-todo";
    }
}
