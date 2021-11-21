package pl.sda.springzdjavapol92.service;


import pl.sda.springzdjavapol92.model.Todo;

import java.util.List;

public interface TodoService {
    Todo add(Todo todo);
    List<Todo> findAll();
    void setAsCompleted(long id);
}
