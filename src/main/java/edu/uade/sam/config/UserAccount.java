package edu.uade.sam.config;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author msarno
 *
 */
@Entity
public class UserAccount {

	@Id
	private String username;
	private String password;
	private String description;

	public UserAccount() {
		super();
	}

	public UserAccount(String username, String password, String description) {
		super();
		this.username = username;
		this.password = password;
		this.description = description;
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

	public void obscurePassword() {
		this.setPassword("");
	}

}
