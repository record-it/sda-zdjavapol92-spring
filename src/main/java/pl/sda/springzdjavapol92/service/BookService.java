package pl.sda.springzdjavapol92.service;
import pl.sda.springzdjavapol92.dto.BookDto;
import pl.sda.springzdjavapol92.model.Book;

import java.util.List;

public interface BookService {
    Book save(BookDto dto);
    List<Book> findAll();
}
