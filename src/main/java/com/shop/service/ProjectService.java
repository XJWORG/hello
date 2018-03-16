package com.shop.service;

import java.util.List;

import com.shop.model.Project;

public interface ProjectService extends BaseService<Project> {

    //补充getCount的实现--获取记录数
    public Long getCount();
    //查询所有项目
    public List<Project> queryAll(Integer page , Integer size);  //实现分页
    //根据sids删除多条记录
    public void deleteBySids(String sids);
    //根据热点类别查询商品
//    public List<Project> queryByCategoryId(int cid);
    
}
