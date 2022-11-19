package tum.hackatum.userservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tum.hackatum.userservice.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByUsername(String username);

}
