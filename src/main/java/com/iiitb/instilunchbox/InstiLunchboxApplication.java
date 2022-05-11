package com.iiitb.instilunchbox;

import com.iiitb.instilunchbox.Model.Institute;
import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Repository.InstituteRepository;
import com.iiitb.instilunchbox.Repository.UserRepository;
import com.iiitb.instilunchbox.Service.InstituteService;
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
		SpringApplication.run(InstiLunchboxApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialData(UserRepository userRepository, InstituteService instituteService) {
		return args -> {
			if (!userRepository.existsById(1L)) {
				userRepository.save(new User("admin@gmail.com", "admin", "admin"));
			}
		};
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers", "No-Auth"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
