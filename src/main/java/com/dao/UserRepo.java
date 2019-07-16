package com.dao;
/**
 * @author Vijay.Rathore
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository("repository")
public interface UserRepo extends JpaRepository<User, Long> {
	User findByName(String name);
}
