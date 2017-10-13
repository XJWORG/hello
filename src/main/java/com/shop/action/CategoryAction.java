package com.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.model.Category;
import com.shop.service.CategoryService;

public class CategoryAction extends BaseAction implements ModelDriven<Category> {
    private Category category = new Category();
    private CategoryService categoryService;

	@Override
	public Category getModel() {
		return category;
	}  

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    public Category getCategory(){
        return this.category ;
    }
    public String update(){
        System.out.println("---struts update ");
        System.out.println(category);
        categoryService.update(category);
        return "index2";
    }
    
    public String save(){
        categoryService.save(category);
        return "index2";
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

}
