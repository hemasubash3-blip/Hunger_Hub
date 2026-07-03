package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tap.DAO.RestaurantDAO;
import com.tap.Model.Restaurant;
import com.tap.Model.User;
import com.tap.utility.DBConnection;

public class RestaurantDAOimpl implements RestaurantDAO{
	private static Scanner scan = new Scanner(System.in);
	private static final String INSERT_QUERY = 
			"insert into restaurant(restaurantid,rname,cuisinetype, deliverytime, address, adminuserid, rating, isactive) values(?,?,?,?,?,?,?,?)"; 
   private static final String UPDATE_QUERY =
			"update restaurant set rname=?, cuisinetype=?, deliverytime=?, address=?, adminuserid=?, rating=?, isactive=? where restaurantid=?";
	private static final String DELETE_QUERY ="Delete from `restaurant` where restaurantid =?";
    private static final String GET_QUERY ="select * from restaurant where restaurantid = ?";
	private static final String  GETALL_QUERY = "SELECT * FROM restaurant";
	
	
	@Override
	public void addrestaurant(Restaurant restaurant) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, restaurant.getRestaurantId());
			stmt.setString(2, restaurant.getRname());
			stmt.setString(3, restaurant.getCuisinetype());
			stmt.setInt(4, restaurant.getDeliverytime());
			stmt.setString(5, restaurant.getAddress());
			stmt.setInt(6,  restaurant.getAdminuserid());
			stmt.setFloat(7,  restaurant.getRating());
			stmt.setBoolean(8,  restaurant.getIsactive());
			
			int i = stmt.executeUpdate();
		
		
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getrestaurant(int restaurantid) {
		
		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(GET_QUERY);
			stmt.setInt(1,restaurantid);
			ResultSet result = stmt.executeQuery();
		

			while(result.next()) {
				Restaurant restaurant = new Restaurant();

				int id = result.getInt("restaurantid");
				String rname = result.getString("rname");
				String cuisinetype = result.getString("cuisinetype");
				int  deliverytime = result.getInt("deliverytime");
				String address = result.getString("address");
				int adminuserid = result.getInt("adminuserid");
				float rating = result.getFloat("rating");
				boolean isactive = result.getBoolean("isactive");
				
				
				
				return restaurant;
				
			}
		}
		
			catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
		
@Override
	public int Updaterestaurant(Restaurant restaurant) {

	    try (
	    		Connection con = DBConnection.getConnection();
	        
	        PreparedStatement pst = con.prepareStatement(UPDATE_QUERY)
	    ) {

	        pst.setString(1, restaurant.getRname());
	        pst.setString(2, restaurant.getCuisinetype());
	        pst.setInt(3, restaurant.getDeliverytime());
	        pst.setString(4, restaurant.getAddress());
	        pst.setInt(5, restaurant.getAdminuserid());
	        pst.setFloat(6, restaurant.getRating());
	        pst.setBoolean(7, restaurant.getIsactive());
	        pst.setInt(8, restaurant.getRestaurantId());

	        System.out.println("ID = " + restaurant.getRestaurantId());

	        return pst.executeUpdate();
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}	
@Override
public int deleterestauarant(int restaurantid) {
		
		Connection con = DBConnection.getConnection();

	    
	    try {

	        PreparedStatement pst = con.prepareStatement(DELETE_QUERY );

	        pst.setInt(1, restaurantid);
	        return pst.executeUpdate();
	    }

	        
	    catch(SQLException e) {
	        e.printStackTrace();
	    }

		return 0;
	}

	@Override
	public List<Restaurant> getAllrestaurant() {
		

        List<Restaurant> List = new ArrayList<>();
         try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(GETALL_QUERY);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            	Restaurant restaurant  = new Restaurant();

                restaurant.setRestaurantid(rs.getInt("restaurantid"));
            	restaurant.setRname(rs.getString("rname"));
            	restaurant.setCuisinetype(rs.getString("cuisinetype"));
            	restaurant.setDeliverytime(rs.getInt("deliverytime"));
            	restaurant.setAddress(rs.getString("address"));
            	restaurant.setAdminuserid(rs.getInt("adminuserid"));
            	restaurant.setRating(rs.getFloat("rating"));
            	restaurant.setIsactive(rs.getBoolean("isactive"));
            	restaurant.setImage(rs.getString("image"));

                List.add(restaurant);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return List;
    }
}

	