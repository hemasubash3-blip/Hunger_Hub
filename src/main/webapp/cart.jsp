<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tap.Model.Cart"%>
<%@ page import="com.tap.Model.CartItem"%>

<%
Cart cart = (Cart) session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart | FoodHub</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:#f5f5f5;
}

/* Navbar */

.navbar{
    background:#ffffff;
    padding:12px 40px;
    box-shadow:0 2px 8px rgba(0,0,0,.08);
}

.logo{
    font-size:26px;
    color:#fc8019;
    font-weight:bold;
}

/* Container */

.container{
    width:58%;
    margin:20px auto;
}

/* Heading */

.cart-title{
    font-size:28px;
    color:#222;
    margin-bottom:18px;
}

/* Empty Cart */

.empty-cart{
    background:white;
    padding:40px;
    border-radius:10px;
    text-align:center;
    box-shadow:0 2px 10px rgba(0,0,0,.08);
}

.empty-cart h2{
    margin-bottom:18px;
    color:#555;
}

.shop-btn{
    display:inline-block;
    text-decoration:none;
    background:#fc8019;
    color:white;
    padding:10px 20px;
    border-radius:6px;
    font-size:15px;
}

.shop-btn:hover{
    background:#e46d0c;
}

/* Cart Card */

.cart-card{
    background:white;
    border-radius:10px;
    padding:16px 20px;
    margin-bottom:15px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 2px 8px rgba(0,0,0,.08);
}

.item-details h2{
    font-size:20px;
    color:#222;
    margin-bottom:8px;
}

.item-details p{
    font-size:15px;
    margin:4px 0;
}

.price{
    color:#fc8019;
    font-weight:bold;
}

/* Quantity */

.quantity-box{
    display:flex;
    align-items:center;
    gap:8px;
    border:2px solid #fc8019;
    border-radius:25px;
    padding:5px 10px;
}

.qty-btn{
    width:30px;
    height:30px;
    border:none;
    border-radius:50%;
    background:#fc8019;
    color:white;
    font-size:18px;
    font-weight:bold;
    cursor:pointer;
}

.qty-btn:hover{
    background:#e46d0c;
}

.qty-value{
    font-size:18px;
    font-weight:bold;
}

/* Remove Button */

.remove-btn{
    margin-top:10px;
    width:160px;
    padding:8px;
    border:none;
    border-radius:6px;
    background:#666;
    color:white;
    font-size:13px;
    cursor:pointer;
}

.remove-btn:hover{
    background:#d62839;
}

/* Total Card */

.total-card{
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0 2px 8px rgba(0,0,0,.08);
}

.total-row{
    display:flex;
    justify-content:space-between;
    margin-bottom:18px;
}

.total-label{
    font-size:18px;
    font-weight:600;
}

.total-amount{
    font-size:24px;
    color:#fc8019;
    font-weight:bold;
}

/* Buttons */

.add-more-btn,
.checkout-btn{
    width:100%;
    padding:12px;
    border:none;
    border-radius:6px;
    color:white;
    font-size:17px;
    font-weight:bold;
    cursor:pointer;
}

.add-more-btn{
    background:#ff9800;
    margin-bottom:12px;
}

.add-more-btn:hover{
    background:#f57c00;
}

.checkout-btn{
    background:#fc8019;
}

.checkout-btn:hover{
    background:#e46d0c;
}

form{
    display:inline;
}

</style>

</head>

<body>

<div class="navbar">
    <div class="logo">
        FoodHub
    </div>
</div>

<div class="container">

<h1 class="cart-title">
    🛒 My Cart
</h1>

<%
if(cart == null || cart.getItems().isEmpty()){
%>

<div class="empty-cart">

<h2>Your Cart is Empty</h2>

<a href="menu?restaurantId=<%=session.getAttribute("restaurantId")%>"
   class="shop-btn">

    Continue Shopping

</a>

</div>

<%
}else{

double totalAmount = 0;

for(CartItem item : cart.getItems().values()){

double subtotal = item.getPrice() * item.getQuantity();

totalAmount += subtotal;

int qty = item.getQuantity();
%>

<div class="cart-card">

    <!-- Item Details -->

    <div class="item-details">

        <h2>
            <%= item.getItemName() %>
        </h2>

        <p>
            Price :
            <span class="price">
                ₹<%= item.getPrice() %>
            </span>
        </p>

        <p>
            Quantity :
            <strong><%= qty %></strong>
        </p>

        <p>
            Subtotal :
            <span class="price">
                ₹<%= subtotal %>
            </span>
        </p>

    </div>

    <!-- Quantity & Remove -->

    <div style="display:flex; flex-direction:column; align-items:center;">

        <div class="quantity-box">

            <!-- Decrease Quantity -->

            <form action="cartServlet" method="post">

                <input type="hidden"
                       name="menuId"
                       value="<%= item.getMenuId() %>">

                <input type="hidden"
                       name="action"
                       value="update">

                <input type="hidden"
                       name="quantity"
                       value="<%= (qty > 1) ? qty - 1 : 1 %>">

                <button type="submit" class="qty-btn">
                    −
                </button>

            </form>

            <span class="qty-value">
                <%= qty %>
            </span>

            <!-- Increase Quantity -->

            <form action="cartServlet" method="post">

                <input type="hidden"
                       name="menuId"
                       value="<%= item.getMenuId() %>">

                <input type="hidden"
                       name="action"
                       value="update">

                <input type="hidden"
                       name="quantity"
                       value="<%= qty + 1 %>">

                <button type="submit" class="qty-btn">
                    +
                </button>

            </form>

        </div>

        <form action="cartServlet" method="post" style="margin-top:10px;">

            <input type="hidden"
                   name="menuId"
                   value="<%= item.getMenuId() %>">

            <input type="hidden"
                   name="action"
                   value="remove">

            <button type="submit" class="remove-btn">
                🗑 Remove Item
            </button>

        </form>

    </div>

</div>

<%
    }   // End for loop
%>

<div class="total-card">

    <div class="total-row">

        <span class="total-label">
            Total Amount
        </span>

        <span class="total-amount">
            ₹<%= String.format("%.2f", totalAmount) %>
        </span>

    </div>

    <form action="menu" method="get">

        <input type="hidden"
               name="restaurantId"
               value="<%= session.getAttribute("restaurantId") %>">

        <button type="submit" class="add-more-btn">
            + Add More Items
        </button>

    </form>

    <form action="CheckoutServlet" method="get">

        <button type="submit" class="checkout-btn">
            Proceed to Checkout
        </button>

    </form>

</div>

<%
}   // End else block
%>

</div>

</body>
</html>