package com.voiceon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import com.voiceon.domain.User;
import com.voiceon.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository  userRepo;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("test@rmail.com");
		user.setPassword("pass123");
		user.setFirstName("Me");
		user.setLastName("Test");
		
		User saveUser = userRepo.save(user);
		
		User existUser = entityManager.find(User.class, saveUser.getId());
		
		assertThat(user.getId()).isEqualTo(existUser.getId());
	}

}
