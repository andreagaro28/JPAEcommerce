package it.objectmethod.jpaecommerce.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.repo.CartRepo;

@Component
public class JWTService {

	@Autowired
	private CartRepo cartRep;

	private static final String MY_SECRET_JWT_KEY = "my-secret-jwt-key";

	public String CreateJWTToken(Login user) {
		Calendar calendar = Calendar.getInstance();

		int minute = calendar.get(Calendar.MINUTE) + 5;
		// if (seconds > 60) {
		// seconds -= 60;
		// calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 1);
		// }
		calendar.set(Calendar.MINUTE, minute);

		Algorithm algo = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		Cart cart = cartRep.findByUserIdId(user.getId());

		String token = JWT.create().withClaim("userId", user.getId()).withClaim("userName", user.getUserName())
				.withExpiresAt(calendar.getTime()).sign(algo);
		return token;
	}

	public boolean checkJWTToken(String token) {
		boolean validToken = false;
		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(token);

			Long userId = decoded.getClaim("userId").asLong();
			String userName = decoded.getClaim("userName").asString();

			validToken = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validToken;
	}

	public Login getUserByToken(String token) {
		Login user = new Login();
		Algorithm algo = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		try {
			JWTVerifier verif = JWT.require(algo).build();
			DecodedJWT decode = verif.verify(token);

			Long userId = decode.getClaim("userId").asLong();
			String userName = decode.getClaim("userName").asString();

			user.setId(userId);
			user.setUserName(userName);
			System.out.println("Utente verificato! " + userId + " - " + userName);

		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		}
		return user;
	}

}
