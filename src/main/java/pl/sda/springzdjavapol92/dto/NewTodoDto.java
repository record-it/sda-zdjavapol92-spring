package pl.sda.springzdjavapol92.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewTodoDto {
    @NotBlank
    private String title;
    @Length(min = 10, max = 10, message = "Podaj datę w formacie YYYY-MM-dd i dokładnie 10 znaków!")
    private String deadline;
    @NotNull
    @NotBlank
    private String person;
}
