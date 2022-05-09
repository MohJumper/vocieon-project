package com.voiceon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.voiceon.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
//	@Query("select u from users u"
//		      + " left join fetch u.authorities"
//		      + " where u.username = :username")
	User findByUsername(String username);

}