package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface InstituteRepository extends JpaRepository<Institute,Long> {
    Optional<Institute> findInstituteByEmail(String email);


    void removeInstituteById(Long id);
}
