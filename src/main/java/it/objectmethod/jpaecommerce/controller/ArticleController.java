package it.objectmethod.jpaecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.service.ArticleService;
import it.objectmethod.jpaecommerce.service.dto.ArticleDTO;

@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleServ;

	@PostMapping("/all")
	public ResponseEntity<List<ArticleDTO>> getArticles() {
		ResponseEntity<List<ArticleDTO>> articleListDto = articleServ.getArticles();
		return articleListDto;
	}

	@PostMapping("/{id}")
	public ResponseEntity<ArticleDTO> findArticleById(@PathVariable("id") Long id) {
		ResponseEntity<ArticleDTO> article = articleServ.findDistinctById(id);
		return article;
	}

}
