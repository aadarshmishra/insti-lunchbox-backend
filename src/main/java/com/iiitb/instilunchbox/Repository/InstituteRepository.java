package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface InstituteRepository extends JpaRepository<Institute,Long> {
    Optional<Institute> findInstituteByEmail(String email);


    void removeInstituteById(Long id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE instilunchbox.institute SET status = :stat where id = :id", nativeQuery = true)
    Integer updateInstituteStatusById(@RequestParam("id") Long id, @RequestParam("stat") Integer stat);

    @Query(value = "SELECT * FROM instilunchbox.institute where status = 0;", nativeQuery = true)
    List<Institute> findAllInstiUsersByStatus();
}
