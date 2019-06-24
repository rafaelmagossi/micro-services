package com.magossi.webservices.resource;

import com.magossi.webservices.entity.User;
import com.magossi.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> retrieveUser(@PathVariable int id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id) {
		userService.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> retrieveAllUsers() {
		return ResponseEntity.ok(userService.findAll());
	}
}
