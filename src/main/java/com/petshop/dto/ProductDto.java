package com.petshop.dto;

public class ProductDto {
		private String item_id;
		private String type_id;
	    private String type_name;
	    private String product_catid;
	    private String product_name;
	    private String product_id;
	    private String price;
	    private String img;
	    
		public ProductDto() {
			super();
		}
		
		
		public String getItem_id() {
			return item_id;
		}

		public void setItem_id(String item_id) {
			this.item_id = item_id;
		}

		public String getType_id() {
			return type_id;
		}

		public void setType_id(String type_id) {
			this.type_id = type_id;
		}

		public String getType_name() {
			return type_name;
		}

		public void setType_name(String type_name) {
			this.type_name = type_name;
		}

		public String getProduct_catid() {
			return product_catid;
		}

		public void setProduct_catid(String product_catid) {
			this.product_catid = product_catid;
		}

		public String getProduct_name() {
			return product_name;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public String getProduct_id() {
			return product_id;
		}

		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}
		
		
	     
}
