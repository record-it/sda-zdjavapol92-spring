package pl.sda.springzdjavapol92.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EntityBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String author;
}
