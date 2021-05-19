package it.objectmethod.jpaecommerce.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {

	@Query(value = "select x from Article x")
	public List<Article> getArticles();

	public Optional<Article> findDistinctById(Long id);

}
