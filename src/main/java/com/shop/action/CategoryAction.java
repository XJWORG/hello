package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Category;
import com.shop.service.CategoryService;

public class CategoryAction extends ActionSupport {
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
}
