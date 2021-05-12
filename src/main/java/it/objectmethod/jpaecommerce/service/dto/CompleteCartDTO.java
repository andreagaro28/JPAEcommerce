package it.objectmethod.jpaecommerce.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class CompleteCartDTO {

	private Long cartId;
	private List<CartDetailDTO> cartList;

}
