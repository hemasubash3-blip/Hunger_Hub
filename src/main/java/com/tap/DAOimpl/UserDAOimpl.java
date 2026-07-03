package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;

import com.tap.DAO.UserDAO;
import com.tap.Model.User;
import com.tap.utility.DBConnection;

public  class UserDAOimpl implements UserDAO {
	
	private static Scanner scan = new Scanner(System.in);
	
	private Statement statement;
	 
	public void addUser(User user) {
		String INSERT_QUERY = "insert into user(username,password,Email,Address,Role,createDate,LogicDate) values (?,?,?,?,?,now(),now())";
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getRole());
//			stmt.setTimestamp(6, user.getCreateDate());
//			stmt.setTimestamp(7, user.getLastloginDate());
			
			int i = stmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public User getUser(int userId) {
		Connection con = DBConnection.getConnection();
		String getUser = "select * from user where user_id ="+userId;
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(getUser);
			while(result.next()) {
				int id = result.getInt("user_id");
				String username = result.getString("username");
				String password = result.getString("password");
				String Email = result.getString("Email");
				String Address = result.getString("Address");
				String Role = result.getString("Role");
				Timestamp createDate = result.getTimestamp("createDate");
				Timestamp logicDate = result.getTimestamp("LogicDate");
				
				User user = new User(username, password, Email,Address,Role,createDate,logicDate);
				return user;
				
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		
	}

	public int updateUser(int userId) {

		Connection con = DBConnection.getConnection();

	    User user = getUser(userId);

	    
	    System.out.println(user.getUsername() + " "+ user.getPassword() + " "+user.getEmail()+" "+user.getAddress()
		+" "+ user.getRole()+" "+user.getCreateDate()+" "+user.getLogicDate());


	    System.out.println("Enter Updated Details!!");

	    System.out.println("Enter UserName: ");
	    String username = scan.next();

	    System.out.println("Enter Password: ");
	    String password = scan.next();

	    System.out.println("Enter Email: ");
	    String email = scan.next();

	    System.out.println("Enter Address: ");
	    String address = scan.next();

	    System.out.println("Enter Role: ");
	    String role = scan.next();

	    String update_query =
	            "update user set username=?, password=?, Email=?, Address=?, `Role`=?, createDate=now(), LogicDate=now() where user_id=?";

	    try {

	        PreparedStatement pst = con.prepareStatement(update_query);

	        pst.setString(1, username);
	        pst.setString(2, password);
	        pst.setString(3, email);
	        pst.setString(4, address);
	        pst.setString(5, role);
	        pst.setInt(6, userId);

	        int i = pst.executeUpdate();

	        return i;

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return -1;
	}

	@Override
	public int deleteUser(int userId) {
	
		Connection con = DBConnection.getConnection();

	    String delete_Query =
	            "Delete from `user` where user_id=?";

	    try {

	        PreparedStatement pst = con.prepareStatement(delete_Query);

	        pst.setInt(1, userId);

	        int i = pst.executeUpdate();

	        System.out.println(i + " rows deleted!!");

	        return i;

	    }
	    catch(SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

	@Override
	public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        String query = "SELECT * FROM user";

        try {

        	Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                User user = new User(query, query, query, query, query, null, null);

                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }



	@Override
	public int UpdateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}