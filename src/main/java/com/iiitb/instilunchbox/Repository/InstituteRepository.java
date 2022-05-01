package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstituteRepository extends JpaRepository<Institute,Long> {
    Optional<Institute> findInstituteByEmail(String email);
}
