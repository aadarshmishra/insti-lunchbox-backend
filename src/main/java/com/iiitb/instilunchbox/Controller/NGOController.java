package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.NGO;
import com.iiitb.instilunchbox.Service.NGOService;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ngo")
public class NGOController {

    @Autowired
    private NGOService ngoService;

    @PostMapping("add")
    public ResponseEntity<NGO> addNewNGO(@RequestBody NGO ngo) {
        return new ResponseEntity<NGO>(ngoService.addNewNGO(ngo), HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<NGO>> getAllNGO() {
        return new ResponseEntity<List<NGO>>(ngoService.getAllNGO(),HttpStatus.OK);
    }

    @GetMapping("{email}")
    public NGO getNGO(@PathVariable String email) {
        return ngoService.getNGOByEmail(email);
    }
}
