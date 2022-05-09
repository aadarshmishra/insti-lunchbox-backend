package com.iiitb.instilunchbox.Repository;

import com.iiitb.instilunchbox.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    public Optional<FoodItem> getFoodItemByFname(String fname);
}
