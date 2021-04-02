package com.javainuse.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.javainuse.model.DAOUser;




	
	@Entity
	@Table( name = "role_users" )
	public class RoleUser {

		 @Id
		 @GeneratedValue(strategy = GenerationType.AUTO)
		 private long id;

		 
		 @ManyToOne
		 @JoinColumn(name = "user_id")
		 private DAOUser user;
		 
		 
		 @ManyToOne
		 @JoinColumn(name = "roles_id")
		 private Role role;

		 


		public long getId() {
			return id;
		}




		public void setId(long id) {
			this.id = id;
		}




		public DAOUser getUser() {
			return user;
		}




		public void setUser(DAOUser user) {
			this.user = user;
		}




		public Role getRole() {
			return role;
		}




		public void setRole(Role role) {
			this.role = role;
		}
		
		




		public RoleUser(long id, DAOUser user, Role role) {
			super();
			this.id = id;
			this.user = user;
			this.role = role;
		}




		public RoleUser() {
			super();
		}
		 
		 
}
