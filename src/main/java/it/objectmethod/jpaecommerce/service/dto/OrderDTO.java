package it.objectmethod.jpaecommerce.service.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	private Long id;
	private String numOrder;
	private LocalDate date;
	private String userName;
	private Long userId;
	private List<OrderRowDTO> orderList;

}
