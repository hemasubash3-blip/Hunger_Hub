package com.tap.Model;

import java.sql.Timestamp;

public class Menu {

    private int menuId;
    private int restaurantId;
    private String itemName;
    private String description;
    private double price;
    private boolean isAvailable;
    private String category;

    private Timestamp createdAt;
    private Timestamp updateAt;
    private Timestamp deletedAt;

    public Menu() {

    }

    public Menu(int restaurantId,
                String itemName,
                String description,
                float price,
                boolean isAvailable,
                String category,
                Timestamp createdAt,
                Timestamp updateAt) {

        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setmenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
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

        return "Menu [menuId=" + menuId +
                ", restaurantId=" + restaurantId +
                ", itemName=" + itemName +
                ", description=" + description +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", category=" + category +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", deletedAt=" + deletedAt + "]";
    }
}
