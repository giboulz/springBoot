package com.gbz.services;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.security.Key;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JwtTokenLibTest {

	@Test
	public void test_token_jwt() {

		// Arrange
		Key key = MacProvider.generateKey();

		// Act
		String compactJws = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, key).compact();
		// System.out.println(compactJws);
		// Assert
		Jws<Claims> res = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
		assertThat(res.getBody().getSubject(), is("Joe"));
	}

	@Test(expected = SignatureException.class)
	public void test_token_jwt_fail() {

		// Arrange
		Key key = MacProvider.generateKey();

		// Act
		String compactJws = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, key).compact();
		// System.out.println(compactJws);
		// Assert
		key = MacProvider.generateKey();

		Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);

	}

	@Test
	public void test_token() {
		String key = "ThisIsASecret";
		//String token = "eyJhbGciOiJIUzUxMiJ9.eyJMZGFwVXNlciI6eyJ1aWQiOiI1NDU1MDUiLCJtYWlsIjoibW9oYW1lZC5kaWFnb3VyYWdhQGV4dGVybmUuYm5wcGFyaWJhcy5jb20iLCJwaG9uZU51bWJlciI6IjAxIDU4IDk3IDcxIDQ4IiwicGFzc3dvcmRFeHBpcmF0aW9uIjoiMjEwMzIwODQiLCJyZWZMb25nQWJzZW5jZSI6IjAiLCJmaXJzdE5hbWUiOiJNb2hhbWVkIiwibGFzdE5hbWUiOiJESUFHT1VSQUdBIiwiZnVsbE5hbWUiOiJNb2hhbWVkIERJQUdPVVJBR0EifSwiZXhwIjoxNDgxMzY1MzMxfQ.eK7_eDpVtSIycJxWjO3WkiShyz7AUkgJbbMoCKPep0SE9Vr9P7l411Dno6zvj3i3c666JMc7wFY7sQFpUo4Kjw";
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJMZGFwVXNlciI6eyJ1aWQiOiI1NDU1MDUiLCJtYWlsIjoibW9oYW1lZC5kaWFnb3VyYWdhQGV4dGVybmUuYm5wcGFyaWJhcy5jb20iLCJwaG9uZU51bWJlciI6IjAxIDU4IDk3IDcxIDQ4IiwicGFzc3dvcmRFeHBpcmF0aW9uIjoiMjEwMzIwODQiLCJyZWZMb25nQWJzZW5jZSI6IjAiLCJmaXJzdE5hbWUiOiJNb2hhbWVkIiwibGFzdE5hbWUiOiJESUFHT1VSQUdBIiwiZnVsbE5hbWUiOiJNb2hhbWVkIERJQUdPVVJBR0EifSwiZXhwIjoxNDgxMzg0MDI0fQ.YQCAoMJKFkl4NeG39k0iB4hdxZHfWjK4ujJpcD5D3gshbummNY2FLLJPYQzAPdPHrxhZlCvY11b411PJVEPs-w";

		System.out.println(Jwts.parser().setSigningKey(key).parseClaimsJws(token));
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody(); 
		System.out.println(claims);
		//LdapUser user = claims.get("LdapUser", LdapUser.class);
		Map<String, String> listLdapUser = claims.get("LdapUser", LinkedHashMap.class);
		System.out.println(listLdapUser);
		System.out.println("fin");
	}

}

