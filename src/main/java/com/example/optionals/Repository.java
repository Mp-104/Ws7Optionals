package com.example.optionals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Repository extends JpaRepository<User, Long> {

    //Query
    Optional<User> findUserById ();

}
