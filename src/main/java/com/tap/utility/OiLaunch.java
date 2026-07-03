// Launch.java  (CALLER METHODS)

package com.tap.utility;

import java.util.List;
import java.util.Scanner;

import com.tap.DAO.OrderitemDAO;
import com.tap.DAOimpl.OrderitemDAOimpl;
import com.tap.Model.Orderitem;

public class OiLaunch {

    static Scanner scan = new Scanner(System.in);

    static OrderitemDAO dao = new OrderitemDAOimpl();

    public static void main(String[] args) {

        addOrderItem();

//        getOrderItem();
//
//        getAllOrderItems();
//
//        updateOrderItem();
//
//        deleteOrderItem();
    }



    // INSERT METHOD
    public static void addOrderItem() {

        System.out.println("Enter Order Id:");
        int orderId = scan.nextInt();

        System.out.println("Enter Menu Id:");
        int menuId = scan.nextInt();

        System.out.println("Enter Quantity:");
        int quantity = scan.nextInt();

        System.out.println("Enter Item Total:");
        double itemTotal = scan.nextDouble();

        Orderitem oi =
                new Orderitem(orderId, menuId, quantity, itemTotal);

        int x = dao.addOrderItem(oi);

        System.out.println(x + " row inserted");
    }



    // FETCH SINGLE DATA
    public static void getOrderItem() {

        System.out.println("Enter OrderItem Id:");
        int id = scan.nextInt();

        Orderitem oi = dao.getOrderItem(id);

        if (oi != null) {

            System.out.println(oi);
        }
        else {

            System.out.println("Data not found");
        }
    }



    // FETCH ALL DATA
    public static void getAllOrderItems() {

        List<Orderitem> list =
                dao.getAllOrderItems();

        for (Orderitem oi : list) {

            System.out.println(oi);
        }
    }



    // UPDATE METHOD
    public static void updateOrderItem() {

        System.out.println("Enter OrderItem Id to update:");
        int id = scan.nextInt();

        Orderitem oi = dao.getOrderItem(id);

        if (oi != null) {

            System.out.println("Enter New Order Id:");
            oi.setOrderId(scan.nextInt());

            System.out.println("Enter New Menu Id:");
            oi.setMenuId(scan.nextInt());

            System.out.println("Enter New Quantity:");
            oi.setQuantity(scan.nextInt());

            System.out.println("Enter New Item Total:");
            oi.setItemTotal(scan.nextDouble());

            int x = dao.updateOrderItem(oi);

            System.out.println(x + " row updated");
        }
        else {

            System.out.println("OrderItem not found");
        }
    }



    // DELETE METHOD
    public static void deleteOrderItem() {

        System.out.println("Enter OrderItem Id to delete:");
        int id = scan.nextInt();

        int x = dao.deleteOrderItem(id);

        System.out.println(x + " row deleted");
    }
}