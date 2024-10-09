package com.fooddeliveryapp.model;
public class Restaurent {
	private int restaurentId;
	private String restaurentname;
	private String restaurentaddress;
	private int phone;
	private double rating;
	private String cuisineType;
	private boolean isActive;
	private int estimateTime;
	private String imagepath;
	
	public Restaurent() {
		
	}

	public Restaurent(int restaurentId, String restaurentname, String restaurentaddress, int phone, double rating,
			String cuisineType, boolean isActive, int estimateTime, String imagepath) {
		super();
		this.restaurentId = restaurentId;
		this.restaurentname = restaurentname;
		this.restaurentaddress = restaurentaddress;
		this.phone = phone;
		this.rating = rating;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.estimateTime = estimateTime;
		this.imagepath = imagepath;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getRestaurentname() {
		return restaurentname;
	}

	public void setRestaurentname(String restaurentname) {
		this.restaurentname = restaurentname;
	}

	public String getRestaurentaddress() {
		return restaurentaddress;
	}

	public void setRestaurentaddress(String restaurentaddress) {
		this.restaurentaddress = restaurentaddress;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(int estimateTime) {
		this.estimateTime = estimateTime;
	}


	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Restaurent " + restaurentId + "," + restaurentname
				+ ", " + restaurentaddress + ", " + phone + ", " + rating
				+ ", " + cuisineType + ", " + isActive + "," + estimateTime
				+ ", "  + ", " + imagepath + "";
	}

}
