package com.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.model.FileImage;
import com.shop.service.AccountService;
import com.shop.service.CategoryService;
import com.shop.service.FileUpload;
import com.shop.service.ProductService;

@Controller("baseAction")
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ModelDriven<T> {


    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String ,Object> application;
    //page 和rows和分页有关，pageMap存放查询的数据，然后达成json格式使用
    protected Integer page;
    protected String ids;
    protected InputStream inputStream;		
    protected List<T> jsonList = null;

	protected Integer rows;
    protected Map<String ,Object> pageMap = null;
    
    protected T model ;
    @Resource
    protected CategoryService categoryService;
    @Resource
    protected AccountService accountService;
    @Resource
    protected ProductService productService;

    //封装了图片信息的类
    protected FileImage fileImage;
    
    //上传文件工具类
    @Resource
    protected FileUpload fileUpload;

    public FileImage getFileImage() {
        return fileImage;
    }
    public void setFileImage(FileImage fileImage) {
        this.fileImage = fileImage;
    }

    public List<T> getJsonList() {
		return jsonList;
	}

	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
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

	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class)type.getActualTypeArguments()[0];
		try{
			model = (T)clazz.newInstance();
		} catch(Exception e){
			throw new RuntimeException(e);
		}
		
		return model;
	}

}
