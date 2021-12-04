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
//        EntityTodo todo = new EntityTodo();
//        todo.setPerson("Adam");
//        todo.setTitle("Test");
//        todo.setDeadline(LocalDate.of(2021, 12, 12));
//        todoRepository.save(todo);
//        todo = new EntityTodo();
//        todo.setPerson("Ewa");
//        todo.setTitle("Java");
//        todo.setDeadline(LocalDate.of(2021, 12, 16));
//        todoRepository.save(todo);
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
        System.out.println("Książki danego autora");
        System.out.println(bookRepository.findByAuthor("Bloch"));
        System.out.println("Liczba książek danego autora");
        System.out.println(bookRepository.countByAuthor("Bloch"));
        System.out.println("Liczba książek danego autora o tytule zaczynającym sie literą J");
        System.out.println(bookRepository.countByAuthorAndAndTitleStartingWith("Bloch", "J"));
        System.out.println(bookRepository.getAllTitles());
        final List<Object[]> result = bookRepository.getIdAndTitles();
        result.forEach(row -> {
            System.out.println(row[0] + " " + row[1]);
        });

        System.out.println("Związek artykułów z autorami");
        Author author = Author.builder().firstName("Adam").lastName("Nowak").build();
        Article article = Article.builder().title("Java").authors(Set.of(author)).build();

        articleRepository.save(article);
        articleRepository.save(
                Article.builder()
                        .title("C#")
                        .authors(Set.of(Author.builder().firstName("Adam").lastName("Nowak").build()))
                        .build()
        );
        System.out.println(articleRepository.findAll());
        System.out.println(authorRepository.findAll());
    }
}
