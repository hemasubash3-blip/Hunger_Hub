<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.Model.Ordertable1" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Payments</title>

    <style>
        body {
            font-family: Arial;
            background: #f4f6f9;
        }

        h2 {
            text-align: center;
            margin: 30px 0;
        }

        .container {
            width: 80%;
            margin: auto;
        }

        .card {
            background: white;
            padding: 18px;
            margin: 12px 0;
            border-radius: 12px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
        }

        .no-data {
            text-align: center;
            color: gray;
            font-size: 18px;
        }

        .pay-method {
            font-weight: bold;
            color: #ff6b6b;
        }
    </style>
</head>

<body>

<h2>My Payment History</h2>

<%
    List<Ordertable1> orders =
        (List<Ordertable1>) request.getAttribute("orders");
%>

<div class="container">

<%
    if (orders == null || orders.isEmpty()) {
%>

    <div class="no-data">No payments found</div>

<%
    } else {
        for (Ordertable1 o : orders) {
%>

    <div class="card">

        <p><b>Order ID:</b> <%= o.getOrderId() %></p>

        <p><b>Amount:</b> ₹<%= o.getTotalAmount() %></p>

        <!-- ✅ Payment method from Ordertable1 -->
        <p class="pay-method">
            Payment Method: <%= o.getPaymentMethod() %>
        </p>

        <p><b>Status:</b> <%= o.getStatus() %></p>

        <p><b>Date:</b> <%= o.getOrderDate() %></p>

    </div>

<%
        }
    }
%>

</div>

</body>
</html>