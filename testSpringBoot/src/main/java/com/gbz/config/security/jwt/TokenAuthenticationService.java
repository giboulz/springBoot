package com.gbz.config.security.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class TokenAuthenticationService {
	// 10 jours
	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 10;

	private static final String SECRET = "ThisIsASecret";
	private static final String TOKEN_PREFIX = "Bearer";
	private static final String HEADER_STRING = "Authorization";

	public void addAuthentication(HttpServletResponse response, String username) {
		// We generate a token now.
		String jwt = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
	}

	public Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(HEADER_STRING);

		if (token != null) {
			return loadTokenAndGetUser(token);
		}
		return null;
	}

	private Authentication loadTokenAndGetUser(String token) {
		String username = "";
		try {
			username = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException exception) {
			// TODO : log
			return null;
		}

		if (username != null) {
			return new AuthenticatedUser(username);
		}
		return null;
	}
}
