package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.Model.Menu;
import com.tap.utility.DBConnection;

public class MenuDAOImplem implements MenuDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO menu(restaurantId, itemName, description, price, isAvailable, category) VALUES(?,?,?,?,?,?)";

    private static final String GET_QUERY =
            "SELECT * FROM menu WHERE menuId=?";

    private static final String UPDATE_QUERY =
            "UPDATE menu SET restaurantId=?, itemName=?, description=?, price=?, isAvailable=?, category=?, updateAt=? WHERE menuId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM menu WHERE menuId=?";

    private static final String GETALL_QUERY =
            "SELECT * FROM menu";
    
    private final static String  getAllMenuByRestaurantId = "Select* From menu Where restaurantId=?";

    @Override
    public void addMenu(Menu menu) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(INSERT_QUERY);

            pst.setInt(1, menu.getRestaurantId());
            pst.setString(2, menu.getItemName());
            pst.setString(3, menu.getDescription());
            pst.setDouble(4, menu.getPrice());
            pst.setBoolean(5, menu.isIsAvailable());
            pst.setString(6, menu.getCategory());

            int i = pst.executeUpdate();

            System.out.println(i + " row inserted");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Menu getMenu(int menuId) {

        Connection con = DBConnection.getConnection();

        Menu menu = null;

        try {

            PreparedStatement pst =
                    con.prepareStatement(GET_QUERY);

            pst.setInt(1, menuId);

            ResultSet res = pst.executeQuery();

            if (res.next()) {

                menu = new Menu();

                menu.setmenuId(res.getInt("menuId"));
                menu.setRestaurantId(res.getInt("restaurantId"));
                menu.setItemName(res.getString("itemName"));
                menu.setDescription(res.getString("description"));
                menu.setPrice(res.getFloat("price"));
                menu.setIsAvailable(res.getBoolean("isAvailable"));
                menu.setCategory(res.getString("category"));

                menu.setCreatedAt(
                        res.getTimestamp("createdAt"));

                menu.setUpdateAt(
                        res.getTimestamp("updateAt"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return menu;
    }

    public int updateMenu(Menu menu) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(UPDATE_QUERY);

            pst.setInt(1, menu.getRestaurantId());
            pst.setString(2, menu.getItemName());
            pst.setString(3, menu.getDescription());
            pst.setDouble(4, menu.getPrice());
            pst.setBoolean(5, menu.isIsAvailable());
            pst.setString(6, menu.getCategory());
            pst.setString(6, menu.getCategory());

            pst.setTimestamp(7,
                    menu.getUpdateAt());

            pst.setInt(8,
                    menu.getMenuId());

            int i = pst.executeUpdate();

            return i;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    public int deleteMenu(int menuId) {

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(DELETE_QUERY);

            pst.setInt(1, menuId);

            int i = pst.executeUpdate();

            return i;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Menu> getAllMenu() {

        List<Menu> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement pst =
                    con.prepareStatement(GETALL_QUERY);

            ResultSet res = pst.executeQuery();

            while (res.next()) {

                Menu menu = new Menu();

                menu.setmenuId(res.getInt("menuId"));
                menu.setRestaurantId(res.getInt("restaurantId"));
                menu.setItemName(res.getString("itemName"));
                menu.setDescription(res.getString("description"));
                menu.setPrice(res.getFloat("price"));
                menu.setIsAvailable(res.getBoolean("isAvailable"));
                menu.setCategory(res.getString("category"));
                menu.setImage(res.getString("image"));
                
                list.add(menu);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Menu> getAllMenuByRestaurantId(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(getAllMenuByRestaurantId)) {

            pstmt.setInt(1, restaurantId);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                Menu menu = new Menu();

                menu.setmenuId(res.getInt("menuId"));
                menu.setRestaurantId(res.getInt("restaurantId"));
                menu.setItemName(res.getString("itemName"));
                menu.setDescription(res.getString("description"));
                menu.setPrice(res.getDouble("price"));
                menu.setIsAvailable(res.getBoolean("isAvailable"));
                menu.setCategory(res.getString("category"));
                menu.setImage(res.getString("image"));

                menuList.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }
	}





	