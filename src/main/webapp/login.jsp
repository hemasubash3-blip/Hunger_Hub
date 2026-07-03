<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hunger Hub | Login</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:#ffffff;
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:100%;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
}

/* Hunger Hub */

.brand{
    text-align:center;
    margin-bottom:35px;
}

.brand h1{
    font-size:60px;
    color:#fc8019;
    font-weight:700;
    letter-spacing:2px;
}

.brand p{
    margin-top:10px;
    font-size:22px;
    color:#666;
}

.brand .line{
    width:120px;
    height:4px;
    background:#fc8019;
    margin:15px auto;
    border-radius:10px;
}

/* Login Card */

.login-card{
    width:450px;
    background:#ffffff;
    border-radius:18px;
    padding:40px;
    border:1px solid #e5e5e5;
    box-shadow:0 8px 25px rgba(0,0,0,0.10);
}

.login-card h2{
    text-align:center;
    color:#fc8019;
    font-size:38px;
    margin-bottom:30px;
}

/* Form */

.form-group{
    margin-bottom:22px;
}

.form-group label{
    display:block;
    margin-bottom:8px;
    font-size:18px;
    font-weight:600;
    color:#333;
}

.form-group input{
    width:100%;
    padding:15px;
    border:1px solid #d9d9d9;
    border-radius:10px;
    font-size:16px;
    outline:none;
    transition:.3s;
}

.form-group input:focus{
    border-color:#fc8019;
}

/* Password */

.password-box{
    position:relative;
}

.password-box span{
    position:absolute;
    right:15px;
    top:15px;
    cursor:pointer;
    font-size:18px;
}

/* Button */

.login-btn{
    width:100%;
    padding:15px;
    background:#fc8019;
    color:#fff;
    border:none;
    border-radius:10px;
    font-size:20px;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
}

.login-btn:hover{
    background:#e66f0d;
}

/* Signup */

.signup{
    text-align:center;
    margin-top:20px;
    font-size:16px;
}

.signup a{
    color:#fc8019;
    text-decoration:none;
    font-weight:bold;
}

.signup a:hover{
    text-decoration:underline;
}

/* Footer */

.footer{
    margin-top:25px;
    font-size:14px;
    color:#777;
}

</style>

</head>

<body>

<div class="container">

    <!-- Brand -->

    <div class="brand">

        <h1>🍽 Hunger Hub</h1>

        <div class="line"></div>

        <p>Delicious Food Delivered to Your Doorstep</p>

    </div>

    <!-- Login -->

    <div class="login-card">

        <h2>Login</h2>

        <form action="login" method="get">

            <div class="form-group">
                <label>Email Address</label>

                <input
                    type="email"
                    name="email"
                    placeholder="Enter your email"
                    required>
            </div>

            <div class="form-group">

                <label>Password</label>

                <div class="password-box">

                    <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="Enter your password"
                        required>

                    <span onclick="togglePassword()">👁</span>

                </div>

            </div>

            <button type="submit" class="login-btn">
                Login
            </button>

        </form>

        <div class="signup">

            Don't have an account?

            <a href="signup.jsp">
                Sign Up
            </a>

        </div>

    </div>

    <div class="footer">
        © 2026 Hunger Hub. All Rights Reserved.
    </div>

</div>

<script>

function togglePassword(){

    var password=document.getElementById("password");

    if(password.type==="password"){
        password.type="text";
    }
    else{
        password.type="password";
    }

}

</script>

</body>
</html>