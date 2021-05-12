package it.objectmethod.jpaecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<UserDTO> login(LoginDTO userLogin) {
		Optional<Login> optUser = loginRepo.findByUserNameAndPassword(userLogin.getUserName(), userLogin.getPassword());
		ResponseEntity<UserDTO> resp = null;
		UserDTO userDto = null;
		if (optUser.isPresent()) {
			userDto = mapper.toDto(optUser.get());
			resp = new ResponseEntity<>(userDto, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<>(userDto, HttpStatus.NO_CONTENT);
		}
		return resp;
	}

}
