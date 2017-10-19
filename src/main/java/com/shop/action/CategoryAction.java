package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Category;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

    
    public String update(){
        System.out.println("---struts update ");
        System.out.println(model);
        categoryService.update(model);
        return "index2";
    }
    
    public void save(){
        categoryService.save(model);
    }

    /*我们知道，在Action中可以直接通过ActionContext.getContext()去获取一个ActionContext对象，
     * 然后通过该对象再去获得相应的域对象；也可以通过实现xxxAware接口来注入相应的域对象。我们先来看一下这两种方法：
     */
    public String query() {  
//    	解决方案一，采用相应的map取代原来的内置对象，这样与jsp没有依赖，但是代码量比较大   
//         ActionContext.getContext().put("categoryList", categoryService.query()); //放到request域中   
//         ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //放到session域中   
//         ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //放到application域中   
         
//           解决方案二，实现相应的接口(RequestAware,SessionAware,ApplicationAware)，让相应的map注入   
    	 System.out.println(request);
         request.put("categoryList", categoryService.query());   
         session.put("categoryList", categoryService.query());   
         application.put("categoryList", categoryService.query());   
         return "index2";  
       }

    public String deleteByIds(){
        System.out.println("------------------");
        categoryService.deleteByIds(ids);
        //如果删除成功就会继续执行，我们将true以流的形式传给前台
        inputStream = new ByteArrayInputStream("true".getBytes()); //将true字节存到流inputStream中
        return "stream";
    }
    
    public String queryJoinAccount(){
    	//用来存储分页的数据
    	pageMap = new HashMap<String ,Object>();
    	
    	//根据关键字和分页的参数查询相应的数据，
    	List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
    	//存储为json格式（从实例中看出，datagrid的两个key分别为total和rows，这里先存储rows）。
    	pageMap.put("rows", categoryList);
    	
    	//根据关键字查询总记录数
    	Long count = categoryService.getCount(model.getType());
    	pageMap.put("total", count);

    	return "jsonMap";
    }
    
}
