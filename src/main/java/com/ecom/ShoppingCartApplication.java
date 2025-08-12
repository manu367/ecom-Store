package com.ecom;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ShoppingCartApplication {

	@Bean
	CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			String adminEmail = "admin@gmail.com";

			// Check if admin already exists
			if (!userRepository.existsByEmail(adminEmail)) {
				UserDtls admin = new UserDtls();
				admin.setName("Admin");
				admin.setEmail(adminEmail);
				admin.setPassword(passwordEncoder.encode("admin123")); // default password
				admin.setRole("ROLE_ADMIN");
				admin.setIsEnable(true);
				admin.setAccountNonLocked(true);
				admin.setFailedAttempt(0);

				userRepository.save(admin);

				System.out.println("✅ Default admin created: email=" + adminEmail + ", password=admin123");
			} else {
				System.out.println("ℹ️ Admin already exists");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
}
