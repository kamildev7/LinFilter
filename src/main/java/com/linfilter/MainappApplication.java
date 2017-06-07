package com.linfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "application.properties", "application.confidential.properties" })
public class MainappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainappApplication.class, args);
	}
}
