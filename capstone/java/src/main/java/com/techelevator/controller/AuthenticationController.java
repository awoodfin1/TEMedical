package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.PatientDao;
import com.techelevator.dao.ProviderDao;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

import java.security.Principal;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    private PatientDao patientDao;
    private ProviderDao providerDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao, PatientDao patientDao, ProviderDao providerDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
        this.patientDao = patientDao;
        this.providerDao = providerDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDTO loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        
        User user = userDao.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponse(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterUserDTO newUser) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new UserAlreadyExistsException();
        } catch (UsernameNotFoundException e) {
            userDao.create(newUser.getUsername(),newUser.getPassword(), newUser.getRole(), newUser.getProvider());
            if(!newUser.getProvider()){
                //REGISTERS PATIENT
                patientDao.createPatient(userDao.findIdByUsername(newUser.getUsername()), newUser.getFirst_name(), newUser.getLast_name());
            }else{
                //REGISTERS PROVIDER
                providerDao.createProvider(userDao.findIdByUsername(newUser.getUsername()),  newUser.getFirst_name(), newUser.getLast_name());
            }
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public boolean getDisplayApptUpdate(Principal principal) {
        boolean displayApptUpdate = false;
        if (userDao.getIsProvider(principal.getName())) {
            Provider provider = providerDao.getProviderByUserId(userDao.findIdByUsername(principal.getName()));
            displayApptUpdate = provider.isDisplayApptUpdate();
        } else {
            Patient patient = patientDao.getPatientByUserId(userDao.findIdByUsername(principal.getName()));
            displayApptUpdate = patient.isDisplayApptUpdate();
        }
        return displayApptUpdate;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean flipDisplayApptUpdate(@RequestBody boolean displayApptUpdate, Principal principal) {
        if (userDao.getIsProvider(principal.getName())) {
            Provider provider = providerDao.getProviderByUserId(userDao.findIdByUsername(principal.getName()));
            if (displayApptUpdate) {
                providerDao.toggleOnDisplayApptUpdate(provider.getId());
            } else {
                providerDao.toggleOffDisplayApptUpdate(provider.getId());
            }
        } else {
            Patient patient = patientDao.getPatientByUserId(userDao.findIdByUsername(principal.getName()));
            if (displayApptUpdate) {
//                patientDao.toggleOnDisplayApptUpdate(patient.getId());
            } else {
//                patientDao.toggleOffDisplayApptUpdate(patient.getId());
            }
        }
        return displayApptUpdate;
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class LoginResponse {

        private String token;
        private User user;

        LoginResponse(String token, User user) {
            this.token = token;
            this.user = user;
        }

        @JsonProperty("token")
        String getToken() {
            return token;
        }

        void setToken(String token) {
            this.token = token;
        }

        @JsonProperty("user")
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
    }
}

