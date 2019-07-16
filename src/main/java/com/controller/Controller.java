package com.controller;
/**
 * @author Vijay.Rathore
 *
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.service.UserService;

@RestController
@RequestMapping("/basicURL")
public class Controller {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user1", method = RequestMethod.GET)
	public String create() {
		userService.demo1("Vijay", "Rathor");
		return userService.demo("Vijay", "Rathor");
	}

	@RequestMapping(value = "/admin/role_admin", method = RequestMethod.GET)
	public String create1() {
		return "role_admin";
	}

	

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return "success";
	}
}
