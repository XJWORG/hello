package com.shop.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop.model.Category;
import com.shop.service.CategoryService;
import com.shop.utils.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService {


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

    @Override
    public void save(Category category) {
        getSession().save(category);
    }
    
    @Override //整合后的情况
    public void update(Category category) {
        getSession().update(category);  
    }

    @Override
    public void delete(int id) {
       /* 这个方法有个弊端，每次删除就得先查询一次
        Object obj = getSession().get(Category.class, id);
        if(obj != null){
            getSession().delete(obj);
        }*/
        
        String hql = "delete Category where id=:id";
        getSession().createQuery(hql).setInteger("id", id).executeUpdate();
    }

    @Override
    public Category get(int id) {
        // TODO Auto-generated method stub
        return (Category)getSession().get(Category.class , id);
    }

    @Override
    public List<Category> query() {
        String hql = "from Category";
        return getSession().createQuery(hql).list();
    }
    
    
}
