package com.bhargav.training.PhotoAppUsers.security;

import com.bhargav.training.PhotoAppUsers.model.CreateUserModel;
import com.bhargav.training.PhotoAppUsers.model.UsersDTO;
import com.bhargav.training.PhotoAppUsers.restcontrolloers.UserService;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AuthenticateFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;

    public AuthenticateFilter(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        CreateUserModel createUserModel = null;
        try {
            createUserModel = new Gson().fromJson(request.getReader(), CreateUserModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.getAuthenticationManager().
                authenticate(
                        new UsernamePasswordAuthenticationToken(createUserModel.getEmail(), createUserModel.getPassword()));

    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String userName = ((User) authResult.getPrincipal()).getUsername();
        UsersDTO usersDTO = userService.getUserDetailsByEmail(userName);
        String token = Jwts.builder().setSubject(usersDTO.getEmail()).setExpiration(new Date(System.currentTimeMillis() + 101212002)).signWith(SignatureAlgorithm.HS512, "hre234ytesq23123").compact();
        response.addHeader("token", token);
        response.addHeader("userid", usersDTO.getUserInfo());


    }


}
