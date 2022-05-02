package com.iiitb.instilunchbox.Service;

import com.iiitb.instilunchbox.Model.Institute;
import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InstituteService {

    @Autowired
    private UserService userService;

    @Autowired
    private InstituteRepository instituteRepository;

    public Institute addNewInstitute(Institute institute){
        Optional<Institute> instituteOptional = instituteRepository.findInstituteByEmail(institute.getEmail());
        if (instituteOptional.isPresent()) {
            throw new IllegalStateException("Institute Present.");
        }
        String email = institute.getEmail();
        String password = institute.getUser().getPassword();
        String role = "institute";
        User user = new User(email,password,role);
        userService.addNewUser(user);
        institute.setUser(user);
        return instituteRepository.save(institute);
    }

    public Institute getInstituteByEmail(String email) {
        Optional<Institute> instituteOptional = instituteRepository.findInstituteByEmail(email);
        if (instituteOptional.isEmpty()) {
            throw new IllegalStateException("Institute Not Found.");
        }
        return instituteOptional.get();
    }

    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }
}
