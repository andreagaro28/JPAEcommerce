package it.objectmethod.jpaecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.CartDetail;
import it.objectmethod.jpaecommerce.repo.CartDetailRepo;
import it.objectmethod.jpaecommerce.repo.CartRepo;
import it.objectmethod.jpaecommerce.service.dto.CompleteCartDTO;
import it.objectmethod.jpaecommerce.service.mapper.CompleteCartMapper;

@Service
public class CartDetailService {

	@Autowired
	private CartDetailRepo cartDetRep;

	@Autowired
	private CartRepo cartRep;

	@Autowired
	private CompleteCartMapper cartMapper;

	public CompleteCartDTO findByUserId(Long userId) {
		CompleteCartDTO cartDetailList = cartMapper.toDto(cartRep.findByUserIdId(userId));
		return cartDetailList;
	}

	public void updateCart(int quantity, Long articleId, Long cartId, Long userId) {
		Optional<CartDetail> cartOpt = cartDetRep.findByCartUserIdIdAndArticleIdId(userId, articleId);
		CartDetail cartDet = null;
		if (cartOpt.isPresent()) {
			cartDet = cartOpt.get();
			cartDet.setQuantita(quantity);
			cartDetRep.save(cartDet);
		} else {
			insertIntoCart(quantity, articleId, cartId);
		}
	}

	public void insertIntoCart(int quantity, Long articleId, Long cartId) {
		cartDetRep.insertIntoCart(quantity, articleId, cartId);
	}

	public void deleteArticleInCart(Long cartId, Long articleId) {
		cartDetRep.deleteArticleInCart(cartId, articleId);
	}
}
