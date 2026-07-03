package com.tap.utility;

import java.util.List;
import java.util.Scanner;

import com.tap.DAO.Ordertable1DAO;
import com.tap.DAOimpl.Ordertable1DAOImpl;
import com.tap.Model.Ordertable1;

public class ordertable1Launch {

    private static Ordertable1DAO odao = new Ordertable1DAOImpl();

    private static Scanner scan = new Scanner(System.in);



 public static void addOrder() {

     System.out.println("Enter User Id:");
     int userId = scan.nextInt();

     System.out.println("Enter Restaurant Id:");
     int restaurantId = scan.nextInt();

     System.out.println("Enter Total Amount:");
     float totalAmount = scan.nextFloat();
     scan.nextLine();

     System.out.println("Enter Status:");
     String status = scan.nextLine();

     System.out.println("Enter Payment Method:");
     String paymentMethod = scan.nextLine();


     Ordertable1 o = new Ordertable1(
             userId,
             restaurantId,
             totalAmount,
             status,
             paymentMethod
     );

     odao.addOrdertable1(o);
 }



    // GET ORDER
    public static void getOrder1() {

        System.out.println("Enter Order Id:");
        int id = scan.nextInt();

        Ordertable1 o = odao.getOrdertable1(id);

        if (o != null) {

            System.out.println(o.getOrderId() + " "
                    + o.getUserId() + " "
                    + o.getRestaurantId() + " "
                    + o.getOrderDate() + " "
                    + o.getTotalAmount() + " "
                    + o.getStatus() + " "
                    + o.getPaymentMethod());
        }
        else {
            System.out.println("Order Not Found");
        }
    }



    // UPDATE ORDER
    public static void updateOrder() {

        System.out.println("Enter Order Id:");
        int id = scan.nextInt();

        Ordertable1 o = odao.getOrdertable1(id);

        if (o != null) {

            System.out.println("Enter User Id:");
            o.setUserId(scan.nextInt());

            System.out.println("Enter Restaurant Id:");
            o.setRestaurantId(scan.nextInt());

            System.out.println("Enter Total Amount:");
            o.setTotalAmount(scan.nextFloat());
            scan.nextLine();

            System.out.println("Enter Status:");
            o.setStatus(scan.nextLine());

            System.out.println("Enter Payment Method:");
            o.setPaymentMethod(scan.nextLine());

            odao.updateOrdertable1(o);

            System.out.println("Updated Successfully");
        }
        else {
            System.out.println("Order Not Found");
        }
    }



    // DELETE ORDER
    public static void deleteOrder1() {

        System.out.println("Enter Order Id:");
        int id = scan.nextInt();

        odao.deleteOrdertable1(id);

        System.out.println("Deleted Successfully");
    }



    // GET ALL ORDERS
    public static void getAllOrders() {

        List<Ordertable1> list = odao.getAllOrdertables();

        for (Ordertable1 o : list) {

            System.out.println(o.getOrderId() + " "
                    + o.getUserId() + " "
                    + o.getRestaurantId() + " "
                    + o.getOrderDate() + " "
                    + o.getTotalAmount() + " "
                    + o.getStatus() + " "
                    + o.getPaymentMethod());
        }
    }



    // MAIN METHOD
    public static void main(String[] args) {


    	addOrder();

//       getOrder1();

//        updateOrder();

//       deleteOrder1();

//        getAllOrders();
    }
}