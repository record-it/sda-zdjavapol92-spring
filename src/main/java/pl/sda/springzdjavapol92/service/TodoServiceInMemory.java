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
    private int currentId = 1;

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
