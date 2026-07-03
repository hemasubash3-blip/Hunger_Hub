package com.tap.DAO;

import java.util.List;
import com.tap.Model.Menu;

public interface MenuDAO {

    void addMenu(Menu menu);

    Menu getMenu(int menuId);

    int updateMenu(Menu menu);

    int deleteMenu(int menuId);

    List<Menu> getAllMenu();

    List<Menu> getAllMenuByRestaurantId(int restaurantId);
}