package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entity.ItemType;
import com.petshop.entity.Menus;
import com.petshop.entity.Products;
import com.petshop.dao.ItemTypeDao;
import com.petshop.dao.MenuDao;
import com.petshop.dao.ProductsDao;

@Service
public class HomeServiceImpl implements IHomeService{
    @Autowired
    private ProductsDao productsDao;
   @Autowired
    private ItemTypeDao itemTypeDao;
   @Autowired
   private MenuDao menuDao;
    
	public List<Products> GetDataProduct() {
		return productsDao.GetDataProduct();
	}
	public List<Products> GetDataProducts() {
		return productsDao.GetDataProducts();
	}
	public List<ItemType> GetDataItemType() {
		return itemTypeDao.GetDataItemType();
	} 
	public List<Menus> GetDataMenu() {
		return menuDao.GetDataMenu();
	} 

}
