package com.shop.action;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Category;
import com.shop.service.CategoryService;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

    
    public String update(){
        System.out.println("---struts update ");
        System.out.println(model);
        categoryService.update(model);
        return "index2";
    }
    
    public String save(){
        categoryService.save(model);
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
