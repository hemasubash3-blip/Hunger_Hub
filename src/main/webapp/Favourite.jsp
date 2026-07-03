<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.tap.Model.Menu"%>

<%
List<Menu> favouriteList = (List<Menu>) request.getAttribute("favouriteList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favourite Menu | FoodHub</title>

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

/* Header */

.header{
    background:#ffffff;
    padding:20px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 2px 10px rgba(0,0,0,.1);
}

.header h1{
    color:#333;
    font-size:34px;
    font-weight:bold;
}

/* Profile Button */

.profile-btn{
    background:#ff5722;
    color:white;
    text-decoration:none;
    padding:10px 22px;
    border-radius:8px;
    font-size:16px;
    font-weight:bold;
    transition:0.3s;
}

.profile-btn:hover{
    background:#e64a19;
}

/* Cards */

.cards{
    width:90%;
    margin:30px auto;
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(300px,1fr));
    gap:25px;
}

/* Card */

.card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 4px 12px rgba(0,0,0,.12);
    transition:.3s;
}

.card:hover{
    transform:translateY(-5px);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

/* Content */

.content{
    padding:20px;
}

.content h2{
    color:#333;
    margin-bottom:10px;
}

.content p{
    color:#666;
    margin-bottom:15px;
    line-height:1.5;
}

.content h3{
    color:#ff5722;
    margin-bottom:15px;
}

/* View Button */

.btn{
    display:inline-block;
    text-decoration:none;
    background:#ff5722;
    color:white;
    padding:10px 20px;
    border-radius:8px;
    font-weight:bold;
    transition:0.3s;
}

.btn:hover{
    background:#e64a19;
}

/* No Data */

.no-data{
    text-align:center;
    margin-top:80px;
    font-size:22px;
    color:#666;
}

</style>

</head>

<body>

<div class="header">

    <h1>❤️ Favourite Menu</h1>

    <a href="<%=request.getContextPath()%>/profile.jsp" class="profile-btn">
        👤 Profile
    </a>

</div>

<%
if(favouriteList != null && !favouriteList.isEmpty()){
%>

<div class="cards">

<%
for(Menu menu : favouriteList){
%>

<div class="card">

    <img src="<%=request.getContextPath()%>/image/<%=menu.getImage()%>"
         alt="<%=menu.getItemName()%>">

    <div class="content">

        <h2><%=menu.getItemName()%></h2>

        <p><%=menu.getDescription()%></p>

        <h3>₹ <%=menu.getPrice()%></h3>

        <a href="menu?restaurantId=<%=menu.getRestaurantId()%>" class="btn">
            View Restaurant
        </a>

    </div>

</div>

<%
}
%>

</div>

<%
}else{
%>

<div class="no-data">
    <h2>❤️ No Favourite Items Found</h2>
</div>

<%
}
%>

</body>
</html>