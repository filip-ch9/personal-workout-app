<!DOCTYPE html>
<html lang="en">
<head>
   <!-- stylesheet -->
  <link rel="stylesheet" href="css/coach_profile.css">
  <!-- stylesheet -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Training Plans</title>
</head>
<body>
	 <!-- navbar -->
  <div class="navbar">
    <a href="/" class="right">Logout</a>
    <a href="/coach-profile">Profile</a>
    <a href="/nutrition">Nutrition</a>
    <a href="/analytics">Analytics</a>
    <a href="/training">Training</a>
    <a href="/dashboard">Dashboard</a>
    
  </div>
  <script src="js/sidebar.js"></script>
  <div id="mySidebar" class="sidebar">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">x</a>
    <a href="/dashboard">Dashboard</a>
    <a href="/training">Training</a>
    <a href="/analytics">Analytics</a>
    <a href="/nutrition">Nutrition</a>
    <br>
    <br>
    <a href="/help">Help</a>
    <br>
    <a href="/about">About</a>
    <a href="/contact">Contact Us</a>
    <br>
    <br>
    <a href="/coach-profile">Profile</a>
    <a href="/">Logout</a>
  </div>
  <div id="main">
    <button class="openbtn" onclick="openNav()">
	  <div class="bar1"></div>
      <div class="bar2"></div>
      <div class="bar3"></div>    
    </button> 
  </div>
  <!-- /navbar -->
</body>
</html>