package com.food.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tap.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT user_Id, username, Email, Address FROM user WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

            	HttpSession session = req.getSession();

            	session.setAttribute("userId", rs.getInt("user_Id"));
            	session.setAttribute("username", rs.getString("username"));
            	session.setAttribute("email", rs.getString("Email"));
            	session.setAttribute("address", rs.getString("Address"));

            	resp.sendRedirect("callRestaurantServlet");

            } else {
                req.setAttribute("error", "Invalid email or password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}