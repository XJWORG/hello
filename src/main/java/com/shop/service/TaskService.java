package com.shop.service;

import java.util.List;

import com.shop.model.Task;

public interface TaskService extends BaseService<Task> {

    //补充getCount的实现--获取记录数
    public Long getCount();
    //查询所有项目
    public List<Task> queryAll(Integer page , Integer size);  //实现分页
    //根据sids删除多条记录
    public void deleteByIds(String ids);
    
}
