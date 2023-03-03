package com.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dto.PaginatesDto;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.itemTypeServiceImpl;

@Controller
public class CategoriesController {
	@Autowired
	private HomeServiceImpl HomeServive;
	@Autowired
	private itemTypeServiceImpl itemTypeService;
	@Autowired
	private PaginatesServiceImpl paginateService;

	@RequestMapping(value = "/san-pham/{item_id}")
	public ModelAndView Product(@PathVariable String item_id) {
		ModelAndView mv = new ModelAndView("customer/product");
		mv.addObject("menu", HomeServive.GetDataMenu());
		mv.addObject("item_id", item_id);
       // mv.addObject("type_op",itemTypeService.GetDataProductByTypeOfProduct(item_id);
        mv.addObject("allProductById", itemTypeService.GetDataAllProductByItemID(item_id));
		mv.addObject("typeOfProduct", itemTypeService.GetDataTypeOfProduct(item_id));
		return mv;
	}
	
	@RequestMapping(value = "/san-pham/{item_id}/{type_id}/{currentPage}")
	public ModelAndView Product(@PathVariable String item_id,@PathVariable String type_id, @PathVariable String currentPage) {
		ModelAndView mv = new ModelAndView("customer/product_category");
		mv.addObject("item_id", item_id);
		mv.addObject("type_id", type_id);
		mv.addObject("menu", HomeServive.GetDataMenu());
		int totalProductPage = 8;
		int TotalData = itemTypeService.GetDataAllProductByItemID(item_id).size();
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mv.addObject("pageinfo", pageinfo);
		mv.addObject("ProductPaginate",itemTypeService.GetDataProductPaginate(item_id,type_id, pageinfo.getStart(), totalProductPage));
		return mv;
	}
}
