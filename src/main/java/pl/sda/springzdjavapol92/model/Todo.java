package pl.sda.springzdjavapol92.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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
}
