package pl.sda.springzdjavapol92.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springzdjavapol92.dto.NewTodoDto;
import pl.sda.springzdjavapol92.model.Todo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
public class RestTodoController {

    @GetMapping("/api/v1/test")
    public String test(){
        return "test";
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody NewTodoDto dto){
        //TODO zapisać do bazy przesłane zadanie
        final Todo todo = Todo.builder()
                .person(dto.getPerson())
                .title(dto.getTitle())
                .deadline(dto.getDeadline())
                .id(100)
                .created(Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }


}
