package com.project.dto;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class UserDTo {
	
	@Id
	private int uid;
	private String uname;
	private int uage;
	private String uemail;
	private String upassword;
	private String uaddress;
	private String uphonenumber;
	private Date registrationdate;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUphonenumber() {
		return uphonenumber;
	}
	public void setUphonenumber(String uphonenumber) {
		this.uphonenumber = uphonenumber;
	}
	public Date getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	@Override
	public String toString() {
		return "UserDTo [uid=" + uid + ", uname=" + uname + ", uage=" + uage + ", uemail=" + uemail + ", upassword="
				+ upassword + ", uaddress=" + uaddress + ", uphonenumber=" + uphonenumber + ", registrationdate="
				+ registrationdate + "]";
	}
	
	
	
	
	
	
}
