package br.com.casalsplit.casalsplit_api;

import org.springframework.boot.SpringApplication;

public class TestCasalsplitApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(CasalsplitApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
