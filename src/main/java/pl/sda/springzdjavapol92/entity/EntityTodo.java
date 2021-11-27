package pl.sda.springzdjavapol92.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "todos")
public class EntityTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate deadline;
    @Column(nullable = false)
    private String person;
    @Column(nullable = false)
    private boolean completed;

    @CreationTimestamp
    private Timestamp created;
}
