package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"John Travolta","john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Will smith","will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Jim Carry","jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Arnold Schwarzenneger","arnold", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"mai@mai.fr","mai@mai.fr", "1234", new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("john","ROLE_MANAGER");
			userService.addRoleToUser("will","ROLE_MANAGER");
			userService.addRoleToUser("jim","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_USER");
			userService.addRoleToUser("mai@mai.fr","ROLE_ADMIN");
			userService.addRoleToUser("mai@mai.fr","ROLE_USER");
		};

	}

}
