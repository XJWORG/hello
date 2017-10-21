package com.shop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

    public String queryJoinCategory(){
        System.out.println("---------------");
        //定义easyui的输出json参数
        pageMap = new HashMap<String ,Object>(); 
        
        List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
        pageMap.put("rows", productList);
        System.out.println("--------1-------");
        
        Long count = (Long)productService.getCount(model.getName());
        pageMap.put("total", count);

        System.out.println("-------2--------");
        return "jsonMap";
    }
}
