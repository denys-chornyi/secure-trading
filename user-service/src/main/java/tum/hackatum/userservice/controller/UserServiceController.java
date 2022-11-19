package tum.hackatum.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-service")
public class UserServiceController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}