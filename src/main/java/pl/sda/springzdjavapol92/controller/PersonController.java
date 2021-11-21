package pl.sda.springzdjavapol92.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springzdjavapol92.model.Person;

@Controller
public class PersonController {

    @GetMapping("/person")
    public String index(){
        return "person/index";
    }

    @GetMapping("/person/add")
    public String addPersonForm(){
        return "person/add-person-form";
    }

    @PostMapping("/person/add")
    public String addPerson(@ModelAttribute Person person, Model model){
        model.addAttribute("person", person);
        return "person/confirm-person";
    }
}
