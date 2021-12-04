package pl.sda.springzdjavapol92.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class BookDto {
    @Length(min = 1, max = 120, message = "Tytuł nie może być pusty i dłuży od 120 znaków!")
    private String title;
    @Length(min = 3, max = 15)
    private String author;
}
