package pl.sda.springzdjavapol92.mapper;

import pl.sda.springzdjavapol92.entity.EntityTodo;
import pl.sda.springzdjavapol92.model.Todo;

import java.time.LocalDate;

public class TodoMapper {

    public static EntityTodo mapToEntity(Todo todo){
        EntityTodo entity = new EntityTodo();
        entity.setTitle(todo.getTitle());
        entity.setPerson(todo.getPerson());
        entity.setDeadline(LocalDate.parse(todo.getDeadline()));
        return  entity;
    }

    public static Todo mapFromEntity(EntityTodo todo){
        return Todo.builder()
                .id(todo.getId())
                .completed(todo.isCompleted())
                .title(todo.getTitle())
                .person(todo.getPerson())
                .deadline(todo.getDeadline().toString())
                .created(todo.getCreated())
                .build();
    }
}
