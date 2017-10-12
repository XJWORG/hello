package com.shop.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

    /*Spring和Hibernate整合后*/
    private SessionFactory sessionFactory;
    
    //Spring会注进来
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    protected Session getSession() {
        //从当前线程获取session，如果没有则创建一个新的session
        return sessionFactory.getCurrentSession();
    }
    
    @Override //整合后的情况
    public void update(Category category) {
        getSession().update(category);  
    }
    
    
}
