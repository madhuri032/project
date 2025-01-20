package com.project.entity;

import java.sql.Date;
import java.util.List;

import com.project.dto.UserDTo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Admin {
	@Id
    @Column(name = "id")

	private int id;
    @Column(name = "name")

	private String name;
    @Column(name = "email")

	private String email;
    @Column(name = "password")

	
	private String password;
    @Column(name = "address")

	private String address;
	
    @Column(name = "phonenumber")

	private long phonenumber;
    @Column(name = "usertype")

	private String usertype;
    @Column(name = "registrationdate")

	private Date registrationdate;
    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Assuming one admin can have multiple userdata
	private List<UserDTo> userdata;


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public Date getRegistrationdate() {
		return registrationdate;
	}


	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}


	public List<UserDTo> getUserdata() {
		return userdata;
	}


	public void setUserdata(List<UserDTo> userdata) {
		this.userdata = userdata;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", phonenumber=" + phonenumber + ", usertype=" + usertype + ", registrationdate="
				+ registrationdate + ", userdata=" + userdata + "]";
	}

	
    
	
	
	
}
