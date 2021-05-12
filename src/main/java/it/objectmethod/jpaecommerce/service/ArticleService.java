package it.objectmethod.jpaecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Articles;
import it.objectmethod.jpaecommerce.repo.ArticleRepo;
import it.objectmethod.jpaecommerce.service.dto.ArticleDTO;
import it.objectmethod.jpaecommerce.service.mapper.ArticleMapper;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepo articleRepo;

	@Autowired
	private ArticleMapper mapper;

	public ResponseEntity<List<ArticleDTO>> getArticles() {
		ResponseEntity<List<ArticleDTO>> resp = null;
		List<Articles> articleList = articleRepo.getArticles();
		List<ArticleDTO> articleDto = new ArrayList<>();
		if (articleList.isEmpty()) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {

			articleDto = mapper.toDto(articleList);
			resp = new ResponseEntity<>(articleDto, HttpStatus.OK);
		}
		return resp;
	}

	public ResponseEntity<ArticleDTO> findDistinctById(Long id) {
		Optional<Articles> optArticle = articleRepo.findDistinctById(id);
		ArticleDTO articleDto = null;
		ResponseEntity<ArticleDTO> resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		if (optArticle.isPresent()) {
			articleDto = mapper.toDto(optArticle.get());
			resp = new ResponseEntity<>(articleDto, HttpStatus.OK);
		}
		return resp;
	}

}
