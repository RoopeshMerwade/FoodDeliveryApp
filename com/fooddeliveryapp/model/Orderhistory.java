package com.fooddeliveryapp.model;

import java.sql.Date;

public class Orderhistory {
	private int orderhistoryid;
	private int userid;
	private int orderid;
	private Date orderdate;
	private double totalamount;
	private String status;
	
	public Orderhistory() {
		
	}
	public Orderhistory(int orderhistoryid, int userid, int orderid, Date orderdate, int totalamount,String status) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.userid = userid;
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
	}
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orderhistory " + orderhistoryid + ", " + userid + ", " + orderid
				+ ", " + orderdate + ", " + totalamount + ", " + status + "";
	}
}
