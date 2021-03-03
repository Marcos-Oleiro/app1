package com.oleirosoftware.app1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleirosoftware.app1.model.Roles;
import com.oleirosoftware.app1.model.User;
import com.oleirosoftware.app1.model.UserRepository;

@RestController
@RequestMapping("/open")
public class MainController {
	
	@Autowired
	public UserRepository rep;
	
	@PostMapping("/addusers")
	public List<User> addUsers(){
		
		return rep.saveAll(Arrays.asList(
				new User("Normal User", "senha", Roles.USER),
				new User("Admin User", "senha", Roles.ADMIN),
				new User("Manager User", "senha", Roles.MANAGER)
				));
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return rep.findAll();
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		
		user.setRole(Roles.USER);
		return rep.save(user);
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		User dbUser = rep.findByName(user.getName()).get(0);
		
		if(dbUser.getPasswd().equals(user.getPasswd())) {
			return "Logado";
		}
		return "Não logado";
	}
	
	
	

}
