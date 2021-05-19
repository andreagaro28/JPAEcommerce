package it.objectmethod.jpaecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.repo.CartRepo;
import it.objectmethod.jpaecommerce.repo.LoginRepo;
import it.objectmethod.jpaecommerce.service.dto.LoginDTO;
import it.objectmethod.jpaecommerce.service.dto.UserDTO;
import it.objectmethod.jpaecommerce.service.mapper.UserMapper;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private CartRepo cartRep;

	public UserDTO login(LoginDTO userLogin) {
		Optional<Login> optUser = loginRepo.findByUserNameAndPassword(userLogin.getUserName(), userLogin.getPassword());
		UserDTO userDto = null;

		if (optUser.isPresent()) {
			userDto = mapper.toDto(optUser.get());
		}

		Login user = optUser.get();
		Cart cartCheck = cartRep.findByUserId(user.getId());

		if (cartCheck == null) {
			System.out.println("CREAZIONE NUOVO CARRELLO");
			Cart cart = new Cart();
			cart.setUser(user);
			cartRep.save(cart);
		}

		return userDto;
	}

}
