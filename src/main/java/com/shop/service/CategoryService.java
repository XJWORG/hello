package com.shop.service;
import java.util.List;

import com.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	//使用商品type查询类别信息，级联管理员
	public List<Category> queryJoinAccount(String type); 
}
