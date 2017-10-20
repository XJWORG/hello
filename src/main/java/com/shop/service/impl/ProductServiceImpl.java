package com.shop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shop.model.Product;
import com.shop.service.ProductService;

@Service("productService")
@Lazy(true)
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public void save(Product t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> query() {
		// TODO Auto-generated method stub
		return null;
	}

}
