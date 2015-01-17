package org.lnu.is.security;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.domain.user.User;
import org.lnu.is.domain.user.UserRole;
import org.lnu.is.service.user.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAuthenticationProviderTest {

	@Mock
    private UserService userService;
    
	@Mock
	private Authentication authentication;

	@InjectMocks
	private DefaultAuthenticationProvider unit;
	
	@Test
	public void testSupports() throws Exception {
		// Given
		boolean expected = true;
		
		// When
		boolean actual = unit.supports(UsernamePasswordAuthenticationToken.class);
		
		// Then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAuthentificate() throws Exception {
		// Given
		String login = "login";
		String password = "password";
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(UserRole.ADMIN);
		
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getSecurityCode()));


        UsernamePasswordAuthenticationToken expected = new UsernamePasswordAuthenticationToken(login, password, authorities);
        expected.setDetails(user);
        
		// When
		when(authentication.getName()).thenReturn(login);
		when(authentication.getCredentials()).thenReturn(password);
		
		when(userService.getUserByLogin(anyString())).thenReturn(user);
		Authentication actual = unit.authenticate(authentication);

		// Then
		verify(userService).getUserByLogin(login);
		verify(authentication).getName();
		verify(authentication).getCredentials();
		assertEquals(expected, actual);
	}

	@Test(expected = BadCredentialsException.class)
	public void testAuthentificateWithException() throws Exception {
		// Given
		String login = "login";
		String credentials = "password";
		User user = new User();
		user.setLogin(login);
		user.setPassword(credentials);
		
		// When
		when(authentication.getName()).thenReturn(login);
		when(authentication.getCredentials()).thenReturn(credentials);
		
		when(userService.getUserByLogin(anyString())).thenThrow(new BadCredentialsException(""));
		unit.authenticate(authentication);
	}
}