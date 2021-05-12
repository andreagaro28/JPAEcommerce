package it.objectmethod.jpaecommerce.service.dto;

import lombok.Data;

@Data
public class OrderRowDTO {
	private Long id;
	private Long orderId;
	private Integer quantity;
	private ArticleDTO article;
}
