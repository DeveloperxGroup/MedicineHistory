package com.developerxgroup.medicinehistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.*;

//@EnableJpaRepositories("com.developerxgroup.medicinehistory.configurations")
@SpringBootApplication
public class MedicineHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineHistoryApplication.class, args);
	}

}
