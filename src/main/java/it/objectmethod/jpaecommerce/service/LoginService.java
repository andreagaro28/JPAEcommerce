package it.objectmethod.jpaecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.dto.LoginDto;
import it.objectmethod.jpaecommerce.repo.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	public ResponseEntity<LoginDto> getLoginDto(String name, String password) {
		LoginDto user = null;
		ResponseEntity<LoginDto> resp = null;
		Optional<LoginDto> optLoginDto = loginRepo.getUserDto(name, password);

		if (optLoginDto.isPresent()) {
			user = optLoginDto.get();
			resp = new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return resp;
	}

}
