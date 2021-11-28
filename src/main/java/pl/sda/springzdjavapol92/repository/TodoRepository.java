package pl.sda.springzdjavapol92.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springzdjavapol92.entity.EntityTodo;

@Repository
public interface TodoRepository extends JpaRepository<EntityTodo, Long> {
}
