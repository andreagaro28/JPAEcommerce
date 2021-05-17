package it.objectmethod.jpaecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.service.CartDetailService;
import it.objectmethod.jpaecommerce.service.JWTService;
import it.objectmethod.jpaecommerce.service.dto.CompleteCartDTO;

@RestController
@RequestMapping("/cart")
public class CartDetailController {

	@Autowired
	private CartDetailService cartDetServ;

	@Autowired
	private JWTService jwtServ;

	@PostMapping("/user")
	public ResponseEntity<CompleteCartDTO> findByUserId(@RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		CompleteCartDTO cartDetList = cartDetServ.findByUserId(user.getId());
		ResponseEntity<CompleteCartDTO> resp = new ResponseEntity<>(cartDetList, HttpStatus.OK);
		if (cartDetList == null) {
			resp = new ResponseEntity<>(cartDetList, HttpStatus.NO_CONTENT);
		}
		return resp;
	}

	@PostMapping("/update/{quantity}/{articleId}")
	public void updateCart(@PathVariable int quantity, @PathVariable Long articleId,
			@RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		cartDetServ.updateCart(quantity, articleId, user.getId());
	}

	@PostMapping("/insert/{quantity}/{articleId}")
	public void insertIntoCart(@PathVariable int quantity, @PathVariable Long articleId,
			@RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		cartDetServ.insertIntoCart(quantity, articleId, user.getId());
	}

	@PostMapping("/delete/{articleId}")
	public void deleteArticleInCart(@PathVariable Long articleId, @RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		cartDetServ.deleteArticleInCart(user.getId(), articleId);
	}
}
