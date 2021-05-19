package it.objectmethod.jpaecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.service.JWTService;
import it.objectmethod.jpaecommerce.service.OrderService;
import it.objectmethod.jpaecommerce.service.dto.OrderDTO;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {

	@Autowired
	private OrderService orderServ;

	@Autowired
	private JWTService jwtServ;

	@PostMapping("/user")
	public ResponseEntity<List<OrderDTO>> getOrderByUserId(@RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		log.info("Method GET ORDER. User {}, id {}, requires orders", user.getUserName(), user.getId());
		List<OrderDTO> orderList = orderServ.getOrderByUserId(user.getId());
		ResponseEntity<List<OrderDTO>> resp = new ResponseEntity<>(orderList, HttpStatus.OK);
		if (orderList.isEmpty()) {
			resp = new ResponseEntity<>(orderList, HttpStatus.NO_CONTENT);
		}
		return resp;
	}

	@PostMapping("/update")
	public void insertOrder(@RequestParam String numOrder, @RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		log.info("Method UPDATE ORDER. User {}, id {}, requires orders", user.getUserName(), user.getId());
		orderServ.insertOrder(numOrder, user.getId());
	}
}
