package com.example.demo.daoservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount;
	static {
		
		users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(3, "Gim", LocalDate.now().minusYears(20)));
		userCount = users.size();
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(Integer id) {
		//return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
}
