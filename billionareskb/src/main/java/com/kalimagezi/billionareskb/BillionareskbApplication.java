package com.kalimagezi.billionareskb;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kalimagezi.billionareskb.user.UserController;

@SpringBootApplication
@EnableJpaRepositories( "com.kalimagezi.billionareskb")

public class BillionareskbApplication {

	public static void main(String[] args) {
		// create upload folder if dose not exist
		new File (UserController.uploadDirectory).mkdir();
		SpringApplication.run(BillionareskbApplication.class, args);
	}

}
