package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.CategoryService;

public class CategoryAction extends ActionSupport {
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    public String update(){
        System.out.println("---struts update");
        System.out.println(categoryService);
        return "index2";
    }
    
    public String save(){
        System.out.println("---struts save");
        System.out.println(categoryService);
        return "index2";
    }
}
