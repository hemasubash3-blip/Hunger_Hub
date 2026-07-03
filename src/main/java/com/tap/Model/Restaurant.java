package com.tap.Model;

public class Restaurant {
	private int restaurantId;
	private String rname;
	private String cuisinetype;
	private int deliverytime;
	private String address;
	private int adminuserid;
	private float rating;
	private  boolean isactive;
	
	
	
	
	public Restaurant() {
		
		
	}
	public Restaurant( String rname, String cuisinetype, int deliverytime, String address,
			int adminuserid, float rating, boolean isactive) {
		
		
		this.rname = rname;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.address = address;
		this.adminuserid = adminuserid;
		this.rating = rating;
		this.isactive = isactive;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantid(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public int getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdminuserid() {
		return adminuserid;
	}
	public void setAdminuserid(int adminuserid) {
		this.adminuserid = adminuserid;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	private String image;

	public String getImage() {
	    return image;
	}

	public void setImage(String image) {
	    this.image = image;
	}
	
	
	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId 
				+ ", rname=" + rname 
				+ ", cuisinetype=" + cuisinetype
				+ ", deliverytime=" + deliverytime 
				+ ", address=" + address 
				+ ", adminuserid=" + adminuserid 
				+ ", rating="+ rating 
				+ ", isactive=" + isactive + "]";
	}
	

}
