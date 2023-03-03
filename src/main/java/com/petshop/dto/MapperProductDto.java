package com.petshop.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductDto  implements RowMapper<ProductDto>{

	
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto products=new ProductDto();
		products.setItem_id(rs.getString("item_id"));
		products.setProduct_catid(rs.getString("product_catid"));
		products.setType_id(rs.getString("type_id"));
		products.setType_name(rs.getString("type_name"));
		products.setProduct_id(rs.getString("product_id"));
		products.setImg(rs.getString("img"));
		products.setProduct_name(rs.getString("product_name"));
		products.setPrice(rs.getString("price"));
		return products;
	}
		
}
