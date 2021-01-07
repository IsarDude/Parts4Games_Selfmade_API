package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //Aktiviere JSON/XML-Konvertierung 
public class User {
	
	private String name;
	private String surname;
	private String mail;
	
	
	public User(String nameuser, String surnameuser, String mailuser) {
		this.name = nameuser;
		this.surname = surnameuser;
		this.mail = mailuser;
	}
	@XmlElement(name="name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="surname")
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}

	@XmlElement(name="mail")
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
}
