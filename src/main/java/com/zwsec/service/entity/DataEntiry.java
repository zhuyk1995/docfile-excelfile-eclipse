package com.zwsec.service.entity;

public class DataEntiry {

	private String area;
	
	private String moneyTotal;
	
	private String money;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(String moneyTotal) {
		this.moneyTotal = moneyTotal;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public DataEntiry(String area, String moneyTotal, String money) {
		super();
		this.area = area;
		this.moneyTotal = moneyTotal;
		this.money = money;
	}

	
	
}
