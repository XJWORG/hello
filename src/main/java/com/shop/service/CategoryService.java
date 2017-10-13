package com.shop.service;
import java.util.List;

import com.shop.model.Category;

public interface CategoryService {
    /*保存*/
	public void save( Category category ); 
	/*更新*/
	public void update(Category category);
	
	public void delete(int id);
	
	public Category get(int id);
	
	public List<Category> query();
	
}
