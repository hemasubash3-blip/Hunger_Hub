package com.tap.utility;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.Model.User;

public class Launch {
	private static UserDAOimpl udao = new UserDAOimpl();
	private static Scanner scan = new Scanner(System.in);
	private static User u;
    public static void addUser() {
    	System.out.println("Enter the Username: ");
		String userName = scan.next();
		System.out.println("Enter the password: ");
		String password = scan.next();
		System.out.println("Enter the email: ");
		String Email = scan.next();
		System.out.println("Enter the address: ");
		String address = scan.next();
		System.out.println("Enter the role: ");
		String role = scan.next();
		
		User u = new User( userName , password , Email , address , role, null, null);
		
		 UserDAOimpl udao = new UserDAOimpl();
		udao.addUser(u);
    	
    }
    
    
    public static void getUser() {
    	System.out.println("Enter the userid:");
    	int id = scan.nextInt();
    	User user = udao.getUser(id);
    	System.out.println(user.getUsername() + " "+user.getPassword()+" "+user.getEmail()+" "+user.getAddress()
    	+" "+user.getRole()+" "+user.getCreateDate()+" "+user.getLogicDate());
    	
    }
    
//    public static void updateUser() {
//    	System.out.println("Enter User id: ");
//    	int id = scan.nextInt();
//    	int i = udao.updateUser(id);
//    	System.out.println(i + "updated successfully!!");
//    	
    	
//    }
    public static void updateUser() {

        System.out.println("Enter user id:");
        int id = scan.nextInt();
        scan.nextLine();

        User user = udao.getUser(id);

        // IMPORTANT CHECK
        if(user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Enter new username:");
        user.setUsername(scan.nextLine());

        System.out.println("Enter new password:");
        user.setPassword(scan.nextLine());

        udao.UpdateUser(user);

        System.out.println("Updated Successfully");
    }
    public static void DeleteUser() {
    	System.out.println("Enter the userid: ");
    	int id = scan.nextInt();
    	int user = udao.deleteUser(id);
    	System.out.println("row deleted!!");
    	return;
    }
    
    public static void getAllUsers() {

        List<User> users = udao.getAllUsers();

        for(User u : users) {

            System.out.println("User ID : " + u.getUserId());
            System.out.println("Username : " + u.getUsername());
            System.out.println("Password : " + u.getPassword());
            System.out.println("Email : " + u.getEmail());
            System.out.println("Address : " + u.getAddress());
            System.out.println("Role : " + u.getRole());

            System.out.println("----------------------");
        }
    }
    public static void main(String[] args) {
		addUser();
//		updateUser();
//		DeleteUser();
//    	getAllUsers();
//    	getAllUsers();
		
		
		
		
	
		

	}

}
