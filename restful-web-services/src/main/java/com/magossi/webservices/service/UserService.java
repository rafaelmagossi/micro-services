package com.magossi.webservices.service;

import com.magossi.webservices.entity.User;
import com.magossi.webservices.exception.UserNotFoundException;
import com.magossi.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		if(CollectionUtils.isEmpty(users)){
			throw new UserNotFoundException(String.format("Cant find any user"));
		}
		return users;
	}

	public User findById(int id) {
		Optional<User> user = userRepository.findById(id);
		user.orElseThrow(() -> new UserNotFoundException(String.format("User id %d not found",id)));
		return user.get();
	}

	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}
}
