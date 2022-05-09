package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.FoodItem;
import com.iiitb.instilunchbox.Service.FoodItemService;
import com.iiitb.instilunchbox.Service.LunchboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

@RestController
@RequestMapping("/api/fooditem")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("")
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem foodItem) {
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

    @PutMapping("/put")
    public ResponseEntity<FoodItem> updateFoodItem(@RequestBody FoodItem foodItem) {
        return new ResponseEntity<FoodItem>(foodItemService.updateFooditem(foodItem),HttpStatus.OK);
    }
}
