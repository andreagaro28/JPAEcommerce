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
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/cart")
@Log4j2
public class CartDetailController {

	@Autowired
	private CartDetailService cartDetServ;

	@Autowired
	private JWTService jwtServ;

	@PostMapping("/user")
	public ResponseEntity<CompleteCartDTO> findByUserId(@RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		log.info("Method GET CART. User {}, id {}, requested his cart", user.getUserName(), user.getId());
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
		log.info("Method UPDATE CART. User {}, id {}, updates cart with article {}", user.getUserName(), user.getId(),
				articleId);
		cartDetServ.updateCart(quantity, articleId, user.getId());
	}

	@PostMapping("/insert/{quantity}/{articleId}")
	public void insertIntoCart(@PathVariable int quantity, @PathVariable Long articleId,
			@RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		log.info("Method INSERT INTO CART. User {}, id {}, insert article {} to cart", user.getUserName(), user.getId(),
				articleId);
		cartDetServ.insertIntoCart(quantity, articleId, user.getId());
	}

	@PostMapping("/delete/{articleId}")
	public void deleteArticleInCart(@PathVariable Long articleId, @RequestHeader("auth-token") String authToken) {
		Login user = jwtServ.getUserByToken(authToken);
		log.info("Method DELETE ARTICLE CART. User {}, id {}, delete article {} by cart", user.getUserName(),
				user.getId(), articleId);
		cartDetServ.deleteArticleInCart(user.getId(), articleId);
	}
}
