package com.food.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.tap.DAO.Ordertable1DAO;
import com.tap.DAOimpl.Ordertable1DAOImpl;
import com.tap.Model.Ordertable1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myOrders")
public class MyorderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Ordertable1DAO dao = new Ordertable1DAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Integer userId = (Integer) session.getAttribute("userId");

        // 1. Get orders
        List<Ordertable1> orders = dao.getOrdersByUserId(userId);

        // 2. Create DAO for restaurant name
        Ordertable1DAOImpl impl = new Ordertable1DAOImpl();

        Map<Integer, String> restaurantNames = new java.util.HashMap<>();

        // 3. Fill restaurant names
        for (Ordertable1 order : orders) {

            int restaurantId = order.getRestaurantId();

            if (!restaurantNames.containsKey(restaurantId)) {
                restaurantNames.put(
                    restaurantId,
                    impl.getRestaurantName(restaurantId)
                );
            }
        }

        // 4. Set attributes
        req.setAttribute("orders", orders);
        req.setAttribute("restaurantNames", restaurantNames);

        System.out.println("User ID = " + userId);
        System.out.println("Orders Size = " + orders.size());

        // 5. Forward
        req.getRequestDispatcher("/myorders.jsp").forward(req, resp);
    }
}