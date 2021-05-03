package jp.nw.model;

public class User {

	private String id;
	private String pass;
	
	private String oldpass;
	private String newpass;
	
	public User() {}
	public User(String id , String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	public User(String id , String oldpass, String newpass) {
		this.id = id;
		this.oldpass = oldpass;
		this.newpass = newpass;
	}

	
	public String getName() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getoldPass() {
		return oldpass;
	}
	public String getnewPass() {
		return newpass;
	}

}
