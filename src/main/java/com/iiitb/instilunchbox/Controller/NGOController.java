package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.Institute;
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

    @GetMapping("/getByStatus")
    public ResponseEntity<List<NGO>> getAllInstiUsersByStatus(){
        List<NGO> newNGOUser = ngoService.findAllNgoUserByStatus();
        return new ResponseEntity<>(newNGOUser, HttpStatus.OK);
    }

    @GetMapping("{email}")
    public NGO getNGO(@PathVariable String email) {
        return ngoService.getNGOByEmail(email);
    }

    @PutMapping("/update")
    public  ResponseEntity<NGO> updateNGO(@RequestBody NGO ngo){
        System.out.println(ngo.getId());
        NGO newNgo = ngoService.updateNGO(ngo);
        return new ResponseEntity<>(newNgo, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{id}/{status}")
    public ResponseEntity<Integer> updateNgoUserByStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status){

        System.out.println(id);
        System.out.println(status);
        ngoService.updateNgoUserByStatus(id, status);
        if(status == 1){

            return new ResponseEntity<Integer>(1, HttpStatus.OK);
        }

        return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstituteById(@PathVariable Long id){
        ngoService.deleteNGOById(id);
        String res = "User deleted";
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }
}
