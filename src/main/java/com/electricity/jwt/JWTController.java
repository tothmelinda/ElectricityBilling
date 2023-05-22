package com.electricity.jwt;

import com.electricity.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class JWTController {

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest, HttpServletResponse response){
        String username = authRequest.getEmail();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(authRequest.getEmail());
            final Cookie cookie = new Cookie("auth", token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(Integer.MAX_VALUE);
            cookie.setPath("/**");
            response.addCookie(cookie);
            return token;
        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }
    }
}
