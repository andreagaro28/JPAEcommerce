package it.objectmethod.jpaecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.Articles;

@Repository
public interface ArticleRepo extends JpaRepository<Articles, Long> {

	@Query(value = "select x from Articles x")
	public List<Articles> getArticles();

	public Articles findDistinctById(Long id);

}
