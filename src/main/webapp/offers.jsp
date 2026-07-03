<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>

<%
class Offer{

    private String title;
    private String description;
    private String couponCode;
    private String discount;
    private String expiry;

    public Offer(String title,
                 String description,
                 String couponCode,
                 String discount,
                 String expiry){

        this.title=title;
        this.description=description;
        this.couponCode=couponCode;
        this.discount=discount;
        this.expiry=expiry;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getCouponCode(){
        return couponCode;
    }

    public String getDiscount(){
        return discount;
    }

    public String getExpiry(){
        return expiry;
    }

}
%>

<%

List<Offer> offers=new ArrayList<>();

offers.add(new Offer(
        "Flat ₹100 OFF",
        "Get ₹100 off on orders above ₹499",
        "SAVE100",
        "₹100 OFF",
        "31 Dec 2026"));

offers.add(new Offer(
        "50% OFF",
        "Maximum discount ₹150",
        "HALFOFF",
        "50% OFF",
        "15 Jan 2027"));

offers.add(new Offer(
        "Free Delivery",
        "On orders above ₹199",
        "FREEDEL",
        "FREE DELIVERY",
        "30 Nov 2026"));

offers.add(new Offer(
        "20% OFF New Users",
        "Applicable only on first order",
        "WELCOME20",
        "20% OFF",
        "31 Mar 2027"));

offers.add(new Offer(
        "Weekend Special",
        "Flat ₹250 OFF on weekend",
        "WEEKEND250",
        "₹250 OFF",
        "Every Weekend"));

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Coupons & Offers</title>
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
    width:100%;
    background:white;
    padding:18px 60px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    box-shadow:0 2px 10px rgba(0,0,0,.08);
}

.logo{
    font-size:30px;
    font-weight:bold;
    color:#fc8019;
}

.back-btn{
    text-decoration:none;
    background:#fc8019;
    color:white;
    padding:10px 22px;
    border-radius:8px;
    font-weight:bold;
    transition:.3s;
}

.back-btn:hover{
    background:#e56d00;
}

/* Main Container */

.container{
    width:90%;
    max-width:1200px;
    margin:40px auto;
}

.heading{
    text-align:center;
    color:#333;
    margin-bottom:40px;
    font-size:35px;
}

/* Cards */

.offer-container{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(350px,1fr));
    gap:30px;
}

.offer-card{
    background:white;
    border-radius:20px;
    padding:25px;
    box-shadow:0 8px 20px rgba(0,0,0,.08);
    transition:.3s;
    position:relative;
    overflow:hidden;
}

.offer-card:hover{
    transform:translateY(-8px);
}

.offer-card::before{
    content:"";
    position:absolute;
    top:0;
    left:0;
    width:8px;
    height:100%;
    background:#fc8019;
}

.offer-title{
    font-size:26px;
    color:#fc8019;
    margin-bottom:15px;
    font-weight:bold;
}

.offer-description{
    color:#666;
    font-size:16px;
    margin-bottom:15px;
    line-height:25px;
}

.discount{
    font-size:22px;
    color:#28a745;
    font-weight:bold;
    margin-bottom:15px;
}

.coupon{
    display:inline-block;
    background:#fff3e0;
    color:#fc8019;
    padding:12px 20px;
    border-radius:8px;
    font-weight:bold;
    letter-spacing:1px;
    margin-bottom:15px;
}

.expiry{
    color:#777;
    font-size:15px;
    margin-bottom:20px;
}

.btns{
    display:flex;
    gap:15px;
}

.copy-btn,
.apply-btn{

    flex:1;
    padding:13px;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;
    transition:.3s;
}

.copy-btn{

    background:#eeeeee;
    color:#333;
}

.copy-btn:hover{

    background:#d6d6d6;
}

.apply-btn{

    background:#fc8019;
    color:white;
}

.apply-btn:hover{

    background:#e56d00;
}

/* Responsive */

@media(max-width:768px){

.navbar{

    padding:20px;
}

.logo{

    font-size:24px;
}

.heading{

    font-size:28px;
}

.offer-container{

    grid-template-columns:1fr;
}

.btns{

    flex-direction:column;
}

}

</style>

</head>
<body>

<!-- NAVBAR -->

<div class="navbar">

    <div class="logo">
        🍔 HungerHub
    </div>

    <a href="profile.jsp" class="back-btn">
        ← Back
    </a>

</div>


<!-- MAIN CONTAINER -->

<div class="container">

    <h1 class="heading">
        🎁 Coupons & Offers
    </h1>

    <div class="offer-container">

        <% for(Offer offer : offers){ %>

        <!-- OFFER CARD -->

        <div class="offer-card">

            <div class="offer-title">
                <%=offer.getTitle()%>
            </div>

            <div class="offer-description">
                <%=offer.getDescription()%>
            </div>

            <div class="discount">
                <%=offer.getDiscount()%>
            </div>

            <div class="coupon">
                Coupon Code : <%=offer.getCouponCode()%>
            </div>

            <div class="expiry">
                ⏰ Valid Till :
                <%=offer.getExpiry()%>
            </div>

            <div class="btns">

                <button class="copy-btn"
                        onclick="copyCode('<%=offer.getCouponCode()%>')">
                    📋 Copy Code
                </button>

                <button class="apply-btn">
                    Apply Offer
                </button>

            </div>

        </div>

        <% } %>

    </div>

</div>
<!-- JavaScript -->

<script>

function copyCode(couponCode){

    navigator.clipboard.writeText(couponCode);

    alert("Coupon Code Copied Successfully!\n\n" + couponCode);

}

</script>

</body>

</html>