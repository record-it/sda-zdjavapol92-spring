package pl.sda.springzdjavapol92.mapper;

import pl.sda.springzdjavapol92.dto.BookDto;
import pl.sda.springzdjavapol92.entity.EntityBook;
import pl.sda.springzdjavapol92.model.Book;

public class BookMapper {
    public static EntityBook mapToEntity(BookDto dto){
        return EntityBook.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .build();
    }

    public static Book mapFromEntity(EntityBook entity){
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .build();
    }
}
