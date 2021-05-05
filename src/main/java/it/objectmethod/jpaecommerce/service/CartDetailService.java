package it.objectmethod.jpaecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.repo.CartDetailRepo;

@Service
public class CartDetailService {

	@Autowired
	private CartDetailRepo cartDetRep;

	public List<Cart> findByCartId(Long cartId) {
		List<Cart> cartDetailList = cartDetRep.findByCartId(cartId);
		return cartDetailList;
	}
}
