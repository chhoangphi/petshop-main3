package com.petshop.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.petshop.dao.BaseDao;


@Repository
public class ProductsByItemIDDto extends BaseDao {
	public String SqlType_id(String item_id) {
		StringBuffer sql= new StringBuffer();
		sql.append("SELECT");
		sql.append(" tp.id AS type_id");
		sql.append(",tp.name AS type_name");
		sql.append(" FROM items_type AS it");
		sql.append(" INNER JOIN type_of_products AS tp");
		sql.append(" ON it.item_id=tp.item_id");
		sql.append("  WHERE it.item_id='"+item_id+"' ");
		return sql.toString();
	}
	
	public StringBuffer SqlString(){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("tp.id AS type_id,tp.name AS type_name,it.item_id,p.name AS product_name,p.price,p.img,p.id AS product_id");
		sql.append(",pc.id AS product_catid ");
		sql.append("FROM ");
		sql.append("items_type AS it INNER JOIN type_of_products AS tp ");
		sql.append("ON it.item_id=tp.item_id ");
		sql.append("INNER JOIN product_categories AS pc ");
		sql.append("ON tp.id=pc.type_id INNER JOIN products AS p ");
		sql.append("ON p.product_catid=pc.id ");
		return sql;	
	}
	
	public StringBuffer SqlProductByItemID(String item_id) {
		StringBuffer sql=SqlString();
		sql.append("WHERE ");
		sql.append("it.item_id='"+item_id+"' ");
		return sql;
	}
	
	public StringBuffer SqlProductByTypeOfProduct(String item_id,String type_id) {
		StringBuffer sql=SqlProductByItemID(item_id);
		sql.append("AND tp.id='"+type_id+"' ");
		return sql;
	}
	
	public String SqlProductPagiante(String item_id,String type_id,int start,int totalPage) {
		StringBuffer sql=SqlProductByTypeOfProduct(item_id,type_id);
		sql.append("LIMIT ");
		sql.append(start+", "+totalPage);
		return sql.toString();
	}
	
	public List<ProductDto> GetDataAllProductByItemID(String item_id){
		try {
			  String sql = SqlProductByItemID(item_id).toString();
			  
			  List<ProductDto> list = _JdbcTemplate.query(sql, new MapperProductDto());
			  return list;
			} catch (Exception e) {
			  // Xử lý ngoại lệ
				
			  e.printStackTrace();
			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
			}

	}
    public List<ProductDto> GetDataProductPaginate(String item_id,String type_id,int start,int totalPage){
    	try {
    	String sql=SqlProductPagiante(item_id,type_id,start,totalPage);
    	System.out.println("SQL Query: "+sql);
		List<ProductDto> list=_JdbcTemplate.query(sql, new MapperProductDto());
		return list;
    	}catch (Exception e) {
			  // Xử lý ngoại lệ
    		System.out.println(e);
			  e.printStackTrace();
			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
			}
    }
    public List<ProductDto> GetDataProductByTypeOfProduct(String item_id,String type_id){
    	try {
    	String sql=SqlProductByTypeOfProduct(item_id,type_id).toString();
    	System.out.println("SQL Query: "+sql);
		List<ProductDto> list=_JdbcTemplate.query(sql, new MapperProductDto());
		return list;
    	}catch (Exception e) {
			  e.printStackTrace();
			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
			}
    }
    public List<ProductDto> GetDataTypeOfProduct(String item_id){
    	try {
    	String sql=SqlType_id(item_id);
    	System.out.println("SQL Query: "+sql);
		List<ProductDto> list=_JdbcTemplate.query(sql, new MapperTypeOfProduct());
		return list;
    	}catch (Exception e) {
			  e.printStackTrace();
			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
			}
    }

}
