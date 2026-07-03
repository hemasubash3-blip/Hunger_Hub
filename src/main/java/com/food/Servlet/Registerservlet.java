package com.food.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tap.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Registerservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
//        String role = req.getParameter("role");

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "insert into user(username,password,email,address,Createdate,LogicDate)" + "VALUES(?,?,?,?,NOW(),NOW())";

            PreparedStatement pstmt =
                    con.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, address);
//          pstmt.setString(5, role);
            

            int x = pstmt.executeUpdate();

            if(x > 0) {
                resp.sendRedirect("login.jsp");
            }
            else {
                resp.getWriter().println("Registration Failed");
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}