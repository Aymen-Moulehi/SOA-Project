# SOA-Project
## Front-End

index .php ce fichier permet de récupérer une liste de produit à partir de la valeur du catégorie donnée par le URL.
http://localhost/eshope?category=Printers


```
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
```
