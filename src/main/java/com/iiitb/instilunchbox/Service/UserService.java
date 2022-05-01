package com.iiitb.instilunchbox.Service;

import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user){
        Optional<User> ngoOptional = userRepository.findUserByEmail(user.getEmail());
        if (ngoOptional.isPresent()) {
            throw new IllegalStateException("User already Present.");
        }
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        Optional<User> ngoOptional = userRepository.findUserByEmail(email);
        if (ngoOptional.isEmpty()) {
            throw new IllegalStateException("User Not Found.");
        }
        return ngoOptional.get();
    }
}
