package com.example.statisticservice;

import org.springframework.boot.SpringApplication;

public class TestStatisticserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(StatisticserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
