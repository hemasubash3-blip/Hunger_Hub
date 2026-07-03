package com.food.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimpl.RestaurantDAOimpl;
import com.tap.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callRestaurantServlet")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RestaurantDAOimpl dao = new RestaurantDAOimpl();

        List<Restaurant> allRestaurants = dao.getAllrestaurant();
     

        // DEBUG (important)
        System.out.println("Restaurants from DB: " + allRestaurants);

        req.setAttribute("allRestaurants", allRestaurants);

        // 🔴 CHANGE THIS to your actual JSP file name
        RequestDispatcher rd = req.getRequestDispatcher("/restaurant.jsp");
        rd.forward(req, resp);
    }
}