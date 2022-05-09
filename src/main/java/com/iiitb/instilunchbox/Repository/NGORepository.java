package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.NGO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface NGORepository extends JpaRepository<NGO,Long> {
    Optional<NGO> findNGOByEmail(String email);

    void removeNGOById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE instilunchbox.ngo SET status = :stat where id = :id", nativeQuery = true)
    Integer updateNgoUserStatusById(@RequestParam("id") Long id, @RequestParam("stat") Integer stat);


    @Query(value = "SELECT * FROM instilunchbox.ngo where status = 0;", nativeQuery = true)
    List<NGO> findAllNgoUsersByStatus();
}
