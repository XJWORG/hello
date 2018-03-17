package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Project;
import com.shop.service.ProjectService;

@Controller("projectAction")
@Scope("prototype")
public class ProjectAction extends BaseAction<Project> {

    public String queryAll(){
        //定义easyui的输出json参数
        pageMap = new HashMap<String ,Object>(); 
        
        List<Project> projectList = projectService.queryAll(page, rows);
        pageMap.put("rows", projectList);
        
        Long count = (Long)projectService.getCount();
        pageMap.put("total", count);
        return "jsonMap";
    }
    
    public String deleteBySids(){
        projectService.deleteBySids(sids);
        inputStream = new ByteArrayInputStream("true".getBytes()); //将true字节存到流inputStream中
        return "stream";
    }
    
    public void save() throws Exception {
        //fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
//        String pic = fileUpload.uploadFile(fileImage);
        
//        model.setPic(pic);
//
//        model.setDate(new Date());
        projectService.save(model);
    }
    
    public void update(){
        projectService.update(model);
    }
}
