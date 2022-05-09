package com.voiceon.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.voiceon.domain.User;
import com.voiceon.repository.UserRepository;
import com.voiceon.security.CustomSecurityUser;


@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	// loadUserByUsername << method inside UserDetailsService
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		System.out.println("from suerServiceImp >> " + user);
		
		if(user == null) {
			throw new UsernameNotFoundException("Username or password is incorrect! ");
		}
		// this will inject user 
		return new CustomSecurityUser(user);
	}

}
