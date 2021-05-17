package it.objectmethod.jpaecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<ArticleDTO> getArticles() {
		List<ArticleDTO> articleDto = mapper.toDto(articleRepo.getArticles());
		return articleDto;
	}

	public ArticleDTO findDistinctById(Long id) {
		Optional<Articles> optArticle = articleRepo.findDistinctById(id);
		ArticleDTO articleDto = null;
		if (optArticle.isPresent()) {
			articleDto = mapper.toDto(optArticle.get());
		}
		return articleDto;
	}

}
