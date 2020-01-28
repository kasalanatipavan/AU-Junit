package com.accolite.web.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.internal.engine.valueextraction.ArrayElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.web.demo.dao.UserDao;
import com.accolite.web.demo.models.Users;
import com.accolite.web.demo.services.UserServices;

@RestController
public class SecondController {
	@Autowired
    public UserDao dao;
	
	private final Users userService = new Users();
	private static Map<Integer,Users> users = new HashMap<Integer,Users>();
	
	@RequestMapping("/getEmpInfo")
    public List<Users> customerInformation() {
        List<Users> users = dao.isData(); 
        return users;
    }
	
	@PostMapping(path="/putEmpInfo", consumes="application/json", produces="application/json")
	public String addEmployeeInformation(@RequestBody Users user) {
		int success=dao.addData(user);
		if(success==1) {
			return "added item";
		}
		else{
			return "failed to add user";
		}
	}
	
	@PostMapping("/save-cust-info")
	public String addUser(@RequestBody Users user)
	{
		users.put(user.getId(),user);
		return "added item is "+users.get(user.getId());
	}
	
	@GetMapping("user/{id}")
	public String getUserById(@PathVariable int id)
	{
		if(users.get(id)==null)return "user dosent exit";
		else return users.get(id)+" is the user request";
	}
	
	@DeleteMapping("deluser/{id}")
	public String deleteUserById(@PathVariable int id) {
		if(users.get(id)==null)return "user dosent exist";
		users.remove(id);
		return "User removed ";
	}
}