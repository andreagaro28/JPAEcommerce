package it.objectmethod.jpaecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.service.LoginService;
import it.objectmethod.jpaecommerce.service.dto.LoginDTO;
import it.objectmethod.jpaecommerce.service.dto.UserDTO;

@RestController
public class LoginController {

	@Autowired
	private LoginService logService;

	@PostMapping("login")
	public ResponseEntity<UserDTO> login(@RequestBody LoginDTO userLogin) {
		ResponseEntity<UserDTO> user = logService.login(userLogin);
		return user;
	}
}
