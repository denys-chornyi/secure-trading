package tum.hackatum.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tum.hackatum.userservice.dto.UserCreateDto;
import tum.hackatum.userservice.dto.UserCreateResponse;
import tum.hackatum.userservice.dto.UserLoginDto;
import tum.hackatum.userservice.dto.UserLoginResponse;
import tum.hackatum.userservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserServiceController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserCreateResponse userToCreate = userService.createUser(userCreateDto);
        return new ResponseEntity<>(userToCreate, userToCreate.getHttpStatus());
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginDto userLoginDto) {
        UserLoginResponse userToCreate = userService.loginUser(userLoginDto);
        return new ResponseEntity<>(userToCreate, userToCreate.getHttpStatus());
    }

}