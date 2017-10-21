package com.shop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.ProductService;

@Service("productService")
@Lazy(true)
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Override
    public Long getCount(String name) {
        // 注意这里Category的大小写，category是查不到的
        String hql = "select count(c) from Product c where c.name like :name";
        return (Long) getSession().createQuery(hql)
            .setString("name", "%" + name + "%")
            .uniqueResult(); //返回一条记录:总记录数
    }

    @Override
    public List<Product> queryJoinCategory(String name, int page, int size) {
        String hql = "from Product c left join fetch c.category where c.name like :name";
        return getSession().createQuery(hql)
                .setString("name", "%"+name+"%")
                .setFirstResult((page-1)*size)
                .setMaxResults(size).list();
    }

    @Override
    public void deleteByIds(String ids) {
        String hql = "delete from Product c where c.id in (" + ids + ")";
        getSession().createQuery(hql).executeUpdate();
        //TODO 需要同时删除图片
    }

	@Override
	public List<Product> queryByCategoryId(int cid) {
		String hql = "from Product p join fetch p.category "
				+ "where p.commend=true and p.open=true and p.category.id=:cid order by p.date desc";
		return getSession().createQuery(hql).setInteger("cid", cid).setFirstResult(0).setMaxResults(4).list();
	}


}
