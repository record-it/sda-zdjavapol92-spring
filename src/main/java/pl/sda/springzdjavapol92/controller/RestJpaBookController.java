package pl.sda.springzdjavapol92.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springzdjavapol92.dto.BookDto;
import pl.sda.springzdjavapol92.model.Book;
import pl.sda.springzdjavapol92.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/books")
public class RestJpaBookController {
    private final BookService bookService;

    public RestJpaBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody BookDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(dto));
    }

}
