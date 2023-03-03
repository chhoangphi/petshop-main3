package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProducts implements RowMapper<Products>{

	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		products.setId(rs.getString("id"));
		products.setName(rs.getString("name"));
		products.setImg(rs.getString("img"));
		products.setPrice(rs.getString("price"));
		return products;
	}
	
}
