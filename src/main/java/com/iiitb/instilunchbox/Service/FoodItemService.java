package com.iiitb.instilunchbox.Service;

import com.iiitb.instilunchbox.Model.FoodItem;
import com.iiitb.instilunchbox.Model.Lunchbox;
import com.iiitb.instilunchbox.Repository.FoodItemRepository;
import com.iiitb.instilunchbox.Repository.LunchboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private LunchboxService lunchboxService;

    @Autowired
    private LunchboxRepository lunchboxRepository;


    public FoodItem addFoodItem(FoodItem foodItem) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.getFoodItemByFname((foodItem.getFname()));
        if (optionalFoodItem.isPresent()) throw new IllegalStateException("Food Item already present.");
        else {
            Lunchbox lunchbox = foodItem.getLunchbox();
            lunchboxService.addLunchbox(lunchbox);
            return foodItemRepository.save(foodItem);
        }
    }

    public FoodItem updateFooditem(FoodItem foodItem) {
//        FoodItem foodItem1 = foodItemRepository.getById(id);
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItem() {
        return foodItemRepository.findAll();
    }
}
