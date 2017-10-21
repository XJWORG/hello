package com.shop.service;

import java.util.List;

import com.shop.model.Category;
import com.shop.model.Product;

public interface ProductService extends BaseService<Product> {

    //补充getCount的实现--获取记录数
    public Long getCount(String type);
    //使用商品type查询类别信息，级联管理员
    public List<Product> queryJoinCategory(String name, int page, int size);  //实现分页
    //根据ids删除多条记录
    public void deleteByIds(String ids);
}
