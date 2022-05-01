package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.Institute;
import com.iiitb.instilunchbox.Service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/institute")
public class InstituteController {
    private final InstituteService instituteService;

    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping("")
    public ResponseEntity<Institute> addNewInstitute(@RequestBody Institute institute) {
        return new ResponseEntity<>(instituteService.addNewInstitute(institute), HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    public ResponseEntity<Institute> getInsitute(@PathVariable String email) {
        return new ResponseEntity<Institute>(instituteService.getInstituteByEmail(email),HttpStatus.OK);
    }
}
