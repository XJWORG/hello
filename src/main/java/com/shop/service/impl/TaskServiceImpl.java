package com.shop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shop.model.Task;
import com.shop.service.TaskService;

@Service("taskService")
@Lazy(true)
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {

    @Override
    public Long getCount() {
        // 注意这里Category的大小写，category是查不到的
        String hql = "select count(c) from t_task_list c ";
        return (Long) getSession().createQuery(hql)
            .uniqueResult(); //返回一条记录:总记录数
    }


    @Override
    public void deleteByIds(String ids) {
        System.out.println(ids);
        String hql = "delete from t_task_list c where c.id in (" + ids + ")";
        getSession().createQuery(hql).executeUpdate();
        //TODO 需要同时删除图片
    }

	@Override
	public List<Task> queryAll(Integer page , Integer size) {
		String hql = "from t_task_list p";
		return getSession().createQuery(hql).setFirstResult((page-1)*size).setMaxResults(size).list();
	}


}
