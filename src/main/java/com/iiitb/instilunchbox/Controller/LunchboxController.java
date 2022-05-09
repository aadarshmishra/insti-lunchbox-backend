package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.Lunchbox;
import com.iiitb.instilunchbox.Service.LunchboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lunchbox")
public class LunchboxController {

    @Autowired
    private LunchboxService lunchboxService;

    @PostMapping
    public ResponseEntity<Lunchbox> addLunchbox(@RequestBody Lunchbox lunchbox) {
        return new ResponseEntity<Lunchbox>(lunchboxService.addLunchbox(lunchbox), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Lunchbox>> getAllLunchbox() {
        return new ResponseEntity<List<Lunchbox>>(lunchboxService.getAllLunchbox(),HttpStatus.OK);
    }
}
