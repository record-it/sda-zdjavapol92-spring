package pl.sda.springzdjavapol92.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springzdjavapol92.dto.NewTodoDto;
import pl.sda.springzdjavapol92.entity.EntityTodo;
import pl.sda.springzdjavapol92.mapper.DomainTodoMapper;
import pl.sda.springzdjavapol92.model.DomainTodo;
import pl.sda.springzdjavapol92.repository.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaRestTodoService implements RestTodoService{
    private final TodoRepository todoRepository;

    public JpaRestTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public DomainTodo save(NewTodoDto newTodoDto) {
        return DomainTodoMapper.mapFormEntity(todoRepository.save(DomainTodoMapper.mapToEntity(newTodoDto)));
    }

    @Override
    public Optional<DomainTodo> update(DomainTodo todo) {
        final Optional<EntityTodo> optionalEntityTodo = todoRepository.findById(todo.getId());
        if (optionalEntityTodo.isPresent()){
            final EntityTodo entity = optionalEntityTodo.get();
            entity.setTitle(todo.getTitle());
            entity.setDeadline(todo.getDeadline());
            entity.setPerson(todo.getPerson());
            todoRepository.save(entity);
            return Optional.of(DomainTodoMapper.mapFormEntity(entity));
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<DomainTodo> delete(long id) {
        final Optional<EntityTodo> optionalEntityTodo = todoRepository.findById(id);
        if (optionalEntityTodo.isPresent()) {
            todoRepository.deleteById(id);
            return optionalEntityTodo.map(DomainTodoMapper::mapFormEntity);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<DomainTodo> findById(long id) {
        return todoRepository.findById(id).map(DomainTodoMapper::mapFormEntity);
    }

    @Override
    public List<DomainTodo> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(DomainTodoMapper::mapFormEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void setAsComleted(long id) {
        final Optional<EntityTodo> optionalEntityTodo = todoRepository.findById(id);
        if(optionalEntityTodo.isPresent()){
            final EntityTodo entityTodo = optionalEntityTodo.get();
            entityTodo.setCompleted(true);
            todoRepository.save(entityTodo);
        }
    }
}
