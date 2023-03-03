package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entity.ItemType;
import com.petshop.entity.Menus;
import com.petshop.entity.Products;

@Service
public interface IHomeService {
	@Autowired
	public List<Products> GetDataProduct();
	
	public List<Products> GetDataProducts();

	public List<ItemType> GetDataItemType();
	public List<Menus> GetDataMenu();
}
