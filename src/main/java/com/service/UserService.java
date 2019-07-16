package com.service;
/**
 * @author Vijay.Rathore
 *
 */
import java.util.List;

import com.model.User;

public interface UserService {
	public User save(User user);

	public List<User> findAll();
	
	public String demo(String one,String two);

	public void delete(long id);

	void demo1(String a, String b);

}
