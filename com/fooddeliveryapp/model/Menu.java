package com.fooddeliveryapp.model;

public class Menu {
	private int menuid;
	private String itemname;
	private String Description;
	private double price;
	private float ratings;
	private boolean isavailable;
	private int restaurentId;
	private String imagepath;
	
	public Menu() {
		
	}

	public Menu(int menuid, String itemname, String description, int price, float ratings, boolean isavailable,
			int restaurentId, String imagepath) {
		super();
		this.menuid = menuid;
		this.itemname = itemname;
		this.Description = description;
		this.price = price;
		this.ratings = ratings;
		this.isavailable = isavailable;
		this.restaurentId = restaurentId;
		this.imagepath = imagepath;

	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public boolean isIsavailable() {
		return isavailable;
	}

	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getImagepath() {
		return null;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Menu " + menuid + ", " + itemname + ", " + Description + ", " + price
				+ "," + ratings + ", " + isavailable + ", " 
				+ ", "  + restaurentId + ", " + imagepath + "";
	}
	
	
}
