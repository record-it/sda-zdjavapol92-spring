package pl.sda.springzdjavapol92.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlRootElement;

/*
  1. Dodaj walidację dla obu pól
  autor - długość od 3 do 15 znaków
  tytuł - nie pusty i maksymalnie 120 znaków
  2. Dodaj w kontrolerze RestBookController validację podczas dodawania książki
  3. Dodaj exeptionHandler
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Book {
    private long id;
    @Length(min = 1, max = 120, message = "Tytuł nie może być pusty i dłuży od 120 znaków!")
    private String title;
    @Length(min = 3, max = 15)
    private String author;
}
