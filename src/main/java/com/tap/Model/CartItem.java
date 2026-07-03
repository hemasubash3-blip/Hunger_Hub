package com.tap.Model;

public class CartItem  {
	
	
	private int MenuId;
	private int Restaurantid;
	private String ItemName;
	private double Price;
	private int quantity;
	

	
	public CartItem() {
		
	}
	
	
	public CartItem(int menuId, int restaurantid, String itemName, double price, int quantity) {
		super();
		this.MenuId = menuId;
		this.Restaurantid = restaurantid;
		this.ItemName = itemName;
		this.Price = price;
		this.quantity = quantity;
	}
	
	
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public int getRestaurantid() {
		return Restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		Restaurantid = restaurantid;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
        return Price * quantity;
    }
	
}