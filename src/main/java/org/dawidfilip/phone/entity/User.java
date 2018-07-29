package org.dawidfilip.phone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "User")
@NamedQueries({ 
	@NamedQuery(name = "User.find", query = "SELECT u FROM User u WHERE u.userName = :userName"),
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u") ,
	@NamedQuery(name = "User.delete", query = "DELETE FROM User u WHERE u.id = :id"),
	@NamedQuery(name = "User.deleteAll", query = "DELETE FROM User u") 
})
public class User {

	@Id
	@Column(unique = true)
	private String userName;
	private String password;
	private String role;
	private Date lastLogin;
	
	public User(){
	}

	public User(String userName, String password, String role) {
		this(userName, password, role, new Date(System.currentTimeMillis()));
	}
	public User(String userName, String password, String role, Date lastLogin) {
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.lastLogin = lastLogin;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + ", lastLogin=" + lastLogin
				+ "]";
	}
}
