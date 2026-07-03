package com.tap.utility;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.tap.DAOimpl.MenuDAOImplem;
import com.tap.Model.Menu;

public class MenuLanuchDAO {

    private static Scanner scan =
            new Scanner(System.in);

    private static MenuDAOImplem mdao =
            new MenuDAOImplem();

    public static void addMenu() {

        System.out.println("Enter Restaurant Id:");
        int restaurantId = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Item Name:");
        String itemName = scan.nextLine();

        System.out.println("Enter Description:");
        String description = scan.nextLine();

        System.out.println("Enter Price:");
        float price = scan.nextFloat();

        System.out.println("Enter Availability:");
        boolean available = scan.nextBoolean();
        scan.nextLine();

        System.out.println("Enter Category:");
        String category = scan.nextLine();

        Timestamp createdAt =
                new Timestamp(System.currentTimeMillis());

        Timestamp updateAt =
                new Timestamp(System.currentTimeMillis());

        Menu menu = new Menu(
                restaurantId,
                itemName,
                description,
                price,
                available,
                category,
                createdAt,
                updateAt
        );

        mdao.addMenu(menu);
    }

    public static void getMenu() {

        System.out.println("Enter Menu Id:");

        int id = scan.nextInt();

        Menu menu = mdao.getMenu(id);

        System.out.println(menu);
    }

    public static void deleteMenu() {

        System.out.println("Enter Menu Id:");

        int id = scan.nextInt();

        int i = mdao.deleteMenu(id);

        System.out.println(i + " row deleted");
    }

    public static void getAllMenu() {

        List<Menu> list =
                mdao.getAllMenu();

        for (Menu menu : list) {

            System.out.println(menu);
        }
    }

    public static void updateMenu() {

        System.out.println("Enter Menu Id:");

        int id = scan.nextInt();
        scan.nextLine();

        Menu menu = mdao.getMenu(id);

        if (menu == null) {

            System.out.println("Menu Not Found");
            return;
        }

        System.out.println("Enter Item Name:");
        menu.setItemName(scan.nextLine());

        System.out.println("Enter Description:");
        menu.setDescription(scan.nextLine());

        System.out.println("Enter Price:");
        menu.setPrice(scan.nextFloat());

        System.out.println("Enter Availability:");
        menu.setIsAvailable(scan.nextBoolean());
        scan.nextLine();

        System.out.println("Enter Category:");
        menu.setCategory(scan.nextLine());

        menu.setUpdateAt(
                new Timestamp(System.currentTimeMillis()));

        int i = mdao.updateMenu(menu);

        System.out.println(i + " row updated");
    }
    public static void getAllMenuByRestaurantId() {

        System.out.println("Enter Restaurant Id:");
        int restaurantId = scan.nextInt();

        List<Menu> menuList = mdao.getAllMenuByRestaurantId(restaurantId);

        if(menuList.isEmpty()) {
            System.out.println("No menu items found.");
        } else {
            for(Menu menu : menuList) {
                System.out.println(menu);
            }
        }
    
    
   
}

    public static void main(String[] args) {

//        updateMenu();
//        deleteMenu();
//    	getMenu();
    	addMenu();
    	
//    	getAllMenu();
    	getAllMenuByRestaurantId();
    	
    	
    	
    }
}



















