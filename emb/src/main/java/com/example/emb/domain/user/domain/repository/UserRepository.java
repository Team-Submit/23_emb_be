package com.example.emb.domain.user.domain.repository;

import com.example.emb.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
    Optional<User> findByUserName(String username);

>>>>>>> Stashed changes
=======
    Optional<User> findByUsername(String username);

>>>>>>> develop
=======
    Optional<User> findByUsername(String username);

>>>>>>> develop
}
