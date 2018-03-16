package com.shop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shop.model.Project;
import com.shop.service.ProductService;
import com.shop.service.ProjectService;

@Service("projectService")
@Lazy(true)
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService {

    @Override
    public Long getCount() {
        // 注意这里Category的大小写，category是查不到的
        String hql = "select count(c) from t_project_list c ";
        return (Long) getSession().createQuery(hql)
            .uniqueResult(); //返回一条记录:总记录数
    }


    @Override
    public void deleteBySids(String sids) {
        String hql = "delete from t_project_list c where c.sid in (" + sids + ")";
        getSession().createQuery(hql).executeUpdate();
        //TODO 需要同时删除图片
    }

	@Override
	public List<Project> queryAll(Integer page , Integer size) {
		String hql = "from t_project_list p";
		return getSession().createQuery(hql).setFirstResult(0).setMaxResults(4).list();
	}


}
