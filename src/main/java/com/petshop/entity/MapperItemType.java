package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperItemType implements RowMapper<ItemType> {

	public ItemType mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ItemType itemType= new ItemType();
		itemType.setItem_id(rs.getString("item_id"));
		itemType.setName(rs.getString("name"));
		return itemType;
	}
}
