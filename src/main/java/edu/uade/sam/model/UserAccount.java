package edu.uade.sam.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * @author msarno
 *
 */
@Entity
public class UserAccount {

	@Id
	private String username;// mail
	private String password;
	private String description;// nombre completo
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public UserAccount() {
		super();
	}

	public UserAccount(String username, String password, String description, UserRole role) {
		super();
		this.username = username;
		this.password = password;
		this.description = description;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void obscurePassword() {
		this.setPassword("");
	}

}
