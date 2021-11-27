package pl.sda.springzdjavapol92.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewTodoDto {
    private String title;
    private String deadline;
    private String person;
}
