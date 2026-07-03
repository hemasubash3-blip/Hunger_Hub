package com.food.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FavouriteServlet")
public class FavouriteServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Menu> favouriteList =
                (List<Menu>) session.getAttribute("favouriteList");

        if (favouriteList == null) {
            favouriteList = new ArrayList<>();
        }

        Menu menu = new Menu();

        menu.setmenuId(Integer.parseInt(request.getParameter("menuId")));
        menu.setRestaurantId(Integer.parseInt(request.getParameter("restaurantId")));
        menu.setItemName(request.getParameter("itemName"));
        menu.setDescription(request.getParameter("description"));
        menu.setPrice(Double.parseDouble(request.getParameter("price")));
        menu.setImage(request.getParameter("image"));

        boolean exists = false;

        for (Menu m : favouriteList) {
            if (m.getMenuId() == menu.getMenuId()) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            favouriteList.add(menu);
        }

        session.setAttribute("favouriteList", favouriteList);

        response.sendRedirect("menu?restaurantId=" + menu.getRestaurantId());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Menu> favouriteList =
                (List<Menu>) session.getAttribute("favouriteList");

        request.setAttribute("favouriteList", favouriteList);

        request.getRequestDispatcher("Favourite.jsp").forward(request, response);
    }
}