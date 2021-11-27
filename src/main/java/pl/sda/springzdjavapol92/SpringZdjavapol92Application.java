package pl.sda.springzdjavapol92;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.springzdjavapol92.entity.EntityTodo;

import java.time.LocalDate;

@SpringBootApplication
public class SpringZdjavapol92Application implements CommandLineRunner {
    final TodoRepository todoRepository;

    public SpringZdjavapol92Application(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringZdjavapol92Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EntityTodo todo = new EntityTodo();
        todo.setPerson("Adam");
        todo.setTitle("Test");
        todo.setDeadline(LocalDate.of(2021, 12, 12));
        todoRepository.save(todo);
        todo = new EntityTodo();
        todo.setPerson("Ewa");
        todo.setTitle("Java");
        todo.setDeadline(LocalDate.of(2021, 12, 16));
        todoRepository.save(todo);
        System.out.println(todoRepository.findAll());
    }
}
