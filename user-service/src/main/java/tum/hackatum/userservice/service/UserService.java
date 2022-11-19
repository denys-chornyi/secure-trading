package tum.hackatum.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tum.hackatum.userservice.dto.UserCreateRequest;
import tum.hackatum.userservice.dto.UserLoginRequest;
import tum.hackatum.userservice.model.User;
import tum.hackatum.userservice.repository.UserRepository;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isCreated(UserCreateRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
        if (user.getPassword().equals("") || user.getPassword() == null ||
            user.getUsername().equals("") || user.getUsername() == null) {
            return false;
        }
        boolean usernameNotExists = userRepository.getByUsername(user.getUsername()).isEmpty();
        if (usernameNotExists) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean exists(UserLoginRequest userLoginRequest) {
        return userRepository.getByUsername(userLoginRequest.getUsername()).isPresent() &&
                Objects.equals(userRepository.getByUsername(userLoginRequest.getUsername()).get().getPassword(), userLoginRequest.getPassword());
    }
}
