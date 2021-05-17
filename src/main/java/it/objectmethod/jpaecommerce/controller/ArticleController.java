package it.objectmethod.jpaecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		List<ArticleDTO> articleListDto = articleServ.getArticles();
		ResponseEntity<List<ArticleDTO>> resp = null;
		if (articleListDto.isEmpty()) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			resp = new ResponseEntity<>(articleListDto, HttpStatus.OK);
		}
		return resp;
	}

	@PostMapping("/{id}")
	public ResponseEntity<ArticleDTO> findArticleById(@PathVariable("id") Long id) {
		ArticleDTO article = articleServ.findDistinctById(id);
		ResponseEntity<ArticleDTO> resp = new ResponseEntity<>(article, HttpStatus.OK);

		if (article == null) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return resp;
	}

}
