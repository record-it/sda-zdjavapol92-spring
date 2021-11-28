package pl.sda.springzdjavapol92.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.springzdjavapol92.entity.EntityBook;

import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<EntityBook, Long> {
    //,metody generowane przez Spring Jpa na podstawie sygnatury
    List<EntityBook> findByAuthor(String author);
    int countByAuthor(String author);
    int countByAuthorAndAndTitleStartingWith(String author, String titleStart);

    //metoda generowana na podsatwie JPQL w adnotacji @Query
    @Query(value = "select b.title from EntityBook b", nativeQuery = false)
    List<String> getAllTitles();

    //Przykład surowego wyniku zapytania
    @Query(value = "select b.id, b.title from EntityBook b", nativeQuery = false)
    List<Object[]> getIdAndTitles();
}
