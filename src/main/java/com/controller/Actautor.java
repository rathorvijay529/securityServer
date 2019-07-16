package com.controller;
/**
 * @author Vijay.Rathore
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/actuator")
public class Actautor {

	@RequestMapping(value = "/role_actuator", method = RequestMethod.GET)
	public String create2() {
		return "role_actuator";
	}
}
