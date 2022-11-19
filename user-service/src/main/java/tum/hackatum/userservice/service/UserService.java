package tum.hackatum.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tum.hackatum.userservice.dto.*;
import tum.hackatum.userservice.model.User;
import tum.hackatum.userservice.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreateResponse createUser(UserCreateDto userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
        if (user.getPassword().equals("") || user.getPassword() == null ||
            user.getUsername().equals("") || user.getUsername() == null) {
            return UserCreateResponse.builder()
                    .response("Unable to create user")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
        boolean usernameNotExists = userRepository.getByUsername(user.getUsername()).isEmpty();
        if (usernameNotExists) {
            userRepository.save(user);
            return UserCreateResponse.builder()
                    .response("User is created")
                    .httpStatus(HttpStatus.OK)
                    .build();
        } else {
            return UserCreateResponse.builder()
                    .response("Unable to create user")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    public UserLoginResponse loginUser(UserLoginDto userLoginRequest) {
        if (userRepository.getByUsername(userLoginRequest.getUsername()).isPresent() &&
                Objects.equals(userRepository.getByUsername(userLoginRequest.getUsername()).get().getPassword(), userLoginRequest.getPassword())) {
            return UserLoginResponse.builder()
                    .response("User is logged in")
                    .httpStatus(HttpStatus.OK)
                    .build();
        } else {
            return UserLoginResponse.builder()
                    .response("Unable to login user")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    public ValidationResponse validateUser(String username, String password) {
        List<User> users = userRepository.findAll();
        return ValidationResponse.builder()
                .isValid(users.stream()
                        .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password)))
                .build();

    }
}
