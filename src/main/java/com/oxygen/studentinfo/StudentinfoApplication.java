package com.oxygen.studentinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@MapperScan("com.oxygen.studentinfo.dao")
public class StudentinfoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudentinfoApplication.class, args);
	}

	// 继承SpringBootServletInitializer 实现configure 打war包部署
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentinfoApplication.class);
	}

}
