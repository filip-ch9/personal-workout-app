<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/register.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up</title>
</head>
<body>
    <video id="videoBG" poster="poster.JPG" autoplay muted loop>
          <source src="video/vid.mp4" type="video/mp4">
    </video>
    	<h1 class="ml9">
            <span class="text-wrapper">
              <span class="letters">Connect with users around the world Create the workout plan they need - Monitor their progress</span>
            </span>
          </h1>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
          <script src="js/user_register.js"></script>
    	<div>
        	<h1 class="myHead">Sign up form</h1>
        	<form method="POST">
            	<label for="name"></label>
            	<input type="text" id="name" name="name" placeholder="Name" required="required">
            
            	<label for="surname"></label>
            	<input type="text" id="surname" name="surname" placeholder="Surname" required="required">
            
            	<label for="age"></label>
            	<input type="number" id="age" name="age" placeholder="Current age" required="required">

            	<font color="red">${errorMessage}</font>
            	<label for="email"></label>
            	<input type="email" id="email" name="email" placeholder="example@example.com" required="required">

            	<label for="country"></label>
            	<select id="country" name="country">
                  	<option value="argentina">Argentina</option>
                  	<option value="Australia">Australia</option>
                  	<option value="Austria">Austria</option>
                  	<option value="belgium">Belgium</option>
                  	<option value="brazil">Brazil</option>
                  	<option value="bulgaria">Bulgaria</option>
                  	<option value="canada">Canada</option>
                  	<option value="chile">Chile</option>
                  	<option value="china">China</option>
                  	<option value="croatia">Croatia</option>
                  	<option value="denmark">Denmark</option>
                  	<option value="estonia">Estonia</option>
                  	<option value="finland">Finland</option>
                  	<option value="france">France</option>
                  	<option value="germany">Germany</option>
                  	<option value="iceland">Iceland</option>
                  	<option value="japan">Japan</option>
                  	<option value="luxemburg">Luxemburg</option>
                  	<option value="macedonia">Macedonia</option>
                  	<option value="russia">Russia</option>
			      	<option value="spain">Spain</option>
			      	<option value="uk">United Kingdom</option>  
            	</select>
            	<label for="gender"></label>
            	<select id="gender" name="gender">
                  	<option value="male">Male</option>
                  	<option value="female">Female</option>
                  	<option value="other">Other</option>
            	</select>
            
            	<label for="title"></label>
            	<input type="text" id="title" name="title" placeholder="Title">
            
            	<label for="accomplishments"></label>
            	<input type="text" id="accomplishments" name="accomplishments" placeholder="Accomplishments" required="required">

            	<label for="biography"></label>
            	<textarea id="biography" name="biography" rows="9" cols="70" placeholder="Short Biography" required="required"></textarea>

            	<label for="username"></label>
            	<input type="text" id="username" name="username" placeholder="Username" required="required">
            
            	<label for="password"></label>
            	<input type="password" id="password" name="password" placeholder="Password" required="required">

            	<label for="confirmPassword"></label>
            	<input type="password" id="confirmPassword" name="confirmPassword" placeholder="Retype password" required="required">

            	<button type="submit" class="btn">Submit</button>
        	</form>
    	</div>
	</body>
</html>