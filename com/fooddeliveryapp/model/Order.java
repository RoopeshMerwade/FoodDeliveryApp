package com.fooddeliveryapp.model;

import java.sql.Date;

public class Order {
	private int OrderId ;
	private int userid;
	private int restaurentid;
	private Date orderdate;
	private double amount;
	private String status;
	private String paymentmode;
	
	public Order() {
		
	}

	public Order(int orderId, int userid, int restaurentid, Date orderdate, int amount,String status,String paymentmode) {
		super();
		OrderId = orderId;
		this.userid = userid;
		this.restaurentid = restaurentid;
		this.orderdate = orderdate;
		this.amount = amount;
		this.status = status;
		this.paymentmode = paymentmode;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getRestaurentid() {
		return restaurentid;
	}

	public void setRestaurentid(int restaurentid) {
		this.restaurentid = restaurentid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	@Override
	public String toString() {
		return "Order " + OrderId + "," + userid + ", " + restaurentid + ", "
				+ orderdate + ", " + amount + ", " + status + ", " + paymentmode + "";
	}
	
}