package travelagency.models;

import java.sql.Date;

public class UserData {
	private int id;
	private String name;
	private String lastName;
	private String email;
	private Date dayOfBirthd;
	private String password;
	private int idRole;
	
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDayOfBirthd() {
		return dayOfBirthd;
	}
	public void setDayOfBirthd(Date dayOfBirthd) {
		this.dayOfBirthd = dayOfBirthd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", dayOfBirthd=" + dayOfBirthd + ", password=" + password + ", role=" + idRole + "]";
	}
}
