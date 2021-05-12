package it.objectmethod.jpaecommerce.service.dto;

import it.objectmethod.jpaecommerce.entity.Articles;
import lombok.Data;

@Data
public class CartDetailDTO {

	private Long id;
	private Integer quantita;
	private Articles articleId;
}
