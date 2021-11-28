package pl.sda.springzdjavapol92.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.springzdjavapol92.entity.EntityTodo;
import pl.sda.springzdjavapol92.mapper.TodoMapper;
import pl.sda.springzdjavapol92.model.Todo;
import pl.sda.springzdjavapol92.repository.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class JpaTodoService implements TodoService{

    private final TodoRepository todoRepository;

    public JpaTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo add(Todo todo) {
        final EntityTodo save = todoRepository.save(TodoMapper.mapToEntity(todo));
        todo.setId(save.getId());
        todo.setCreated(save.getCreated());
        todo.setCompleted(save.isCompleted());
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoMapper::mapFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void setAsCompleted(long id) {
        final Optional<EntityTodo> optionalEntityTodo = todoRepository.findById(id);
        if(optionalEntityTodo.isPresent()){
            final EntityTodo entityTodo = optionalEntityTodo.get();
            entityTodo.setCompleted(true);
            todoRepository.save(entityTodo);
        }
    }
}
