package com.shop.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;

@Component
public class ProductTimerTask extends TimerTask {
	
	@Resource
	private ProductService productService = null ;
	@Resource
	private CategoryService categoryService = null ;
	
	private ServletContext application = null ;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		System.out.println("------ProductTimer.run-------");
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		for(Category category : categoryService.queryByHot(true)){
			List<Product> lst = productService.queryByCategoryId(category.getId());
			bigList.add(lst);
		}
		
		application.setAttribute("bigList", bigList);

	}

}
