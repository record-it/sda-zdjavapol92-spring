package pl.sda.springzdjavapol92.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.sda.springzdjavapol92.dto.NewTodoDto;
import pl.sda.springzdjavapol92.model.Todo;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class RestTodoController {

    @GetMapping("/api/v1/test")
    public String test(){
        return "test";
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<Todo> addTodo(@Validated @RequestBody NewTodoDto dto){
        //TODO zapisać do bazy przesłane zadanie
        final Todo todo = Todo.builder()
                .person(dto.getPerson())
                .title(dto.getTitle())
                .deadline(dto.getDeadline().toString())
                .id(100)
                .created(Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @GetMapping("/api/v1/todos/{id}")
    public ResponseEntity<Todo> readTodo(@PathVariable long id){
        final Todo todo = Todo.builder()
                .completed(false)
                .id(id)
                .title("Testowy")
                .person("Anonim")
                .deadline("2021-12-12")
                .build();
        return ResponseEntity.of(id < 10 ? Optional.of(todo): Optional.empty());
    }

    @PutMapping("/api/v1/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody NewTodoDto todoUpdate){
        //TODO wyciągąnąć obiekt o danym id z repozytorium i zmienić w nim pola na wartości w todoUpdate
        Todo todo = Todo.builder()
                .person(todoUpdate.getPerson())
                .deadline(todoUpdate.getDeadline().toString())
                .title(todoUpdate.getTitle())
                .id(id)
                .build();
        return ResponseEntity.of(id < 10 ? Optional.of(todo) : Optional.empty());
    }

    @PatchMapping("/api/v1/todos/{id}")
    public ResponseEntity<Todo> setTodoAsCompleted(@PathVariable long id){
        //TODO wyciągnąć zadanie z repozytorium i ustawić w nim pole completed na true
        Todo todo = Todo.builder()
                .person("Test")
                .deadline("2021-12-12")
                .title("Test")
                .id(id)
                .completed(true)        //
                .build();
        return ResponseEntity.of(id < 10 ? Optional.of(todo) : Optional.empty());
    }

    @DeleteMapping("/api/v1/todos/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable long id){
        //TODO usunąć z repozytorium obiekt o danym id
        Todo todo = Todo.builder()
                .person("Test")
                .deadline("2021-12-12")
                .title("Test")
                .id(id)
                .completed(true)        //
                .build();
        return ResponseEntity.of(id < 10 ? Optional.of(todo) : Optional.empty());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(
                error -> {
                    errors.put(((FieldError) error).getField(), error.getDefaultMessage());
                }
        );
        return errors;
    }
}
