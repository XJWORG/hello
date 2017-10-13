package com.shop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
    
    //clazz中存储了当前的操作类型，即泛型 T
    private Class clazz;
    private SessionFactory sessionFactory;
    
    public BaseServiceImpl(){
    	System.out.println("this 代表的是调用构造方法的对象：" + this);
    	System.out.println("this 的父类为：" + this.getClass().getSuperclass());
    	System.out.println("获取当前this对象的父类信息，含泛型："+ this.getClass().getGenericSuperclass());
    	
    	ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
    	clazz = (Class)type.getActualTypeArguments()[0];
    }
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    protected Session getSession(){
    	return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void save(T t) {
        getSession().save(t);
    }

    @Override
    public void delete(int id) {
    	String hql = "delete " + clazz.getSimpleName() + " as c where c.id=:id";
        getSession().createQuery(hql).setInteger("id", id).executeUpdate();
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public T get(int id) {
        return (T)getSession().get(clazz, id);
    }

    @Override
    public List<T> query() {
        String hql = "from " + clazz.getSimpleName();
        return getSession().createQuery(hql).list();
    }



}
