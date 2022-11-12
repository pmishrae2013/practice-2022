package com.In28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//here we define all restful services(the controllers)
@RestController
@RequestMapping("/")
public class UserResource {
	private UserDaoService userDaoService;

	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@GetMapping("users")
	public List<User> getAllUser(){
		return userDaoService.findAll();
	}

	@GetMapping("users/{id}")
	public User getUser(@PathVariable Integer id){
		return userDaoService.findById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userDaoService.save(user);

//		###############################################################
		// returns response status 201 for created case
		// return ResponseEntity.created(null).build();
//		###############################################################


//		###############################################################
//		to return a URI/Location of the newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()// gets the url of this method - '/users'
				.path("/{id}")//new url is appended
				.buildAndExpand(savedUser.getId())//replaces the dynamic part in the url here 'id'
				.toUri();
//		###############################################################

		return ResponseEntity.created(location).build();//response entity is build using location of newly added user
	}

}
