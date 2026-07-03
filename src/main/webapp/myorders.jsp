<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.Model.Ordertable1"%>
<%@ page import="java.util.Map"%>
<%
List<Ordertable1> orders =
(List<Ordertable1>)request.getAttribute("orders");
%>
<%
Map<Integer,String> restaurantNames =
    (Map<Integer,String>)request.getAttribute("restaurantNames");
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Orders</title>

<style>

/* ================= GLOBAL ================= */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:#f4f6f9;
}

/* ================= NAVBAR ================= */
.navbar{
    background:#fff;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px 30px;
    box-shadow:0 2px 8px rgba(0,0,0,.08);
}

.logo{
    font-size:26px;
    font-weight:bold;
    color:#fc8019;
}

.home{
    text-decoration:none;
    color:#fff;
    background:#fc8019;
    padding:10px 20px;
    border-radius:25px;
    font-weight:bold;
}

.home:hover{
    background:#e56f00;
}

/* ================= HEADING ================= */
.heading{
    text-align:center;
    margin:25px 0;
    font-size:30px;
    color:#333;
}

/* ================= CONTAINER ================= */
.container{
    width:100%;
    max-width:700px;
    margin:0 auto 40px;
    display:flex;
    flex-direction:column;
    gap:15px;
}

/* ================= CARD ================= */
.card{
    width:100%;
    background:#fff;
    border-radius:12px;
    box-shadow:0 3px 10px rgba(0,0,0,.08);
    overflow:hidden;
    transition:0.2s ease;
}

.card:hover{
    transform:translateY(-2px);
}

/* ================= CARD HEADER ================= */
.card-title{
    background:#fc8019;
    color:#fff;
    text-align:center;
    padding:10px;
    font-size:15px;
    font-weight:bold;
    letter-spacing:1px;
}

/* ================= TABLE ================= */
.order-table{
    width:100%;
    border-collapse:collapse;
}

.order-table td{
    padding:10px 14px;
    font-size:13px;
}

.order-table td:first-child{
    width:45%;
    font-weight:600;
    color:#666;
}

.order-table td:last-child{
    text-align:right;
    color:#222;
    font-weight:500;
}

/* ================= STATUS ================= */
.status{
    color:#fff;
    padding:4px 10px;
    border-radius:12px;
    font-size:11px;
    font-weight:bold;
    display:inline-block;
}

/* ================= EMPTY ================= */
.empty{
    text-align:center;
    margin-top:120px;
}

.empty h2{
    color:#666;
    margin-bottom:20px;
}

.btn{
    background:#fc8019;
    color:#fff;
    text-decoration:none;
    padding:12px 25px;
    border-radius:25px;
    font-weight:bold;
}

.btn:hover{
    background:#e56f00;
}

/* ================= MOBILE ================= */
@media(max-width:768px){

.container{
    width:95%;
}

.heading{
    font-size:24px;
}

.order-table td{
    font-size:12px;
    padding:8px 10px;
}

.logo{
    font-size:22px;
}

}

</style>

</head>

<body>

<!-- NAVBAR -->
<div class="navbar">

    <div class="logo">🍔 Hunger Hub</div>

    <a href="callRestaurantServlet" class="home">Home</a>

</div>

<h2 class="heading">My Orders</h2>

<%
if (orders == null || orders.isEmpty()) {
%>

<div class="empty">
    <h2>No Orders Found</h2>
    <a href="callRestaurantServlet" class="btn">Order Now</a>
</div>

<%
} else {
%>

<div class="container">

<%
for(Ordertable1 order : orders){

    String color = "#28a745";

    if(order.getStatus()!=null){

        if(order.getStatus().equalsIgnoreCase("Pending")){
            color="#ffc107";
        }
        else if(order.getStatus().equalsIgnoreCase("Cancelled")){
            color="#dc3545";
        }
        else if(order.getStatus().equalsIgnoreCase("Delivered")){
            color="#007bff";
        }
        else if(order.getStatus().equalsIgnoreCase("Preparing")){
            color="#17a2b8";
        }
    }
%>

<div class="card">

    <div class="card-title">
        ORDER #<%=order.getOrderId()%>
    </div>

    <table class="order-table">

        <tr>
            <td>Restaurant</td>
<td><%=restaurantNames.get(order.getRestaurantId())%></td>
        <tr>
            <td>Total Amount</td>
            <td>₹ <%=order.getTotalAmount()%></td>
        </tr>

        <tr>
            <td>Payment Method</td>
            <td><%=order.getPaymentMethod()%></td>
        </tr>

        <tr>
            <td>Order Date</td>
            <td>
                <%=order.getOrderDate()==null ? "Not Available" : order.getOrderDate()%>
            </td>
        </tr>

        <tr>
            <td>Status</td>
            <td>
                <span class="status" style="background:<%=color%>">
                    <%=order.getStatus()%>
                </span>
            </td>
        </tr>

    </table>

</div>

<%
}
%>

</div>

<%
}
%>

</body>
</html>