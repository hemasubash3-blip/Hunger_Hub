
package com.tap.utility;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOimpl.RestaurantDAOimpl;
import com.tap.DAOimpl.UserDAOimpl;
import com.tap.Model.Restaurant;
import com.tap.Model.User;

public class RestaurantLaunch {
	private static RestaurantDAOimpl rdao = new RestaurantDAOimpl();
	private static Scanner scan = new Scanner(System.in);
	
    public static void addRestaurant() {
    	System.out.println("Enter the Rname: ");
		String rname = scan.nextLine();
		scan.next();
		
	    System.out.println("Enter the Cuisinetype: ");
		String cuisinetype = scan.next();
		scan.nextLine();
		
		System.out.println("Enter the Deliverytime: ");
		int deliverytime = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter the Address: ");
		String address = scan.next();
		
		System.out.println("Enter the Adminuserid: ");
		int adminuserid = scan.nextInt();
		
		System.out.println("Enter the Rating: ");
		float rating = scan.nextFloat();
		
		System.out.println("Enter the Isactive: ");
		boolean isactive = scan.nextBoolean();
			
		Restaurant restaurant = new Restaurant(rname, cuisinetype, deliverytime, address, adminuserid, rating, isactive);
		
		rdao.addrestaurant(restaurant);
		
		System.out.println("Inserted successfully");
    }
				
    
    
    public static void updateRestaurant() {

        System.out.println("Enter Restaurant id: ");
        int id = scan.nextInt();
        scan.nextLine();

        Restaurant r = rdao.getrestaurant(id);

        if(r == null) {
            System.out.println("Restaurant not found");
            return;
        }

        r.setRestaurantid(id);

        System.out.println("Enter new name: ");
        r.setRname(scan.nextLine());

        System.out.println("Enter cuisine: ");
        r.setCuisinetype(scan.nextLine());

        System.out.println("Enter delivery time: ");
        r.setDeliverytime(scan.nextInt());
        scan.nextLine();

        System.out.println("Enter address: ");
        r.setAddress(scan.nextLine());

        System.out.println("Enter admin id: ");
        r.setAdminuserid(scan.nextInt());

        System.out.println("Enter rating: ");
        r.setRating(scan.nextFloat());

        System.out.println("Enter new isActive: ");
        r.setIsactive(scan.nextBoolean());

        int i = rdao.Updaterestaurant(r);

        System.out.println(i + " updated");
    }    public static void DeleteRestaurant() {
    	System.out.println("Enter the id: ");
    	int id = scan.nextInt();
    	int i = rdao.deleterestauarant(id);
    	System.out.println(i + "deleted");
    
    }
    
    public static void getAllRestaurant() {

        List<Restaurant> List = rdao.getAllrestaurant();

        for(Restaurant r : List) {
        	System.out.print(r);
        }
    }
    public static void getRestaurant() {

        System.out.println("Enter Id:");
        int id = scan.nextInt();

        Restaurant r = rdao.getrestaurant(id);
        System.out.println(r);
    }

        	


    public static void main(String[] args) {
//		addRestaurant();
    	updateRestaurant();
    	//		DeleteRestaurant();
//    	getAllRestaurant();
//    	getRestaurant();
		
		
		
		
	
		

	}

}
