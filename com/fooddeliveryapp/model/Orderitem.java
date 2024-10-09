package com.fooddeliveryapp.model;

public class Orderitem {
	private int orderitemid;
	private int orderid;
	private int menuid;
	private int quantity;
	private double totalprice;
	
	public Orderitem() {
		
	}

	public Orderitem(int orderitemid, int orderid, int menuid, int quantity, int totalprice) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double d) {
		this.totalprice = d;
	}

	@Override
	public String toString() {
		return "Orderitem " + orderitemid + ", " + orderid + ", " + menuid + ", "
				+ quantity + ", " + totalprice + "";
	}
	
}
