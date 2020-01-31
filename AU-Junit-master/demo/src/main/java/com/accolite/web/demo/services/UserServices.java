package com.accolite.web.demo.services;

import java.awt.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.web.demo.models.Users;

@Service 
public class UserServices{
	ArrayList<Users> listOfUsers;
	public Users getUserByName(@RequestParam int id)
	{
		return listOfUsers.stream().filter(user->user.getId()==id).findFirst().get();
	}
	
	@PostConstruct
	public void setUp() {
		ArrayList users = new ArrayList();
		Users u1=new Users();
		u1.setId(43);
		u1.setSalary(20000);
		users.add(u1);
	}
}