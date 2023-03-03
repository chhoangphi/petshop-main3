package com.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dto.PaginatesDto;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.itemTypeServiceImpl;
import com.petshop.service.PaginatesServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private HomeServiceImpl HomeServive;
	@Autowired
	private itemTypeServiceImpl itemTypeService;
	@Autowired
	private PaginatesServiceImpl paginateService;

	@RequestMapping(value = { "/trang-chu", "/" })
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("customer/home");
		mv.addObject("products_hotdeal", HomeServive.GetDataProduct());
		mv.addObject("products", HomeServive.GetDataProducts());
		mv.addObject("itemtype", HomeServive.GetDataItemType());
		mv.addObject("menu", HomeServive.GetDataMenu());
		// mv.addObject("AllProductByitem_id",
		// itemTypeService.GetDataAllProductByItemID("item01"));
		int totalProductPage = 8;
		int TotalData = itemTypeService.GetDataAllProductByItemID("item01").size();
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage, 1);
		mv.addObject("pageinfo", pageinfo);
		mv.addObject("ProductPaginate",
				itemTypeService.GetDataProductPaginate("item01","type01", pageinfo.getStart(), pageinfo.getEnd()));
		return mv;
	}
}
