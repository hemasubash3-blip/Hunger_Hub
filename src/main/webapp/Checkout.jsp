<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tap.Model.Cart"%>
<%@ page import="com.tap.Model.CartItem"%>
<%@ page import="java.util.*"%>

<%
String username = (String)session.getAttribute("username");
String email = (String)session.getAttribute("email");
String address = (String)session.getAttribute("address");
String phone = (String)session.getAttribute("phone");
%>

<%
Cart cart = (Cart)session.getAttribute("cart");

double total = 0;
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Restaurant Checkout</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial;
}

body{
    background:#f5f5f5;
    padding:40px;
}

.checkout-container{

    width:90%;
    max-width:1200px;
    margin:auto;

    display:flex;
    gap:30px;
}

.customer-box{

    flex:2;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,.1);
}

.customer-box h2{

    color:#ff6600;
    margin-bottom:20px;
}

.input-box{

    margin-bottom:18px;
}

.input-box label{

    display:block;
    margin-bottom:6px;
    font-weight:bold;
}

.input-box input,
.input-box textarea,
.input-box select{

    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:6px;
}

textarea{

    resize:none;
}

button{

    width:100%;
    padding:14px;
    background:#ff6600;
    color:white;
    border:none;
    border-radius:6px;
    cursor:pointer;
    font-size:18px;
}

.summary-box{

    flex:1;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 5px 15px rgba(0,0,0,.1);
}

.summary-box h2{

    color:#ff6600;
    margin-bottom:20px;
}

.row{

    display:flex;
    justify-content:space-between;
    margin:12px 0;
}

.total{

    font-size:20px;
    font-weight:bold;
    color:#ff6600;
}

hr{

    margin:15px 0;
}

</style>

</head>

<body>

<div class="checkout-container">

<div class="customer-box">

<h2>Customer Details</h2>

<form action="PlaceOrderServlet" method="post">

<div class="input-box">
<label>Full Name</label>
<input
type="text"
name="name"
value="<%= username!=null ? username : "" %>"
required>
</div>

<div class="input-box">
<label>Email</label>
<input
type="email"
name="email"
value="<%= email!=null ? email : "" %>"
required>
</div>

<div class="input-box">
<label>Phone Number</label>
<input type="text" name="phone" required>
</div>

<div class="input-box">
<label>Delivery Address</label>
<textarea
name="address"
rows="4"
required><%= address!=null ? address : "" %></textarea>
</div>

<div class="input-box">
<label>Payment Method</label>

<select name="payment">

<option>Cash on Delivery</option>

<option>UPI</option>

<option>Credit Card</option>

<option>Debit Card</option>

</select>

</div>

<button type="submit">

Place Order

</button>

</form>

</div>



<div class="summary-box">

<h2>Order Summary</h2>

<%

if(cart!=null && !cart.isEmpty()){

for(CartItem item : cart.getItems().values()){

double itemTotal = item.getPrice()*item.getQuantity();

total += itemTotal;

%>

<div class="row">

<span>

<%=item.getItemName()%>

x

<%=item.getQuantity()%>

</span>

<span>

₹<%=itemTotal%>

</span>

</div>

<%

}

}else{

%>

<p>Your cart is empty.</p>

<%

}

%>

<hr>

<div class="row total">

<span>Total</span>

<span>₹<%=total%></span>

</div>

</div>

</div>

</body>
</html>