// OrderitemDAOimpl.java

package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderitemDAO;
import com.tap.Model.Orderitem;
import com.tap.utility.DBConnection;

public class OrderitemDAOimpl implements OrderitemDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO orderitem(OrderId, MenuId, Quantity, ItemTotal) VALUES(?,?,?,?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM orderitem WHERE OrderItemId=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM orderitem";

    private static final String UPDATE_QUERY =
            "UPDATE orderitem SET OrderId=?, MenuId=?, Quantity=?, ItemTotal=? WHERE OrderItemId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM orderitem WHERE OrderItemId=?";



    // ADD ORDER ITEM
    @Override
    public int addOrderItem(Orderitem oi) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(INSERT_QUERY);

            pst.setInt(1, oi.getOrderId());
            pst.setInt(2, oi.getMenuId());
            pst.setInt(3, oi.getQuantity());
            pst.setDouble(4, oi.getItemTotal());

            return pst.executeUpdate();

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }



    // GET SINGLE ORDER ITEM
    @Override
    public Orderitem getOrderItem(int orderItemId) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(SELECT_QUERY);

            pst.setInt(1, orderItemId);

            ResultSet res = pst.executeQuery();

            if (res.next()) {

                Orderitem oi = new Orderitem(

                        res.getInt("OrderItemId"),
                        res.getInt("OrderId"),
                        res.getInt("MenuId"),
                        res.getInt("Quantity"),
                        res.getDouble("ItemTotal")
                );

                return oi;
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    // GET ALL ORDER ITEMS
    @Override
    public List<Orderitem> getAllOrderItems() {

        List<Orderitem> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(SELECT_ALL_QUERY);

            ResultSet res = pst.executeQuery();

            while (res.next()) {

                Orderitem oi = new Orderitem(

                        res.getInt("OrderItemId"),
                        res.getInt("OrderId"),
                        res.getInt("MenuId"),
                        res.getInt("Quantity"),
                        res.getDouble("ItemTotal")
                );

                list.add(oi);
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



    // UPDATE ORDER ITEM
    @Override
    public int updateOrderItem(Orderitem oi) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(UPDATE_QUERY);

            pst.setInt(1, oi.getOrderId());
            pst.setInt(2, oi.getMenuId());
            pst.setInt(3, oi.getQuantity());
            pst.setDouble(4, oi.getItemTotal());
            pst.setInt(5, oi.getOrderItemId());

            return pst.executeUpdate();

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }



    // DELETE ORDER ITEM
    @Override
    public int deleteOrderItem(int orderItemId) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(DELETE_QUERY);

            pst.setInt(1, orderItemId);

            return pst.executeUpdate();

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}