package pl.sda.springzdjavapol92.model;
import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@Builder
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
