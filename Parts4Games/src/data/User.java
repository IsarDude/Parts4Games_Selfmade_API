package data;

public class User {
	
	private String name;
	private String surname;
	private String mail;
	
	
	public User(String nameuser, String surnameuser, String mailuser) {
		this.name = nameuser;
		this.surname = surnameuser;
		this.mail = mailuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}