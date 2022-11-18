package com.ecommerce.mybookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyBookStore {

	public static void main(String[] args) {
		SpringApplication.run(MyBookStore.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/*@Bean
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

	}*/

}
