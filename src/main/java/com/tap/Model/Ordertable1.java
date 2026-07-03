

package com.tap.Model;

import java.sql.Timestamp;

public class Ordertable1 {

    private int orderId;
    private int userId;
    private int restaurantId;
    private Timestamp orderDate;
    private float totalAmount;
    private String status;
    private String paymentMethod;



    // DEFAULT CONSTRUCTOR
    public Ordertable1() {

    }



    // CONSTRUCTOR WITHOUT ORDER ID
    public Ordertable1(int userId,
                      int restaurantId,
                      float totalAmount,
                      String status,
                      String paymentMethod) {

        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }



    // CONSTRUCTOR WITH ORDER ID
    public Ordertable1(int orderId,
                      int userId,
                      int restaurantId,
                      float totalAmount,
                      String status,
                      String paymentMethod) {

        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }



    // GETTERS AND SETTERS

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
