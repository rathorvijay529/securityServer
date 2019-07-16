package com.SpringSecurityAouth2;
/**
 * @author Vijay.Rathore
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com")
@EntityScan(basePackages="com")
public class SpringSecurityAouth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAouth2Application.class, args);
	}

}
