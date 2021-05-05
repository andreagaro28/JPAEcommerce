package it.objectmethod.jpaecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.service.CartDetailService;

@RestController
@RequestMapping("/cart")
public class CartDetailController {

	@Autowired
	private CartDetailService cartDetServ;

	@GetMapping("/{cartId}")
	public List<Cart> findByCartId(@PathVariable("cartId") Long cartId) {
		List<Cart> cartDetList = cartDetServ.findByCartId(cartId);
		return cartDetList;
	}

}
