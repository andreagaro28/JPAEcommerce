package it.objectmethod.jpaecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.entity.Articles;
import it.objectmethod.jpaecommerce.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleServ;

	@GetMapping("/articles")
	public ResponseEntity<List<Articles>> getArticles() {
		ResponseEntity<List<Articles>> articleList = articleServ.getArticles();
		return articleList;
	}

	@GetMapping("/article-id/{id}")
	public Articles findArticleById(@PathVariable("id") Long id) {
		Articles article = articleServ.findDistinctById(id);
		return article;
	}

}
