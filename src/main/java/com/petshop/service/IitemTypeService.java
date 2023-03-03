package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.dto.ProductDto;
@Service
public interface IitemTypeService {
     public List<ProductDto> GetDataAllProductByItemID(String item_id);
     public List<ProductDto> GetDataTypeOfProduct(String item_id);
     public List<ProductDto> GetDataProductByTypeOfProduct(String item_id,String type_id);
     public List<ProductDto> GetDataProductPaginate(String item_id,String type_id,int start,int totalPage);
     
}
