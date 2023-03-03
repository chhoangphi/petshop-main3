package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.ProductDto;
import com.petshop.dto.ProductsByItemIDDto;

@Service
public class itemTypeServiceImpl implements IitemTypeService {
	@Autowired
	private ProductsByItemIDDto byItemIDDto;
	
	public List<ProductDto> GetDataAllProductByItemID(String item_id) {
		return byItemIDDto.GetDataAllProductByItemID(item_id);
	}
	public List<ProductDto> GetDataProductPaginate(String item_id,String type_id,int start, int totalPage) {
		return byItemIDDto.GetDataProductPaginate(item_id,type_id, start, totalPage);
	}
	public List<ProductDto> GetDataProductByTypeOfProduct(String item_id,String type_id){
		return byItemIDDto.GetDataProductByTypeOfProduct(item_id, type_id);
	}
	public List<ProductDto> GetDataTypeOfProduct(String item_id) {
		return byItemIDDto.GetDataTypeOfProduct(item_id);
	}
}
