<!DOCTYPE html>
<html lang="en">

<head>
  <title>Profile</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/coach_profile.css">
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

    <div class="main">
      
      <h3>${user}</h3>
      <h1>Week of Feb 7th</h1>
      <p>2 training days - Power - Intensity 5/5</p>
      <div class="row">
        <div class="column">
      <table>
        <tr>
          <th>Name of Exercise</th>
          <th class="right">2 Movements - Alternating</th>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/floorAbs.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/squat.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <th>Name of Exercise</th>
          <th class="right">2 Movements - Alternating</th>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/deadlift.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/sprint.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <th>Name of Exercise</th>
          <th class="right">2 Movements - Alternating</th>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/oneleg.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/back.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
      </table>
    </div>
    <div class="column">
      <table>
        <tr>
          <th>Name of Exercise</th>
          <th class="right">2 Movements - Alternating</th>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/1.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/2.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <th>Name of Exercise</th>
          <th class="right">2 Movements - Alternating</th>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/3.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/4.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <th>Name of Exercise</th>
          <th class="right">2 Movements - Alternating</th>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/5.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
        <tr>
          <td>Sets - ${sets}</td>
          <td rowspan="3" style="text-align: center; vertical-align: middle;"><img src="gif/6.gif"></td>
        </tr>
        <tr>
          <td>Reps - ${reps}</td>
        </tr>
        <tr>
          <td>Rest - ${rest}</td>
        </tr>
      </table>
    </div>
    </div>
    </div>
     
<!-- footer -->
  <div class="footer">
    <h2>Personal Workout App 2021</h2>
    <div class="socialMedia">
      <a href="https://www.facebook.com/">
        <img src="img/facebook.png" alt="fb" class="socialMedia">
      </a>
      <a href="https://www.instagram.com/">
        <img src="img/instagram.png" alt="fb" class="socialMedia">
      </a>
      <a href="https://twitter.com/?lang=en">
        <img src="img/twitter.png" alt="fb" class="socialMedia">
      </a>
      <a href="https://www.linkedin.com/">
        <img src="img/linkedin.png" alt="fb" class="socialMedia">
      </a>
    </div>
    <a href="/about">About</a>
    <a href="/contact">Contact</a>
  </div>
  <!-- /footer -->
</body>

</html>