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

import edu.uade.sam.config.AuthenticationConfiguration;
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
		List<UserAccount> attributes = userService.findAll();

		return ResponseEntity.ok().body(attributes);
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
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public ResponseEntity deleteByUsername(@PathVariable(value = "username") String username) {
		this.userService.deleteByUsername(username);

		return ResponseEntity.ok().build();
	}

	private UserAccount buildUser(String username, String password, String description, String role) {
		UserRole userRole = UserRole.valueOf(role);
		final String encoded = AuthenticationConfiguration.ENCODE(password);

		System.out.println(encoded);

		return new UserAccount(username, encoded, description, userRole != null ? userRole : UserRole.USER);
	}

}
