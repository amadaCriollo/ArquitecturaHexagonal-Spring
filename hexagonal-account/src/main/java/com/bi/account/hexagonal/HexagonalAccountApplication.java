package com.bi.account.hexagonal;

import com.bi.account.hexagonal.infrastructure.repositories.JpaRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HexagonalAccountApplication /*implements CommandLineRunner */{

	@Autowired
	JpaRoleRepository jpaRoleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HexagonalAccountApplication.class, args);
	}

	/*public void run(String... args) throws Exception {
 		RoleEntity adminRole = RoleEntity.builder().roleName(RoleName.ROLE_ADMIN).build();
 		RoleEntity userRole = RoleEntity.builder().roleName(RoleName.ROLE_USER).build();
		 jpaRoleRepository.save(adminRole);
		 jpaRoleRepository.save(userRole);

	}*/

//	public void run(String... args) throws Exception {
//		String password = "12345";
//		for(int i=0; i < 4; i++) {
//			String passwordEncrypt = passwordEncoder.encode(password);
//			System.out.println(passwordEncrypt);
//		}
//
//	}

}
