<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.tap.Model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hunger_hub - Menu</title>

<style>

/* RESET */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:#f5f5f5;
}

/* NAVBAR */
.navbar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px 40px;
    background:white;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

.logo{
    font-size:26px;
    font-weight:bold;
    color:#ff5722;
}

.nav-links{
    display:flex;
    align-items:center;
    gap:20px;
}

.nav-links a{
    text-decoration:none;
    color:#ff4081;
    font-size:18px;
    font-weight:bold;
}

.nav-links a:hover{
    color:#e91e63;
}

/* RESTAURANT HEADER */
.restaurant-header{
    background:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),
    url("https://images.unsplash.com/photo-1552566626-52f8b828add9?w=1600");
    background-size:cover;
    background-position:center;
    height:250px;
    display:flex;
    align-items:center;
    justify-content:center;
    color:white;
    text-align:center;
}

.restaurant-header h1{
    font-size:3rem;
}

/* MENU SECTION */
.menu-section{
    padding:50px;
}

.menu-title{
    text-align:center;
    color:#ff5722;
    margin-bottom:30px;
    font-size:2rem;
}

/* MENU GRID */
.menu-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(280px,320px));
    justify-content:center;
    gap:20px;
}

/* MENU CARD */
.menu-card{
    width:320px;
    background:white;
    border-radius:12px;
    overflow:hidden;
    box-shadow:0 4px 10px rgba(0,0,0,0.12);
    transition:0.3s;
    position:relative;
}

.menu-card:hover{
    transform:translateY(-8px);
}

.menu-card img{
    width:280px;
    height:180px;
    object-fit:cover;
    border-radius:10px;
    display:block;
    margin:15px auto;
}

.menu-content{
    padding:15px;
}

.menu-content h3{
    color:#333;
    margin-bottom:8px;
}

.menu-content p{
    color:#666;
    font-size:14px;
    margin-bottom:8px;
}

.price-rating{
    display:flex;
    justify-content:space-between;
    margin-top:10px;
    font-weight:bold;
}

.price{
    color:#ff5722;
}

.rating{
    color:#4caf50;
}

/* ADD TO CART BUTTON */

.add-btn{
    margin-top:15px;
    width:100%;
    padding:10px;
    border:none;
    background:#ff5722;
    color:white;
    border-radius:25px;
    cursor:pointer;
    font-size:15px;
    transition:.3s;
}

.add-btn:hover{
    background:#e64a19;
}

/* FAVOURITE HEART BUTTON */

.fav-form{
    position:absolute;
    top:12px;
    right:12px;
    z-index:10;
}

.fav-btn{
    width:42px;
    height:42px;
    border:none;
    border-radius:50%;
    background:white;
    color:#ff4081;
    font-size:22px;
    cursor:pointer;
    box-shadow:0 3px 10px rgba(0,0,0,.25);
    transition:.3s;
}

.fav-btn:hover{
    background:#ff4081;
    color:white;
    transform:scale(1.1);
}

</style>

</head>

<body>

<!-- NAVBAR -->

<div class="navbar">

    <div class="logo">
        🍔 Hunger_hub
    </div>

    
</div>

<!-- HEADER -->

<div class="restaurant-header">
    <h1>Restaurant Menu</h1>
</div>

<!-- MENU -->

<section class="menu-section">

<h2 class="menu-title">Our Delicious Menu</h2>

<div class="menu-grid">

<%

List<Menu> allMenuBYRestaurant =
(List<Menu>)request.getAttribute("allMenuBYRestaurant");

if(allMenuBYRestaurant != null){

for(Menu menu : allMenuBYRestaurant){

%>

<div class="menu-card">

    <!-- Favourite Button -->

  <form action="FavouriteServlet" method="post" class="fav-form">

    <input type="hidden" name="menuId"
           value="<%=menu.getMenuId()%>">

    <input type="hidden" name="restaurantId"
           value="<%=menu.getRestaurantId()%>">

    <input type="hidden" name="itemName"
           value="<%=menu.getItemName()%>">

    <input type="hidden" name="description"
           value="<%=menu.getDescription()%>">

    <input type="hidden" name="price"
           value="<%=menu.getPrice()%>">

    <input type="hidden" name="image"
           value="<%=menu.getImage()%>">

    <button class="fav-btn">
        ❤
    </button>

</form>
    <!-- Food Image -->

    <img
    src="<%= request.getContextPath() %>/image/<%= menu.getImage() %>"
    alt="<%= menu.getItemName() %>">

    <!-- Food Details -->

    <div class="menu-content">

        <h3>
            <%= menu.getItemName() %>
        </h3>

        <p>
            <%= menu.getDescription() %>
        </p>

        <div class="price-rating">

            <span class="price">
                ₹<%= menu.getPrice() %>
            </span>

            <span class="rating">
                ⭐4.5
            </span>

        </div>

        <!-- Add To Cart -->

        <form action="cartServlet">

            <input
                type="hidden"
                name="menuId"
                value="<%= menu.getMenuId() %>">

            <input
                type="hidden"
                name="restaurantId"
                value="<%= menu.getRestaurantId() %>">

            <input
                type="hidden"
                name="quantity"
                value="1">

            <input
                type="hidden"
                name="action"
                value="add">

            <button class="add-btn">

                Add to Cart

            </button>

        </form>

    </div>

</div>

<%
}
}
else{
%>

<h2 style="text-align:center;color:gray;">
No Menu Items Available
</h2>

<%
}
%>

</div>

</section>

</body>
</html>