package com.example.demo;

public class Product {
	
		String imglink ;
		String pname  ;
		String price ; 
		String category ; 
		String descreption ;
		public Product(String imglink, String pname, String price, String category, String descreption) {
			super();
			this.imglink = imglink;
			this.pname = pname;
			this.price = price;
			this.category = category;
			this.descreption = descreption;
		}
		public String getImglink() {
			return imglink;
		}
		public void setImglink(String imglink) {
			this.imglink = imglink;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDescreption() {
			return descreption;
		}
		public void setDescreption(String descreption) {
			this.descreption = descreption;
		} 
		
		

}
