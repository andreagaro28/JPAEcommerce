package it.objectmethod.jpaecommerce.service.dto;

import it.objectmethod.jpaecommerce.entity.Article;
import lombok.Data;

@Data
public class CartDetailDTO {

	private Long id;
	private Integer quantita;
	private Article article;
}
