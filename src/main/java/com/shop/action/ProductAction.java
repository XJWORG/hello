package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

    public String queryJoinCategory(){
        //定义easyui的输出json参数
        pageMap = new HashMap<String ,Object>(); 
        
        List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
        pageMap.put("rows", productList);
        
        Long count = (Long)productService.getCount(model.getName());
        pageMap.put("total", count);

        return "jsonMap";
    }
    
    public String deleteByIds(){
        productService.deleteByIds(ids);
        inputStream = new ByteArrayInputStream("true".getBytes()); //将true字节存到流inputStream中
        return "stream";
    }
    
    public void save() throws Exception {
        //fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
        String pic = fileUpload.uploadFile(fileImage);
        
        model.setPic(pic);

        model.setDate(new Date());
        productService.save(model);
    }
    
    public void update(){
        //fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
        String pic = fileUpload.uploadFile(fileImage);
        
        model.setPic(pic);

        model.setDate(new Date());
        productService.update(model);
    }
}
