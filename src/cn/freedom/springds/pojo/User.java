package cn.freedom.springds.pojo;

public class User {
	
	int id;
	String userName;
	String password;
	String sex;
	String phoneNumber;
	String email;
	String note;
	
	public User(int id, String userName, String password, String sex, String phoneNumber, String email, String note) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
