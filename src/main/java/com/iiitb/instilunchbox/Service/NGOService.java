package com.iiitb.instilunchbox.Service;

import com.iiitb.instilunchbox.Model.Institute;
import com.iiitb.instilunchbox.Model.NGO;
import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Repository.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NGOService {

    @Autowired
    private UserService userService;

    @Autowired
    private NGORepository ngoRepository;

    public NGO addNewNGO(NGO ngo){
        Optional<NGO> ngoOptional = ngoRepository.findNGOByEmail(ngo.getEmail());
        if (ngoOptional.isPresent()) {
            throw new IllegalStateException("NGO Present.");
        }
        String email = ngo.getEmail();
        String password = ngo.getUser().getPassword();
        String role = "ngo";
        User user = new User(email,password,role);
        userService.addNewUser(user);
        ngo.setUser(user);
        return ngoRepository.save(ngo);
    }

    public NGO getNGOByEmail(String email) {
        Optional<NGO> ngoOptional = ngoRepository.findNGOByEmail(email);
        if (ngoOptional.isEmpty()) {
            throw new IllegalStateException("NGO Not Found.");
        }
        return ngoOptional.get();
    }

    public List<NGO> getAllNGO() {
        return ngoRepository.findAll();
    }

    public NGO updateNGO(NGO ngo) {
        return ngoRepository.save(ngo);
    }
    @Transactional
    public void deleteNGOById(Long id) {
        ngoRepository.removeNGOById(id);
        return ;
    }

    public Integer updateNgoUserByStatus(Long id, Integer status) {
        return ngoRepository.updateNgoUserStatusById(id, status);
    }

    public List<NGO> findAllNgoUserByStatus(){
        return (List<NGO>) ngoRepository.findAllNgoUsersByStatus();
    }
}
