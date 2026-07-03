<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hunger_hub - Home</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:#f5f5f5;
}

/* Navbar */

.navbar{
    background:#ff5722;
    color:white;
    padding:15px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    font-size:24px;
    font-weight:bold;
}

.nav-links a{
    color:white;
    text-decoration:none;
    margin-left:20px;
    font-weight:bold;
}

/* Hero */

.hero{
    height:80vh;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    text-align:center;
    color:white;
    background:linear-gradient(rgba(0,0,0,0.5),
    rgba(0,0,0,0.5)),
    url("https://images.unsplash.com/photo-1504674900247-0877df9cc836");
    background-size:cover;
    background-position:center;
}

.hero h1{
    font-size:55px;
    margin-bottom:20px;
}

.hero p{
    font-size:22px;
    margin-bottom:25px;
}

.btn{
    background:#ff5722;
    color:white;
    text-decoration:none;
    padding:12px 25px;
    border-radius:5px;
}

/* Popular Dishes */

.food-section{
    padding:60px 40px;
    text-align:center;
    background:white;
}

.food-section h2{
    margin-bottom:40px;
}

.food-grid{
    display:flex;
    flex-wrap:wrap;
    justify-content:center;
    gap:25px;
}

.food-card{
    width:280px;
    background:white;
    border-radius:10px;
    overflow:hidden;
    box-shadow:0 0 10px rgba(0,0,0,0.1);
}

.food-card img{
    width:100%;
    height:200px;
    object-fit:cover;
}

.food-card h3{
    margin:15px 0;
}

.food-card p{
    padding:0 15px;
}

.price{
    display:block;
    color:#ff5722;
    font-size:20px;
    font-weight:bold;
    margin:15px 0;
}

.order-btn{
    background:#ff5722;
    color:white;
    border:none;
    padding:10px 20px;
    margin-bottom:20px;
    border-radius:5px;
}

/* Features */

.features{
    display:flex;
    justify-content:center;
    gap:25px;
    flex-wrap:wrap;
    padding:60px 20px;
}

.card{
    width:280px;
    background:white;
    padding:25px;
    border-radius:10px;
    text-align:center;
    box-shadow:0 0 10px rgba(0,0,0,0.1);
}

/* Common Sections */

.section{
    padding:60px 40px;
    text-align:center;
}

.categories,
.steps,
.reviews{
    display:flex;
    justify-content:center;
    gap:25px;
    flex-wrap:wrap;
    margin-top:30px;
}

.category-card,
.step,
.review{
    width:250px;
    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0 0 10px rgba(0,0,0,0.1);
}

/* Footer */

.footer{
    background:#333;
    color:white;
    text-align:center;
    padding:30px;
}

</style>

</head>
<body>

<!-- Navbar -->

<div class="navbar">

    <div class="logo">
        🍔 Hunger_hub
    </div>

    <div class="nav-links">
        <a href="login.jsp">Login</a>
        <a href="register.html">Register</a>
    </div>

</div>

<!-- Hero -->

<div class="hero">

    <h1>Delicious Food Delivered Fast</h1>

    <p>Order from your favourite restaurants anytime, anywhere.</p>

    <a href="login.jsp" class="btn">
        Explore Restaurants
    </a>

</div>

<!-- Popular Dishes -->

<section class="food-section">

    <h2>🍽️ Popular Dishes</h2>

    <div class="food-grid">

        <div class="food-card">
            <img src="https://images.unsplash.com/photo-1513104890138-7c749659a591">
            <h3>🍕 Margherita Pizza</h3>
            <p>Fresh cheese with tomato sauce.</p>
            <button class="order-btn">Order Now</button>
        </div>

        <div class="food-card">
            <img src="https://images.unsplash.com/photo-1568901346375-23c9450c58cd">
            <h3>🍔 Chicken Burger</h3>
            <p>Juicy burger with fresh vegetables.</p>
            <button class="order-btn">Order Now</button>
        </div>

        <div class="food-card">
            <img src="https://images.unsplash.com/photo-1612929633738-8fe44f7ec841">
            <h3>🍗 Chicken Biryani</h3>
            <p>Authentic biryani with rich spices.</p>
            <button class="order-btn">Order Now</button>
        </div>

    </div>

</section>

<!-- Features -->

<div class="features">

    <div class="card">
        <h3>🍕 Top Restaurants</h3>
        <p>Discover the best restaurants around you.</p>
    </div>

    <div class="card">
        <h3>⚡ Fast Delivery</h3>
        <p>Hot and fresh food delivered quickly.</p>
    </div>

    <div class="card">
        <h3>🎁 Exciting Offers</h3>
        <p>Enjoy daily discounts and rewards.</p>
    </div>

</div>


<!-- Categories -->

<section class="section">

    <h2>Popular Categories</h2>

    <div class="categories">

        <div class="category-card">
            <h3>🍕 Pizza</h3>
            <p>Cheesy and delicious pizzas.</p>
        </div>

        <div class="category-card">
            <h3>🍔 Burgers</h3>
            <p>Juicy burgers with fresh ingredients.</p>
        </div>

        <div class="category-card">
            <h3>🍜 Noodles</h3>
            <p>Authentic Asian flavours.</p>
        </div>

        <div class="category-card">
            <h3>🍰 Desserts</h3>
            <p>Sweet treats for everyone.</p>
        </div>

    </div>

</section>



<!-- Reviews -->

<section class="section">

    <h2>Customer Reviews</h2>

    <div class="reviews">

        <div class="review">
            <h3>⭐⭐⭐⭐⭐</h3>
            <p>Amazing food and fast delivery.</p>
            <strong>- Rahul</strong>
        </div>

        <div class="review">
            <h3>⭐⭐⭐⭐⭐</h3>
            <p>Best ordering experience.</p>
            <strong>- Priya</strong>
        </div>

        <div class="review">
            <h3>⭐⭐⭐⭐⭐</h3>
            <p>Highly recommended service.</p>
            <strong>- Arjun</strong>
        </div>

    </div>

</section>

<!-- Footer -->

<div class="footer">

    <h2>🍔 Hunger_hub</h2>

    <p>Delivering happiness to your doorstep.</p>

    <p>© 2026 FoodExpress. All Rights Reserved.</p>

</div>

</body>
</html>