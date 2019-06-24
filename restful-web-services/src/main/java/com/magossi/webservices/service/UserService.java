package com.magossi.webservices.service;

import com.magossi.webservices.entity.User;
import com.magossi.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}
}
