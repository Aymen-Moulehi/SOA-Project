<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eshope</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/product.css">
    <link rel="icon" href="../4.png">
</head>
<body>
<ul>
  <li><a class="active" href="/eshope/">Home</a></li>
  <li><a href="/eshope/product/product.php">Add Product</a></li>
  <li><a href="/eshope/product/contact.php">Contact</a></li>
  <li><a href="/eshope/product/about.php">About</a></li>
</ul>


<div class="container">
  <form action="postProduct.php" method="post">

  <div class="row">
    <div class="col-25">
        <label for="fname">Image Link</label>
    </div>
    <div class="col-75">
        <input type="text" id="fname" name="imglink" placeholder="Image Link..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="fname">Product Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="fname" name="pname" placeholder="Product Name..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="lname">Price</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="price" placeholder="Price..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="category">Category</label>
    </div>
    <div class="col-75">
      <select id="country" name="category">
        <option value="Computers">Computers</option>
        <option value="Printers">Printers</option>
        <option value="Accessories">Computer accessories</option>
        <option value="Keyboards">Keyboards</option>
        <option value="Storage">Data storage</option>
        <option value="Satchel">PC briefcase & satchel/option>
        <option value="Cables">Cables & Adapters</option>
        <option value="Antivirus">Antivirus & Security</option>
      </select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="subject">Descreption</label>
    </div>
    <div class="col-75">
      <textarea id="subject" name="descreption" placeholder="Write something.." style="height:200px"></textarea>
    </div>
  </div>
  <br>
  <div class="row">
    <input type="submit" value="Submit">
  </div>
  </form>
</div>












</body>
</html>