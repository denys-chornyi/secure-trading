package tum.hackatum.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tum.hackatum.userservice.dto.UserCreateRequest;
import tum.hackatum.userservice.dto.UserCreateResponse;
import tum.hackatum.userservice.dto.UserLoginRequest;
import tum.hackatum.userservice.dto.UserLoginResponse;
import tum.hackatum.userservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.isCreated(userCreateRequest) ?
                new ResponseEntity<>(UserCreateResponse.builder()
                        .response("User is created")
                        .build(), HttpStatus.OK):
                new ResponseEntity<>(UserCreateResponse.builder()
                        .response("Unable to create user")
                        .build(), HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.exists(userLoginRequest) ?
                new ResponseEntity<>(UserLoginResponse.builder()
                        .response("User is logged in")
                        .build(), HttpStatus.OK) :
                new ResponseEntity<>(UserLoginResponse.builder()
                        .response("Unable to login user")
                        .build(), HttpStatus.NOT_ACCEPTABLE);
    }

}