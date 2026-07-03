package com.food.Servlet;

import java.io.IOException;

import com.tap.DAOimpl.MenuDAOImplem;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Get cart from session
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");

        if (action == null) {
            action = "add";
        }

        switch (action) {

        case "add":

            Integer restaurantId =
                    (Integer) session.getAttribute("restaurantId");

            int newRestaurantId =
                    Integer.parseInt(req.getParameter("restaurantId"));

            // Clear cart if restaurant changes
            if (restaurantId == null || !restaurantId.equals(newRestaurantId)) {

                cart = new Cart();
                session.setAttribute("cart", cart);
                session.setAttribute("restaurantId", newRestaurantId);
            }

            addItemToCart(req, cart);

            resp.sendRedirect("cart.jsp");
            return;

        case "update":

            updateItemInCart(req, cart);

            resp.sendRedirect("cart.jsp");
            return;
            
            
            

        case "remove":

            deleteItemFromCart(req, cart);

            session.setAttribute("cart", cart);

            Integer restaurantid =
                    (Integer) session.getAttribute("restaurantId");

            resp.sendRedirect("menu?restaurantId=" + restaurantid);
            return;
        }
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {

        try {

            int menuId =
                    Integer.parseInt(req.getParameter("menuId"));

            int quantity =
                    Integer.parseInt(req.getParameter("quantity"));

            MenuDAOImplem dao = new MenuDAOImplem();

            Menu menu = dao.getMenu(menuId);

            if (menu == null) {
                System.out.println("Menu not found");
                return;
            }

            CartItem cartItem = new CartItem(
                    menu.getMenuId(),
                    menu.getRestaurantId(),
                    menu.getItemName(),
                    menu.getPrice(),
                    quantity
            );

            cart.addItem(cartItem);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateItemInCart(HttpServletRequest req, Cart cart) {

        try {

            int menuId =
                    Integer.parseInt(req.getParameter("menuId"));

            int quantity =
                    Integer.parseInt(req.getParameter("quantity"));

            cart.updateItem(menuId, quantity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteItemFromCart(HttpServletRequest req, Cart cart) {

        try {

            int menuId =
                    Integer.parseInt(req.getParameter("menuId"));

            cart.removeItem(menuId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}