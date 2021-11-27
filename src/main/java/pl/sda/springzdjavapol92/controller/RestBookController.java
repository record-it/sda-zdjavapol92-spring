package pl.sda.springzdjavapol92.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springzdjavapol92.model.Book;

@RestController
@RequestMapping("/api/v1")
public class RestBookController {

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        book.setId(100);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
}
