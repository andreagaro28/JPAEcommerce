package it.objectmethod.jpaecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.service.CartDetailService;
import it.objectmethod.jpaecommerce.service.dto.CompleteCartDTO;

@RestController
@RequestMapping("/cart")
public class CartDetailController {

	@Autowired
	private CartDetailService cartDetServ;

	@PostMapping("/{userId}")
	public CompleteCartDTO findByUserId(@PathVariable("userId") Long userId) {
		CompleteCartDTO cartDetList = cartDetServ.findByUserId(userId);
		return cartDetList;
	}

	@PostMapping("/update/{quantity}/{articleId}/{cartId}/{userId}")
	public void updateCart(@PathVariable int quantity, @PathVariable Long articleId, @PathVariable Long cartId,
			@PathVariable Long userId) {
		cartDetServ.updateCart(quantity, articleId, cartId, userId);
	}

	@PostMapping("/insert/{quantity}/{articleId}/{userId}")
	public void insertIntoCart(@PathVariable int quantity, @PathVariable Long articleId, @PathVariable Long userId) {
		cartDetServ.insertIntoCart(quantity, articleId, userId);
	}

	@PostMapping("/delete/{cartId}/{articleId}")
	public void deleteArticleInCart(@PathVariable Long cartId, @PathVariable Long articleId) {
		cartDetServ.deleteArticleInCart(cartId, articleId);
	}
}
