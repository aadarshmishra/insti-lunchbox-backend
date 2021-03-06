package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.FoodItem;
import com.iiitb.instilunchbox.Service.FoodItemService;
import com.iiitb.instilunchbox.Service.LunchboxService;
import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

@RestController
@RequestMapping("/api/fooditem")
public class FoodItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstituteController.class);

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("")
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem foodItem) {
        LOGGER.info("Food item added " + foodItem.getFname());
        return new ResponseEntity<FoodItem>(foodItemService.addFoodItem(foodItem), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        return new ResponseEntity<List<FoodItem>>(foodItemService.getAllFoodItem(),HttpStatus.OK);
    }

    @GetMapping("/getNGONames")
    public ResponseEntity<List<String>> getAllNGONames() {
        return new ResponseEntity<List<String>>(foodItemService.getAllNGONameFromFooditems(),HttpStatus.OK);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<List<FoodItem>> getFooditemOfInsti(@PathVariable String email) {
        return new ResponseEntity<List<FoodItem>>(foodItemService.getFooditemForInsti(email),HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<FoodItem> updateFoodItem(@RequestBody FoodItem foodItem) {
        return new ResponseEntity<FoodItem>(foodItemService.updateFooditem(foodItem),HttpStatus.OK);
    }
}
