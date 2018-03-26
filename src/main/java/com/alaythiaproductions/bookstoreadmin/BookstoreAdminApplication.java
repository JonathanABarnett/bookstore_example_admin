package com.alaythiaproductions.bookstoreadmin;

import com.alaythiaproductions.bookstoreadmin.models.User;
import com.alaythiaproductions.bookstoreadmin.models.security.Role;
import com.alaythiaproductions.bookstoreadmin.models.security.UserRole;
import com.alaythiaproductions.bookstoreadmin.services.UserService;
import com.alaythiaproductions.bookstoreadmin.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreAdminApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreAdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Istrator");
        user.setUsername("Admin");
        user.setPassword(SecurityUtility.passwordEncoder().encode("123"));
        user.setEmail("admin@mail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(0);
        role.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user, role));

        userService.createUser(user, userRoles);
	}
}
