package com.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.model.Category;
import com.shop.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Category> queryJoinAccount(String type) {
		String hql = "from Category c where c.type like :type";
		return getSession().createQuery(hql).setString("type", "%"+type+"%").list();
	}
}
