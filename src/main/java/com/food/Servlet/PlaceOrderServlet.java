package com.food.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        Integer user_Id = (Integer) session.getAttribute("userId");
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");

        String Address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String payment = request.getParameter("payment");

        double totalAmount = cart.getTotalPrice();

        try {

            Connection con = DBConnection.getConnection();

            //-------------------------------------------------------
            // Insert into Orders Table
            //-------------------------------------------------------

            String orderSql =
            		"INSERT INTO ordertable1(user_id, Restaurantid, TotalAmount, Status, PaymentMethod) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(orderSql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, user_Id);
            ps.setInt(2, restaurantId);
            ps.setDouble(3, totalAmount);
            ps.setString(4, "Placed");
            ps.setString(5, payment);
            ps.executeUpdate();

            //-------------------------------------------------------
            // Get Generated Order ID
            //-------------------------------------------------------

            ResultSet rs = ps.getGeneratedKeys();

            int orderId = 0;

            if(rs.next()) {
                orderId = rs.getInt(1);
            }

            //-------------------------------------------------------
            // Insert Order Items
            //-------------------------------------------------------

            String itemSql =
            		"INSERT INTO orderitem(OrderId, MenuId, Quantity, ItemTotal) VALUES(?,?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(itemSql);

            for(CartItem item : cart.getItems().values()) {

                ps2.setInt(1, orderId);
                ps2.setInt(2, item.getMenuId());
                ps2.setInt(3, item.getQuantity());
                ps2.setDouble(4,
                        item.getPrice() * item.getQuantity());
                ps2.addBatch();
            }

            ps2.executeBatch();

            //-------------------------------------------------------

            session.removeAttribute("cart");

            response.sendRedirect("orderSuccess.jsp");

        }
        catch(Exception e){
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }

    }

}