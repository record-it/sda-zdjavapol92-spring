package pl.sda.springzdjavapol92.service;

import org.springframework.stereotype.Service;
import pl.sda.springzdjavapol92.dto.BookDto;
import pl.sda.springzdjavapol92.mapper.BookMapper;
import pl.sda.springzdjavapol92.model.Book;
import pl.sda.springzdjavapol92.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaBookService implements BookService{
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book save(BookDto dto) {
        return BookMapper.mapFromEntity(bookRepository.save(BookMapper.mapToEntity(dto)));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::mapFromEntity)
                .collect(Collectors.toList());
    }
}
