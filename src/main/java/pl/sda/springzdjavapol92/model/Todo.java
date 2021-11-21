package pl.sda.springzdjavapol92.model;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Todo {
    private long id;
    private String title;
    private String deadline;
    private String person;
    private boolean isCompleted;
    private Timestamp created;

    public LocalDate getDeadline(){
        return LocalDate.parse(deadline);
    }
}
