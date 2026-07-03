package com.tap.DAO;

import java.util.List;

import com.tap.Model.Restaurant;


public interface RestaurantDAO {
	void addrestaurant(Restaurant restaurant);
	Restaurant getrestaurant(int restaurantid);
	int Updaterestaurant(Restaurant restaurant);
    int deleterestauarant(int restaurantid);
	List<Restaurant> getAllrestaurant();
	
}
