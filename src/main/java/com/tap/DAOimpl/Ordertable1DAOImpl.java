
package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.Ordertable1DAO;
import com.tap.Model.Ordertable1;
import com.tap.utility.DBConnection;

public class Ordertable1DAOImpl implements Ordertable1DAO {

    Connection con = DBConnection.getConnection();


    // ADD
    @Override
    public int addOrdertable1(Ordertable1 o) {

        int orderId = 0;

        String query =
        "INSERT INTO ordertable1(user_id, Restaurantid, TotalAmount, Status, PaymentMethod) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(
                    query,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getRestaurantId());
            ps.setFloat(3, o.getTotalAmount());
            ps.setString(4, o.getStatus());
            ps.setString(5, o.getPaymentMethod());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                orderId = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return orderId;
    }

    // GET BY ID
    @Override
    public Ordertable1 getOrdertable1(int orderId) {

        String query = "SELECT * FROM ordertable1 WHERE OrderId=?";

        Ordertable1 o = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                o = new Ordertable1();

                o.setOrderId(rs.getInt("OrderId"));
                o.setUserId(rs.getInt("user_id"));
                o.setRestaurantId(rs.getInt("Restaurantid"));
//                o.setOrderDate(rs.getTimestamp("OrderDate"));
                o.setTotalAmount(rs.getFloat("TotalAmount"));
                o.setStatus(rs.getString("Status"));
                o.setPaymentMethod(rs.getString("PaymentMethod"));
             
             o.setOrderDate(rs.getTimestamp("OrderDate"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }


    // UPDATE
    @Override
    public void updateOrdertable1(Ordertable1 ordertable1) {

        String query = "UPDATE ordertable1 SET user_id=?,Restaurantid=?,OrderDate=?,TotalAmount=?,Status=?,PaymentMethod=? WHERE OrderId=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, ordertable1.getUserId());
            ps.setInt(2, ordertable1.getRestaurantId());
            ps.setTimestamp(3, ordertable1.getOrderDate());
            ps.setFloat(4, ordertable1.getTotalAmount());
            ps.setString(5, ordertable1.getStatus());
            ps.setString(6, ordertable1.getPaymentMethod());
            ps.setInt(7, ordertable1.getOrderId());

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Order Updated Successfully");
            }
            else {
                System.out.println("Order Not Updated");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE
    @Override
    public void deleteOrdertable1(int OrderId) {

        String query = "DELETE FROM ordertable1 WHERE OrderId=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            
			ps.setInt(1, OrderId);

            int x = ps.executeUpdate();

            
                System.out.println("Order Deleted Successfully");
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // GET ALL
    @Override
    public List<Ordertable1> getAllOrdertables() {

        String query = "SELECT * FROM ordertable1";

        List<Ordertable1> list = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Ordertable1 o = new Ordertable1();

                o.setOrderId(rs.getInt("OrderId"));
                o.setUserId(rs.getInt("user_id"));
                o.setRestaurantId(rs.getInt("Restaurantid"));
//                o.setOrderDate(rs.getTimestamp("OrderDate"));
                o.setTotalAmount(rs.getFloat("TotalAmount"));
                o.setStatus(rs.getString("Status"));
                o.setPaymentMethod(rs.getString("PaymentMethod"));
             

             o.setOrderDate(rs.getTimestamp("OrderDate"));

                list.add(o);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


		@Override
		public List<Ordertable1> getOrdersByUserId(int userId) {

		    List<Ordertable1> list = new ArrayList<>();

		    String query = "SELECT * FROM ordertable1 WHERE user_id=?";

		    try {

		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setInt(1, userId);

		        ResultSet rs = ps.executeQuery();

		        while(rs.next()) {

		            Ordertable1 order = new Ordertable1();

		            order.setOrderId(rs.getInt("OrderId"));
		            order.setUserId(rs.getInt("user_id"));
		            order.setRestaurantId(rs.getInt("Restaurantid"));
		            order.setOrderDate(rs.getTimestamp("OrderDate"));
		            order.setTotalAmount(rs.getFloat("TotalAmount"));
		            order.setStatus(rs.getString("Status"));
		            order.setPaymentMethod(rs.getString("PaymentMethod"));

		            list.add(order);
		        }

		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
		
		public String getRestaurantName(int restaurantId) {

		    String restaurantName = "";

		    String sql = "SELECT rname FROM restaurant WHERE restaurantid = ?";

		    try (Connection con = DBConnection.getConnection();
		         PreparedStatement pstmt = con.prepareStatement(sql)) {

		        pstmt.setInt(1, restaurantId);

		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            restaurantName = rs.getString("rname");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return restaurantName;
		}	}


	


	

	