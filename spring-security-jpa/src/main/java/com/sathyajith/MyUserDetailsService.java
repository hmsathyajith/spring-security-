package com.sathyajith;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sathyajith.models.MyUserDetails;
import com.sathyajith.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByUserName(username);
		System.out.println(user.get().getUserName());
		System.err.println(user.get().getPassword());
		user.orElseThrow(()-> new UsernameNotFoundException("not found " + username) );
		
		return user.map(MyUserDetails::new).get();
	}

	

}
