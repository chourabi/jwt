package com.javainuse.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.config.JwtTokenUtil;
import com.javainuse.dao.UserDao;
import com.javainuse.entitys.Role;
import com.javainuse.entitys.RoleUser;
import com.javainuse.model.DAOUser;
import com.javainuse.repository.RoleUserAffectationsRepository;
import com.javainuse.repository.RolesRepository;

import io.jsonwebtoken.ExpiredJwtException;


@RestController @CrossOrigin(origins = "*")
@RequestMapping("/roles")
public class RolesAffectationsController {
	
	
	
	
	@Autowired
	 private RolesRepository roleRepository;
	
	@Autowired
	 private RoleUserAffectationsRepository rolesusersRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	
	@Autowired
	private UserDao userDao;
	
	
	
	 @GetMapping("/list")
	 public List<Role> getEmployeeById(HttpServletRequest request ) {
			String reqH = request.getHeader("Authorization");
			List<Role> result = new ArrayList<Role>(); 
			 
			if (reqH.startsWith("Bearer ")) {
				String token = reqH.substring(7);
				try {
					
					DAOUser x = this.userDao.findByUsername(this.jwtTokenUtil.getUsernameFromToken(token));
					
					
					 List<RoleUser> era =  this.rolesusersRepository.findAll();
					 
					 for( RoleUser re : era ) {
						 if( re.getUser().getId() == x.getId() ) {
							 result.add(re.getRole());
						 }
					 }
					
					
					
					
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
					System.out.println("JWT Token has expired");
				}
			}
		 
		 
		 
		 
		 return result;
	 }
	 
	 
	 


}
