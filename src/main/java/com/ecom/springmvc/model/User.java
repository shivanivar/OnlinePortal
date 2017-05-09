package com.ecom.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.ecom.springmvc.validator.Phone;



@Entity
@Table(name = "User")
public class User {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "User_Name")
	@NotNull
	private String name;

	@Column(name = "Password")
	@NotNull
	private String password;

	@Column(name = "User_Address")
	private String user_address;

	@NotNull
	@Column(name = "User_Email")
	@Email
	private String user_email;

	@Phone
	@Column(name = "User_Phone")
	private String user_phone;

	@Column(name = "User_Role")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public User(int id, String name, String password, String user_address, String user_email, String user_phone,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.user_address = user_address;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.role = role;
	}
	

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", user_address=" + user_address
				+ ", user_email=" + user_email + ", user_phone=" + user_phone + ", role="
				+ role + "]";
	}

}
