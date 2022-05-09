package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.Lunchbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LunchboxRepository extends JpaRepository<Lunchbox,Long> {

}
