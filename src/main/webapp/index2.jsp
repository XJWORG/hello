<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %> 
  </head>
  
  <body> 
    <!-- 下面两种写法都可以访问 -->
        <span></span>
        <a href="${pageContext.request.contextPath }/category_update.action?category.id=1&category.type=gga&category.hot=false">访问update</a><br/>  
        <a href="${pageContext.request.contextPath }/category_update.action?id=1&type=gga&hot=false">访问update-modeldriven</a><br/>  
        <a href="category_save.action">访问save</a><br/>  
       <a href="category_save.action?id=4&type=haha&hot=true">测试ModelDriven</a>  <br/>  
       <a href="send_main_aindex.action">测试到后台</a> <br />
       <a href="category_query.action">查询所有类别</a><br/>  
       <c:forEach items="${requestScope.categoryList }" var="category">  
            ${category.id } | ${category.type } | ${category.hot } <br/>  
       </c:forEach>  
         
       <c:forEach items="${sessionScope.categoryList }" var="category">  
           ${category.id } | ${category.type } | ${category.hot } <br/>  
       </c:forEach>  
         
       <c:forEach items="${applicationScope.categoryList }" var="category">  
           ${category.id } | ${category.type } | ${category.hot } <br/>  
       </c:forEach>  
        
  </body>
</html>