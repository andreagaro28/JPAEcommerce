package it.objectmethod.jpaecommerce.service.mapper;

import org.mapstruct.Mapper;

import it.objectmethod.jpaecommerce.entity.Articles;
import it.objectmethod.jpaecommerce.service.dto.ArticleDTO;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends EntityMapper<ArticleDTO, Articles> {

	@Override
	ArticleDTO toDto(Articles entity);

	@Override
	Articles toEntity(ArticleDTO dto);
}
