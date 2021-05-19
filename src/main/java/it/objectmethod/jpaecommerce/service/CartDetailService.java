package it.objectmethod.jpaecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Article;
import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.entity.CartDetail;
import it.objectmethod.jpaecommerce.repo.ArticleRepo;
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

	@Autowired
	private ArticleRepo artRep;

	public CompleteCartDTO findByUserId(Long userId) {
		CompleteCartDTO cartDetailList = cartMapper.toDto(cartRep.findByUserId(userId));
		return cartDetailList;
	}

	public void updateCart(int quantity, Long articleId, Long userId) {
		Optional<CartDetail> cartOpt = cartDetRep.findByCartUserIdAndArticleId(userId, articleId);
		CartDetail cartDet = null;
		if (cartOpt.isPresent()) {
			cartDet = cartOpt.get();
			cartDet.setQuantita(quantity);
			cartDetRep.save(cartDet);
		} else {
			insertIntoCart(quantity, articleId, userId);
		}
	}

	public void insertIntoCart(int quantity, Long articleId, Long userId) {
		CartDetail cartDet = new CartDetail();
		Cart cart = cartRep.findByUserId(userId);
		Optional<Article> article = artRep.findDistinctById(articleId);
		cartDet.setQuantita(quantity);
		cartDet.setCart(cart);
		cartDet.setArticle(article.get());
		cartDetRep.save(cartDet);

	}

	public void deleteArticleInCart(Long userId, Long articleId) {
		Cart cart = cartRep.findByUserId(userId);
		cartDetRep.deleteByCartIdAndArticleId(cart.getId(), articleId);
	}
}
