package com.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import com.shop.utils.ProductTimerTask;

public class InitDataListener implements ServletContextListener {
	
//	private ProductService productService = null;
//	private CategoryService categoryService = null;
	private ApplicationContext context = null;
	private ProductTimerTask productTimerTask = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {

		// 解决方案一，可以加载productService，但是Spring把所有的service都实例化了2次，因为这里又加载了一次。不可取。
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		productService = (ProductService) context.getBean("productService");
//		System.out.println(productService);
//		
		// 解决方案二，项目在启动时，把Spring配置文件通过Spring的监听器加载，存储到ServletContext中，我们只要在ServletContext中获取即可。
		// 此方案的key比较长，不容易记住
//		ApplicationContext context = (ApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService = (ProductService) context.getBean("productService");
//		System.out.println(productService);
		
		// 解决方案三，通过工具类加载即可
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());				
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");//
		//把内置对象交给productTimerTask
		productTimerTask.setApplication(event.getServletContext());
		//通过设置定时器，让首页的数据每个一小时同步一次（配置为守护线程）
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);//每个一小时执行一次productTimerTask
//		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
//		categoryService = (CategoryService)context.getBean("categoryService");//加载类别信息
//		productService = (ProductService)context.getBean("productSerivce");//加载商品
//		
//		List<List<Product>> bigList = new ArrayList<List<Product>>();
//		
//		for(Category category : categoryService.queryByHot(true)){
//			//根据热点类别id获取推荐商品信息
//			List<Product> lst = productService.queryByCategoryId(category.getId());
//			bigList.add(lst);
//			
//			event.getServletContext().setAttribute("bigList", bigList);
//		}
	}

}
