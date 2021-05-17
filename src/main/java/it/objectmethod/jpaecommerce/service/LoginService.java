package it.objectmethod.jpaecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Login;
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

	public UserDTO login(LoginDTO userLogin) {
		Optional<Login> optUser = loginRepo.findByUserNameAndPassword(userLogin.getUserName(), userLogin.getPassword());
		UserDTO userDto = null;

		if (optUser.isPresent()) {
			userDto = mapper.toDto(optUser.get());
		}
		return userDto;
	}

}
