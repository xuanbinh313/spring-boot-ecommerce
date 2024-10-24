package com.binhcodev.spring_boot_ecommerce;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEcommerceApplication {

	public static void main(String[] args) {
		System.out.println("------------------------Default JVM Timezone: " + TimeZone.getDefault().getID());
		SpringApplication.run(SpringBootEcommerceApplication.class, args);
	}

}
