package it.objectmethod.jpaecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Articles;
import it.objectmethod.jpaecommerce.repo.ArticleRepo;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepo articleRepo;

	public ResponseEntity<List<Articles>> getArticles() {
		ResponseEntity<List<Articles>> resp = null;
		List<Articles> articleList = articleRepo.getArticles();

		if (articleList.isEmpty()) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			resp = new ResponseEntity<>(articleList, HttpStatus.OK);

		}
		return resp;
	}

	public Articles findDistinctById(Long id) {
		Articles article = articleRepo.findDistinctById(id);
		return article;
	}

}
