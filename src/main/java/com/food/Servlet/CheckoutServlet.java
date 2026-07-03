package com.food.Servlet;

import java.io.IOException;

import com.tap.Model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {

            response.sendRedirect("cart.jsp");
            return;
        }

        double grandTotal = 0;

        for (var item : cart.getItems().values()) {
            grandTotal += item.getTotalPrice();
        }

        request.setAttribute("grandTotal", grandTotal);

        request.getRequestDispatcher("Checkout.jsp")
               .forward(request, response);
    }
}