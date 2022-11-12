package com.In28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//This class is created to perform database operations which would require us to create a Dao(Data Access Object) object.
//Here we implement methods to be able to retrieve/save/.. all users.
//JPA/Hibernate will be used to talk to the database.
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

//	use of this variable makes auto increment
	private static int userId = 0;

//	Static block code executes only once during the class loading.
//	The static blocks always execute first before the main() method in Java because the compiler stores them in memory at the time of class loading and before the object creation.
	static {
		users.add(new User(++userId,"Ram", LocalDate.now().minusYears(30)));
		users.add(new User(++userId,"Laxman", LocalDate.now().minusYears(34)));
		users.add(new User(++userId,"Sita", LocalDate.now().minusYears(32)));
		users.add(new User(++userId,"Bharat", LocalDate.now().minusYears(35)));
		users.add(new User(++userId,"Satrughan", LocalDate.now().minusYears(36)));
	}

	public List<User> findAll(){
		return users;
	}

	public User findById(Integer id){
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
	}

	public User save(User user){
		user.setId(++userId);
		users.add(user);
		return user;
	}

}
