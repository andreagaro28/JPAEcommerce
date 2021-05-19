package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;

import it.objectmethod.jpaecommerce.entity.Article;
import it.objectmethod.jpaecommerce.service.dto.ArticleDTO;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

	@Override
	ArticleDTO toDto(Article entity);

	@Override
	Article toEntity(ArticleDTO dto);
}
