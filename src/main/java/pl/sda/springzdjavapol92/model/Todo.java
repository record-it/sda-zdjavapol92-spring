package pl.sda.springzdjavapol92.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private long id;
    private String title;
    private String deadline;
    private String person;
    private boolean completed;
    private Timestamp created;

    public LocalDate getDeadline(){
        return LocalDate.parse(deadline);
    }
}
