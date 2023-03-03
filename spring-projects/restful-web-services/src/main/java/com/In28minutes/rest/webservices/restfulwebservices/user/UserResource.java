package com.In28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public EntityModel<User> getUser(@PathVariable Integer id){
		User user = userDaoService.findById(id);
		if (Objects.nonNull(user)){

//			Created an EntityModel of User
			EntityModel<User> entityModel = EntityModel.of(user);

			// methodOn(<name of Controller>).<name of the method for which we want to show the link>
			WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUser());
			entityModel.add(link.withRel("all-users"));// "link.withRel" gives a meaningful name to the object with reference to the link

	//		entity model is now returned
			return entityModel;
		}
		throw new UserNotFoundException("id:" + id);
	}

	@PostMapping("/add-user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userDaoService.save(user);

		// returns response status 201 for created case
		// return ResponseEntity.created(null).build();


//		###############################################################
//		to return a URI/Location of the newly created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()// gets the url of this method - '/users'
				.path("/{id}")//new url is appended
				.buildAndExpand(savedUser.getId())//replaces the dynamic part in the url here 'id'
				.toUri();

		return ResponseEntity.created(location).build();//response entity is build using location of newly added user
	}


	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable Integer id){
		userDaoService.deleteById(id);
	}
}
