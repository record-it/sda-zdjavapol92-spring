package pl.sda.springzdjavapol92.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.sda.springzdjavapol92.model.Book;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RestBookController {

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        book.setId(100);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> readBook(@PathVariable long id){
        Book book = new Book();
        book.setId(id);
        book.setAuthor("Autor");
        book.setTitle("Tytuł");
        return ResponseEntity.of(id < 20 ? Optional.of(book) : Optional.empty());
    }

    @PatchMapping("/books/author/{id}")
    public ResponseEntity<Book> updateBookAuthor(@PathVariable long id, @RequestParam String value){
        System.out.println(id);
        System.out.println(value);
        return ResponseEntity.ok().build();
    }
}
