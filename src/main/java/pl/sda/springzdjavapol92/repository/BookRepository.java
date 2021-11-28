package pl.sda.springzdjavapol92.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springzdjavapol92.entity.EntityBook;

public interface BookRepository extends JpaRepository<EntityBook, Long> {
}
