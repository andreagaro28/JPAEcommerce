package it.objectmethod.jpaecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.service.JWTService;
import it.objectmethod.jpaecommerce.service.LoginService;
import it.objectmethod.jpaecommerce.service.dto.LoginDTO;
import it.objectmethod.jpaecommerce.service.dto.UserDTO;
import it.objectmethod.jpaecommerce.service.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class LoginController {

	@Autowired
	private LoginService logService;

	@Autowired
	private UserMapper logMap;

	@Autowired
	private JWTService jwtServ;

	@PostMapping("login")
	public ResponseEntity<UserDTO> login(@RequestBody LoginDTO userLogin) {
		log.info("!!!---Method LOGIN START, user {} is trying to log", userLogin.getUserName());
		UserDTO user = logService.login(userLogin);
		ResponseEntity<UserDTO> resp = null;
		if (user == null) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			resp = new ResponseEntity<>(user, HttpStatus.OK);
			log.info("User {}, id {}, has just logged", user.getUserName(), user.getId());
		}
		Login userEntity = logMap.toEntity(user);
		String token = jwtServ.CreateJWTToken(userEntity);
		System.out.println(token);
		return resp;
	}
}
