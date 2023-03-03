package com.petshop.entity;

public class Menus {
		private String menu_id;
		private String name;
		private int order;
		private String item_id;
		public String getItem_id() {
			return item_id;
		}
		public void setItem_id(String item_id) {
			this.item_id = item_id;
		}
		public Menus() {
			super();
		}
		public String getMenu_id() {
			return menu_id;
		}
		public void setMenu_id(String menu_id) {
			this.menu_id = menu_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
}
