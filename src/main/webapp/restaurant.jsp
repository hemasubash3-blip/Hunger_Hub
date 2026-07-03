<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.tap.Model.Restaurant" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Hunger_hub</title>

<style>
 /* SEARCH BAR SECTION */
.search-section{
    display:flex;
    justify-content:center;
    margin:30px 0;
}

.search-section input{
    width:60%;
    padding:12px 20px;
    border:2px solid #ff5722;
    border-radius:30px;
    outline:none;
    font-size:16px;
    transition:0.3s;
}

.search-section input:focus{
    box-shadow:0 0 10px rgba(255,87,34,0.4);
}

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    background:#f5f5f5;
}



/* ================= NAVBAR ================= */

.navbar{
    position:sticky;
    top:0;
    z-index:1000;

    display:flex;
    justify-content:space-between;
    align-items:center;

    padding:18px 80px;
    background:rgba(255,255,255,0.95);
    backdrop-filter:blur(10px);

    box-shadow:0 2px 20px rgba(0,0,0,0.08);
}

.logo{
    font-size:34px;
    font-weight:800;
    color:#fc8019;
    cursor:pointer;
    transition:0.3s;
}

.logo:hover{
    transform:scale(1.05);
}

.nav-links{
    display:flex;
    align-items:center;
    gap:35px;
}

.nav-links a{
    text-decoration:none;
    color:#333;
    font-size:17px;
    font-weight:600;
    position:relative;
    transition:0.3s;
}

.nav-links a:hover{
    color:#fc8019;
}

.nav-links a::after{
    content:"";
    position:absolute;
    left:0;
    bottom:-6px;
    width:0;
    height:2px;
    background:#fc8019;
    transition:0.3s;
}

.nav-links a:hover::after{
    width:100%;
}

.nav-links a:last-child{
    background:#fc8019;
    color:white;
    padding:10px 22px;
    border-radius:25px;
}

.nav-links a:last-child:hover{
    background:#e56f00;
    color:white;
}

/* HERO */

.hero{
    height:90vh;
    background:
    linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),
    url("https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=1600");
    background-size:cover;
    background-position:center;
    display:flex;
    justify-content:center;
    align-items:center;
    text-align:center;
}

.hero-content{
    color:white;
}

.hero-content h2{
    font-size:3rem;
    margin-bottom:20px;
}

.hero-content p{
    font-size:1.2rem;
    margin-bottom:20px;
}

.hero-content button{
    padding:12px 30px;
    border:none;
    border-radius:30px;
    background:#ff5722;
    color:white;
    cursor:pointer;
}

/* RESTAURANTS */

.restaurants{
    padding:50px;
}

.restaurants h2{
    text-align:center;
    color:#ff5722;
    margin-bottom:30px;
}

.restaurant-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
    gap:25px;
}

.restaurant-card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 4px 15px rgba(0,0,0,0.1);
    transition:0.3s;
}

.restaurant-card:hover{
    transform:translateY(-8px);
}

.restaurant-card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.restaurant-card h3{
    padding:15px;
}

.restaurant-card p{
    padding:0 15px 15px;
    color:#666;
}

</style>
</head>

<body>


<!-- ================= NAVBAR ================= -->

<nav class="navbar">

    <div class="logo">🍔 Hunger_hub</div>

    <div class="nav-links">
<a href="<%=request.getContextPath()%>/myOrders">
            My Orders
        </a>        <a href="cart.jsp">cart</a>
        <a href="profile.jsp">Profile</a>
        <a href="logoutUser">Logout</a>
        
    </div>

</nav>

<!-- HERO SECTION -->

<section class="hero">

    <div class="hero-content">

        <h2>Delicious Food Delivered To Your Doorstep</h2>

        <p>
            Order from your favorite restaurants and enjoy hot,
            fresh meals anytime, anywhere.
        </p>

        <button onclick="document.getElementById('restaurants').scrollIntoView({behavior:'smooth'})">
            Order Now
        </button>

    </div>

</section>
<!-- SEARCH BAR (PLACE HERE BELOW HERO) -->
<div class="search-section">
    <input type="text" id="searchInput" placeholder="Search foods or restaurants..." onkeyup="searchItems()">
</div>

<!-- RESTAURANTS -->

<section class="restaurants" id="restaurants">

    <h2>Our Restaurants</h2>

    <div class="restaurant-grid">

        <%
        List<Restaurant> allRestaurants =
        (List<Restaurant>) request.getAttribute("allRestaurants");
       
if(allRestaurants != null && !allRestaurants.isEmpty()){
    for(Restaurant restaurant : allRestaurants){
%>

<a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>">
    <div class="restaurant-card">

        <img src="<%=request.getContextPath()%>/image/<%=restaurant.getImage()%>" alt="Restaurant">

        <h3><%= restaurant.getRname() %></h3>

        <p>Delivery Time : <%= restaurant.getDeliverytime() %> mins</p>
        <p>Rating : <%= restaurant.getRating() %></p>
        <p>Cuisine Type : <%= restaurant.getCuisinetype() %></p>
        <p>Address : <%= restaurant.getAddress() %></p>
        <p>Is Active : <%= restaurant.getIsactive() ? "Open" : "Close" %></p>

    </div>
</a>

<%
    }
}else{
%>

<h3>No Restaurants Found</h3>

<%
}
%>
        
        
        
        

    </div>
    </a>

</section>

</body>
<script>
function searchItems() {
    let input = document.getElementById("searchInput").value.toLowerCase();
    let cards = document.getElementsByClassName("food-card");

    for (let i = 0; i < cards.length; i++) {
        let title = cards[i].getElementsByTagName("h3")[0].innerText.toLowerCase();

        if (title.includes(input)) {
            cards[i].style.display = "block";
        } else {
            cards[i].style.display = "none";
        }
    }
}
</script>
</html>