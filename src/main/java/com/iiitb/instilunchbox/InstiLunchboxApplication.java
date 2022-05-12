package com.iiitb.instilunchbox;

import com.iiitb.instilunchbox.Model.Institute;
import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Repository.InstituteRepository;
import com.iiitb.instilunchbox.Repository.UserRepository;
import com.iiitb.instilunchbox.Service.InstituteService;
import com.iiitb.instilunchbox.Service.MailSenderService;
import com.iiitb.instilunchbox.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class InstiLunchboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstiLunchboxApplication.class, args);;
	}

	@Bean
	public CommandLineRunner initialData(UserRepository userRepository, UserService userService) {
		return args -> {
			if (!userRepository.existsById(1L)) {
				userService.addNewUser(new User("admin@gmail.com", "admin", "admin"));
			}
		};
	}
}
