package com.food.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimpl.Ordertable1DAOImpl;
import com.tap.Model.Ordertable1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/paymentmethods")
public class PaymentMethodsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_Id");
        System.out.println("Payment servlet hit");

        Ordertable1DAOImpl dao = new Ordertable1DAOImpl();

        // reuse orders table
        List<Ordertable1> orders = dao.getOrdersByUserId(userId);

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }
}