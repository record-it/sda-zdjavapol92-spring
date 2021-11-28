package pl.sda.springzdjavapol92.mapper;

import pl.sda.springzdjavapol92.dto.NewTodoDto;
import pl.sda.springzdjavapol92.entity.EntityTodo;
import pl.sda.springzdjavapol92.model.DomainTodo;

import java.time.LocalDate;

public class DomainTodoMapper {
    public static DomainTodo mapFormEntity(EntityTodo entity){
        return DomainTodo.builder()
                .deadline(entity.getDeadline())
                .title(entity.getTitle())
                .id(entity.getId())
                .completed(entity.isCompleted())
                .person(entity.getPerson())
                .build();
    }

    public static EntityTodo mapToEntity(NewTodoDto newTodoDto){
        EntityTodo entityTodo = new EntityTodo();
        entityTodo.setDeadline(LocalDate.parse(newTodoDto.getDeadline()));
        entityTodo.setPerson(newTodoDto.getPerson());
        entityTodo.setTitle(newTodoDto.getTitle());
        return entityTodo;
    }
}
