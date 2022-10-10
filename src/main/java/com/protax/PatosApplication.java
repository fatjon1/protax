package com.protax;

import com.protax.entity.role.Role;
import com.protax.entity.user.User;
import com.protax.entity.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatosApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
    @Bean
	CommandLineRunner run(UserService userService){
		return args -> {

			userService.saveUser(
					new User(null, "pago", "pago_app", "@PagoAPP22",
							new ArrayList<>())).setRoles(List.of(new Role(null, "pago_app")));


		};
	}

}
