package com.project.dao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.project.dto.UserDTo;
import com.project.entity.User; // Assuming User is your entity class
import com.project.repository.UserRepository;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDao {
    @Autowired
    private ModelMapper mp;
    
    @Autowired
    private UserRepository userrepo;
    
    public ResponseEntity<Object> update(int id, UserDTo userDto) {
        // Fetch the existing user by id
        Optional<User> optionalUser = userrepo.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Map updated fields from UserDTo to the existing User entity
            mp.map(userDto, existingUser);

            // Save the updated user entity
            User updatedUser = userrepo.save(existingUser);

            // Return the updated user as the response
            return ResponseEntity.ok(updatedUser);
        } else {
            // Return a 404 Not Found response if the user is not found
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Object> insertAdminDetail(@Valid UserDTo ad) {
        // Map the UserDTo to the User entity
        User userEntity = mp.map(ad, User.class);
        
        // Save the User entity to the database
        User savedUser = userrepo.save(userEntity);
        
        // Return the saved user object or a success message
        return ResponseEntity.ok(savedUser);
    }

    public List<UserDTo> getAllRecords() {
        // Fetch all user entities from the database
        List<User> users = userrepo.findAll();

        // Convert each User entity to UserDto using ModelMapper
        return users.stream()
                    .map(user -> mp.map(user, UserDTo.class))
                    .collect(Collectors.toList());
    }

    public ResponseEntity<Object> findUserById(int uid) {
        // Fetch the user (admin) by id
        User user = userrepo.findById(uid).orElse(null);

        if (user == null) {
            // If user is not found, return 404 NOT FOUND response
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // Convert the User entity to UserDto using ModelMapper
        UserDTo userDto = mp.map(user, UserDTo.class);

        // Return the user data as a response with 200 OK status
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteById(int uid) {
        // Check if the user exists in the database
        boolean exists = userrepo.existsById(uid);
        
        if (!exists) {
            // If the user doesn't exist, return a NOT FOUND response
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        
        // Delete the user by id
        userrepo.deleteById(uid);
        
        // Return a success response indicating the user has been deleted
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
