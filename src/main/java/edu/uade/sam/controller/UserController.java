package edu.uade.sam.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.config.Encoder;
import edu.uade.sam.exception.InvalidPasswordException;
import edu.uade.sam.exception.InvalidRoleException;
import edu.uade.sam.model.UserAccount;
import edu.uade.sam.model.UserRole;
import edu.uade.sam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserAccount>> findAll() {
		List<UserAccount> users = userService.findAll();
		
		for (UserAccount u : users) {
			u.obscurePassword();
		}

		return ResponseEntity.ok().body(users);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity save(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "description") String description,
			@RequestParam(value = "role", required = false) String role) {

		UserAccount u = this.buildUser(username, password, description, role);
		userService.save(u);

		return ResponseEntity.ok().build();
	}

	/**
	 * Actualizar, permite cambiar todo menos el username.
	 * 
	 * @param username
	 * @param password
	 * @param description
	 * @param role
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity update(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "description") String description,
			@RequestParam(value = "role", required = false) String role) {

		UserAccount u = this.buildUser(username, password, description, role);
		userService.update(u);

		return ResponseEntity.ok().build();
	}

	/**
	 * Devuelve el usuario ocultando su password.
	 * 
	 * OJO, esto tiene un hack. Como uso un email como username hay que mandarlo
	 * entre comillas para que spring no crea que el ".com" es un tipo de
	 * archivo y no sepa interpretar la respuesta.
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/{username:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserAccount> findByUsername(@PathVariable(value = "username") String username) {
		UserAccount u = this.userService.findByUsername(username.replaceAll("\"", ""));

		if (u != null) {
			u.obscurePassword();
		}

		return ResponseEntity.ok().body(u);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteByUsername(@RequestParam(value = "username") String username) {
		this.userService.deleteByUsername(username);

		return ResponseEntity.ok().build();
	}

	private UserAccount buildUser(String username, String password, String description, String role) {
		UserRole userRole = UserRole.valueOf(role);
		if (userRole == null) {
			throw new InvalidRoleException("El rol es invalido");
		}
		
		if (username.equalsIgnoreCase(password) || password.length()<5 ){
			throw new InvalidPasswordException("El password no puede ser igual al usuario y debe tener 5 o mas caracteres");
		}
		
		final String encoded = Encoder.ENCODE(password);

		return new UserAccount(username, encoded, description, userRole);
	}

}
