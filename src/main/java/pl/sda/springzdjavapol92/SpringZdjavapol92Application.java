package pl.sda.springzdjavapol92;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springzdjavapol92.entity.Article;
import pl.sda.springzdjavapol92.entity.Author;
import pl.sda.springzdjavapol92.entity.EntityBook;
import pl.sda.springzdjavapol92.repository.ArticleRepository;
import pl.sda.springzdjavapol92.repository.AuthorRepository;
import pl.sda.springzdjavapol92.repository.BookRepository;
import pl.sda.springzdjavapol92.repository.TodoRepository;

import java.util.*;

@SpringBootApplication
public class SpringZdjavapol92Application implements CommandLineRunner {
    final TodoRepository todoRepository;
    final BookRepository bookRepository;
    final ArticleRepository articleRepository;
    final AuthorRepository authorRepository;

    public SpringZdjavapol92Application(TodoRepository todoRepository, BookRepository bookRepository, ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.todoRepository = todoRepository;
        this.bookRepository = bookRepository;
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringZdjavapol92Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(EntityBook.builder()
                .author("Bloch")
                .title("Java")
                .build());
        bookRepository.save(EntityBook.builder()
                .author("Bloch")
                .title("Effective Java")
                .build());
        bookRepository.save(EntityBook.builder()
                .author("Freeman")
                .title("Asp.NET")
                .build());
        bookRepository.save(EntityBook.builder()
                .author("Freeman")
                .title("Java for greens")
                .build());
        bookRepository.flush();
    }
}
