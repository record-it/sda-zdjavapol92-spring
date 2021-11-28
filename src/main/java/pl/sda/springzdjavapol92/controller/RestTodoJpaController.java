package pl.sda.springzdjavapol92.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springzdjavapol92.dto.NewTodoDto;
import pl.sda.springzdjavapol92.model.DomainTodo;
import pl.sda.springzdjavapol92.service.RestTodoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/todos")
public class RestTodoJpaController {
    private final RestTodoService service;

    public RestTodoJpaController(RestTodoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainTodo> getTodo(@PathVariable long id){
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<DomainTodo> addTodo(@Valid @RequestBody NewTodoDto newTodoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newTodoDto));
    }

    @GetMapping("")
    public List<DomainTodo> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DomainTodo> deleteTodo(@PathVariable long id){
        return ResponseEntity.of(service.delete(id));
    }

    @PutMapping("")
    public ResponseEntity<DomainTodo> updateTodo(@RequestBody DomainTodo todo){
        return ResponseEntity.of(service.update(todo));
    }

}
