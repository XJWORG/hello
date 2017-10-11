package com.shop.service.impl;

import org.hibernate.Session;

import com.shop.model.Category;
import com.shop.service.CategoryService;
import com.shop.utils.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		try{
			session.getTransaction().begin();
			session.save(category);
			session.getTransaction().commit();
		} catch(Exception e){
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
