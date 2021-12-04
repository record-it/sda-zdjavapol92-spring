package pl.sda.springzdjavapol92;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springzdjavapol92.entity.AppUser;
import pl.sda.springzdjavapol92.entity.EntityBook;
import pl.sda.springzdjavapol92.repository.*;

@SpringBootApplication
public class SpringZdjavapol92Application implements CommandLineRunner {
    final TodoRepository todoRepository;
    final BookRepository bookRepository;
    final ArticleRepository articleRepository;
    final AuthorRepository authorRepository;
    final AppUserRepository appUserRepository;

    public SpringZdjavapol92Application(TodoRepository todoRepository, BookRepository bookRepository, ArticleRepository articleRepository, AuthorRepository authorRepository, AppUserRepository appUserRepository) {
        this.todoRepository = todoRepository;
        this.bookRepository = bookRepository;
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.appUserRepository = appUserRepository;
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
        appUserRepository.save(
                AppUser.builder()
                        .email("karol@op.pl")
                        .password("$2a$12$3oNS46NJ2ElY79uZ7MikvOObXJnqiKfmF9aaNVezyyz9n9lQjcTs6")
                        .enabled(true)
                        .role("ROLE_USER ROLE_ADMIN")
                        .firstName("Karol")
                        .lastName("Nowak")
                        .build()
        );
        appUserRepository.save(
                AppUser.builder()
                        .email("admin")
                        .password("$2a$12$3oNS46NJ2ElY79uZ7MikvOObXJnqiKfmF9aaNVezyyz9n9lQjcTs6")
                        .enabled(true)
                        .firstName("Ewa")
                        .lastName("Kowal")
                        .role("ROLE_ADMIN")
                        .build()
        );
    }
}
