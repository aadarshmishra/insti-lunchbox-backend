package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.JWTRequest;
import com.iiitb.instilunchbox.Model.JWTResponse;
import com.iiitb.instilunchbox.Service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JWTController {

    @Autowired
    private JWTService jwtService;

    @PostMapping("/authenticate")
    public JWTResponse createJWTToken(@RequestBody JWTRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
