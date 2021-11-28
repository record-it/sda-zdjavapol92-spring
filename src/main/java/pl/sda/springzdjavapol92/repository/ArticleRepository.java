package pl.sda.springzdjavapol92.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springzdjavapol92.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
