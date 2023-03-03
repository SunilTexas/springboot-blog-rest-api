package com.springboot.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class SpringbootBlogRestApiApplication {

	//spring.datasource.url=jdbc:mysql://localhost:3306/myblog?useSSL=false&allowPublicKeyRetrieval=true, Prakash
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}
   //spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
}