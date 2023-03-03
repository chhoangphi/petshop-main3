package com.petshop.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petshop.entity.*;

@Repository
public class ProductsDao extends BaseDao{

	
	public List<Products> GetDataProduct(){
		List<Products> list = new ArrayList<Products>();
		String sql = "SELECT * FROM products_hotdeal";
		list = _JdbcTemplate.query(sql, new MapperProducts());
		return list;
	} 
	public List<Products> GetDataProducts(){
		List<Products> list = new ArrayList<Products>();
		String sql = "SELECT * FROM products";
		list = _JdbcTemplate.query(sql, new MapperProducts());
		return list;
	} 
}
