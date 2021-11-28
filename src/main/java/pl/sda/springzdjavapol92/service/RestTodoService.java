package pl.sda.springzdjavapol92.service;

import pl.sda.springzdjavapol92.dto.NewTodoDto;
import pl.sda.springzdjavapol92.model.DomainTodo;

import java.util.List;
import java.util.Optional;

public interface RestTodoService {
    DomainTodo save(NewTodoDto newTodoDto);
    Optional<DomainTodo> update(DomainTodo todo);
    Optional<DomainTodo> delete(long id);
    Optional<DomainTodo> findById(long id);
    List<DomainTodo> findAll();
    void setAsComleted(long id);
}
