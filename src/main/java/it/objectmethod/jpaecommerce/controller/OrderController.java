package it.objectmethod.jpaecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.service.OrderService;
import it.objectmethod.jpaecommerce.service.dto.OrderDTO;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderServ;

	@PostMapping("/{userId}")
	public ResponseEntity<List<OrderDTO>> getOrderByUserId(@PathVariable Long userId) {
		List<OrderDTO> orderList = orderServ.getOrderByUserId(userId);
		ResponseEntity<List<OrderDTO>> resp = new ResponseEntity<>(orderList, HttpStatus.OK);
		if (orderList.isEmpty()) {
			resp = new ResponseEntity<>(orderList, HttpStatus.NO_CONTENT);
		}
		return resp;
	}

	@PostMapping("/update/{userId}")
	public void insertOrder(@RequestParam String numOrder, @PathVariable Long userId) {
		orderServ.insertOrder(numOrder, userId);
	}
}
