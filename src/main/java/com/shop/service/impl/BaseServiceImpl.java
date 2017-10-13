package com.shop.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.shop.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
    
    //clazz中存储了当前的操作类型，即泛型 T
    private Class clazz;
    private SessionFactory sessionFactory;
    @Override
    public void save(T t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(T t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(T t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> query() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
