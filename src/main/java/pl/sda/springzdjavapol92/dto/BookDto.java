package pl.sda.springzdjavapol92.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private String title;
    private String author;
}
