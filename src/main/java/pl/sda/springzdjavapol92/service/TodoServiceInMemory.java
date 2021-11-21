package pl.sda.springzdjavapol92.service;

import org.springframework.stereotype.Service;
import pl.sda.springzdjavapol92.model.Todo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class TodoServiceInMemory implements TodoService{
    private Map<Long, Todo> todos = new HashMap<>();
    private long currentId = 1;

    public TodoServiceInMemory() {
        Todo todo = Todo.builder()
                .person("Adam")
                .title("Spring")
                .deadline("2021-12-01")
                .build();
        add(todo);
        todo = Todo.builder()
                .person("Ola")
                .title("Programowanie w Java")
                .deadline("2022-03-21")
                .build();
        add(todo);
        add(Todo.builder()
                .person("Zenek")
                .title("Koncert")
                .deadline("2022-10-10")
                .build());
    }

    @Override
    public Todo add(Todo todo) {
        todo.setId(currentId++);
        todo.setCreated(new Timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) * 1000));
        todos.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    @Override
    public void setAsCompleted(long id) {
        todos.get(id).setCompleted(true);
    }
}
