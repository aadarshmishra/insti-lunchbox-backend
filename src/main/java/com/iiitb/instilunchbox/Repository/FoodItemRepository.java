package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    Optional<FoodItem> getFoodItemByFname(String fname);
    @Query("select f from FoodItem f where f.lunchbox.institute.email=?1")
    Optional<List<FoodItem>> getFoodItemByInstitute(String email);
}
