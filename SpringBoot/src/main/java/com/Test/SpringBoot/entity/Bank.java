package com.Test.SpringBoot.entity;

public class Bank {
	int balance = 10000;

//	int withdraw = 15000;
	public synchronized void withdraw(int amount) {
		System.out.println("銀行餘額:" + balance);
//		System.out.println("存款金額:" + withdraw);
		System.out.println("取款");
		while (balance < amount) {
			System.out.println("銀行餘額不足" + balance + ",無法提款,請先存款");
			try {
				wait();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		balance -= amount;
		System.out.println("取款完成");
	}

	public synchronized void deposit(int amount) {
		if (balance < amount) {
			System.out.println("存款");

			balance+= amount;
			System.out.println("銀行餘額:" + balance);
		} else {
			System.out.println("存款完成");
			System.out.println("銀行餘額:" + balance);
			notify();
		}
	}
	public void notenough() {

	}

}
