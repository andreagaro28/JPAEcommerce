package it.objectmethod.jpaecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.dto.LoginDto;
import it.objectmethod.jpaecommerce.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService logService;

	@PostMapping("/login")
	public ResponseEntity<LoginDto> getUserDto(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		ResponseEntity<LoginDto> user = logService.getLoginDto(userName, password);
		return user;
	}

}
