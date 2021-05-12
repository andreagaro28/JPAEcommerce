package it.objectmethod.jpaecommerce.service.dto;

import lombok.Data;

@Data
public class ArticleDTO {

	private Long id;
	private String name;
	private Integer available;
	private String articleCode;
	private Double price;

}
