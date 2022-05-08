package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.Institute;
import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/institute")
public class InstituteController {
    private final InstituteService instituteService;

    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping("/add")
    public ResponseEntity<Institute> addNewInstitute(@RequestBody Institute institute) {
        return new ResponseEntity<>(instituteService.addNewInstitute(institute), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Institute>> getAllInstitutes() {
        return new ResponseEntity<List<Institute>>(instituteService.getAllInstitutes(),HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Institute> getInsitute(@PathVariable String email) {
        return new ResponseEntity<Institute>(instituteService.getInstituteByEmail(email),HttpStatus.OK);
    }

    @PutMapping("/update")
    public  ResponseEntity<Institute> updateInstitute(@RequestBody Institute institute){
        System.out.println(institute.getId());
        Institute institute1 = instituteService.updateInstitute(institute);
        return new ResponseEntity<>(institute1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstituteById(@PathVariable Long id){
        instituteService.deleteInstituteById(id);
        String res = "User deleted";
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }
}
