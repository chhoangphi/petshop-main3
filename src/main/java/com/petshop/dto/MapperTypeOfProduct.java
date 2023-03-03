package com.petshop.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperTypeOfProduct implements RowMapper<ProductDto>{

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto types=new ProductDto();
		types.setType_id(rs.getString("type_id"));
		types.setType_name(rs.getString("type_name"));
		return types;
	}

}
