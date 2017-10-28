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

import edu.uade.sam.config.UserAccount;
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
			@RequestParam(value = "password") String password,
			@RequestParam(value = "description") String description) {

		UserAccount u = new UserAccount(username, password, description);
		userService.save(u);

		return ResponseEntity.ok().build();
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity update(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "description") String description) {

		UserAccount u = new UserAccount(username, password, description);
		userService.update(u);

		return ResponseEntity.ok().build();
	}

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

}
