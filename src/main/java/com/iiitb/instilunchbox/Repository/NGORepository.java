package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.NGO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NGORepository extends JpaRepository<NGO,Long> {
    Optional<NGO> findNGOByEmail(String email);
}
