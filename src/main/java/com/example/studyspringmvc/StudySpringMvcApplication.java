package com.example.studyspringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //자동으로 서블릿 등록,,
@SpringBootApplication
public class StudySpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudySpringMvcApplication.class, args);
	}

}
