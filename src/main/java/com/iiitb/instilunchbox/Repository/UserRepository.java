package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
