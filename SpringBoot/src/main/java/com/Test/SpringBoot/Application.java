package com.Test.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Test.SpringBoot.entity.Bank;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		int dep = 2000;
		int with = 15000;
		Bank bank = new Bank();
		Thread t1 = new Thread() {
			public void run() {
				bank.withdraw(with);
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				bank.deposit(dep);
			}
		};
		t2.start();		
	}

}
