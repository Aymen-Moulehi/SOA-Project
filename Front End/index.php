<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="4.png">
    <link rel="stylesheet" href="css/view.css">
    <link rel="stylesheet" href="css/index.css">
    <title>Eshope</title>
</head>
<body>
    
<ul>
  <li><a class="active" href="/eshope/">Home</a></li>
  <li><a href="/eshope/product/product.php">Add Product</a></li>
  <li><a href="/eshope/product/contact.php">Contact</a></li>
  <li><a href="/eshope/product/about.php">About</a></li>
</ul>

<div class="scrollmenu">
  <a href="http://localhost/eshope?category=Computers">Computers</a>
  <a href="http://localhost/eshope?category=Printers">Printers</a>
  <a href="http://localhost/eshope?category=Accessories">Accessories</a>
  <a href="http://localhost/eshope?category=Keyboards">Keyboards</a>
  <a href="http://localhost/eshope?category=Storage">Storage</a>
  <a href="http://localhost/eshope?category=Satchel">Satchel</a>
  <a href="http://localhost/eshope?category=Cables">Cables</a>  
  <a href="http://localhost/eshope?category=Antivirus">Antivirus</a>

</div>




<div style="max-width:100%">
  <img class="mySlides" src="1.jpg" style="width:100%">
  <img class="mySlides" src="2.jpg" style="width:100%">
  <img class="mySlides" src="3.jpg" style="width:100%">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel,3500); // Change image every 2 seconds
}
</script>




<?php




$api_url = 'http://localhost:8080/get/product?category='.$_GET['category'] ;

// Read JSON file
$json_data = file_get_contents($api_url);

// Decode JSON data into PHP array
$response_data = json_decode($json_data);

// All user data exists in 'data' object
$user_data = $response_data ;
// Cut long data into small & select only first 10 records
$user_data = array_slice($user_data,0,10);


foreach ($user_data as $user) {

  echo ' 
  <div class="flex-container">
      <div><img width ="200px"src='.urldecode($user->imglink).'></div>
      <div>
          <h2>'.urldecode($user->pname).'</h2>
          <h3 id="price">'.urldecode($user->price).' TND</h3>
          <p>'.urldecode($user->descreption).'</p>
          <button class="button">Buy Now</button>
      </div>
  </div>
  
  ' ;

}

?>










</body>
</html>