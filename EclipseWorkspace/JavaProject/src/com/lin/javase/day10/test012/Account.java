package com.lin.javase.day10.test012;

/**
 * 
 * @author Lin
 *
 */
public class Account {

	private String actno;
	private double balance;
	public Account(String actno, double balance) {
		super();
		this.actno = actno;
		this.balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getActno() {
		return actno;
	}
	public void setActno(String actno) {
		this.actno = actno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
