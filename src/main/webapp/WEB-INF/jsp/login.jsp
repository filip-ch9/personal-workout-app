
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/login.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <img src="img/loginImg.png" alt="Personilezed Wrokout App" class="center">
    <div class="headingTwo">
    <p>PERSONALIZED WORKOUT APP LOG IN</p>
    </div>
    <div class="loginContainer">
        <font color="red">${errorMessage}</font>
        <form method="POST">
            <label for="email"></label>
            <input type="text" placeholder="Email" name="email" required>

            <label for="password"></label>
            <input type="password" placeholder="Password" name="password" required>
            <span class="password"><a href="/recover_password">Forgot your password?</a></span>
            <button type="submit" class="btn">Login</button>
        </form>
    </div>
</body>
</html>