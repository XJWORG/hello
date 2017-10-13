package com.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Category;
import com.shop.service.CategoryService;

public class CategoryAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware {
    private Category category = new Category();
    private CategoryService categoryService;

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
        System.out.println("---struts save");
        System.out.println(category);
        System.out.println("---struts save end");
        return "index2";
    }

    private Map<String, Object> request;
    private Map<String, Object> session;
    private Map<String ,Object> application;
    
    
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

    
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
