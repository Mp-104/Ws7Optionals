package com.example.optionals;


import com.example.optionals.Response.ErrorResponse;
import com.example.optionals.Response.UserResponse;
import com.example.optionals.Response.WsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final Repository userRepository;

    @Autowired
    public Controller (Repository userRepository) {
        this.userRepository = userRepository;

    }


    @GetMapping("/{id}")
    public ResponseEntity<WsResponse> findUserById (@PathVariable("id") Long id) {

        Optional<User> user = userRepository.findById(id);

        List<Optional<User>> userList = new ArrayList<>();
        userList.add(user);

        if (user.isPresent()) {

            // Converts Optional<User> to User
            User tempUser = user.get();

            List<User> userList1 = new ArrayList<>();

            userList1.add(tempUser);

            return ResponseEntity.ok(new UserResponse());
        }

        return ResponseEntity
                .status(204)
                .body(
                        new ErrorResponse("""
                            The user did not exist, try again!"""));

    }

}
