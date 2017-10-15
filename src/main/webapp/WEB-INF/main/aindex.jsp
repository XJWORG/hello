<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ include file="/public/head.jspf" %>
    <style type="text/css">
        #menu {
            width:100px;
            /*border:1px solid red;*/
        }
        #menu ul {
            list-style: none;
            padding: 0px;
            margin: 0px;
        }
        #menu ul li {
            border-bottom: 1px solid #fff;
            
        }
        #menu ul li a {
            /*先将a标签转换为块级元素，才能设置宽和内间距*/
            display: block;
            background-color: #00a6ac;
            color: #fff;
            padding: 5px;
            text-decoration: none;
        }
        #menu ul li a:hover {
            background-color: #008792;
        }
    </style>
    <script type="text/javascript">
	    $(function(){
	    	$("a[title]").click(function(){
	    		var text = $(this).text();
	    		var href = $(this).attr("title");
	    		//判断右侧是否一打开相应的tab
	    		if($("#tt").tabs("exists",text)){
	    			$("#tt").tabs("select","text");
	    		}else{
	    			alert('<iframe title=' + text + ' src=' + href + ' frameborder="0" width="100%" height="100%" />');
	    			//如果选中的tab未打开，则新创建一个
	    			$("#tt").tabs("add",{
	    				title:text,
	    				closable:true,
	    				content:'<iframe title=' + text + ' src=' + href + ' frameborder="0" width="100%" height="100%" />'
	    				//href:默认通过url地址加载远程页面，但仅仅是body部分
	    				//href:'send_category_query.action'
	    			})
	    		}
	    	})
	    })
    </script>
</head>

    <body class="easyui-layout">
        <div data-options="region:'north',title:'欢迎来到易购后台管理',split:true" style="height:100px;">内容</div>   
        <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
            <!-- 此处显示的是系统菜单 -->
            <div id="menu" class="easyui-accordion" style="width:300px;height:200px;">   
                <div title="基本操作" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;"> 
			       <ul>  
			           <li><a href="#" title="send_category_query.action">类别管理</a>  
			           <li><a href="#">商品管理</a>  
			       </ul>  
                </div>   
                <div title="其他操作">
                   <ul>  
                       <li><a href="#" title="send_category_query.action">类别管理</a>  
                       <li><a href="#">商品管理</a>  
                   </ul> 
                </div>   
            </div>   
        </div>   
        <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
            <div id="tt" class="easyui-tabs" data-options="fit:true">
                <div title="系统缺省页面" sytle="padding:10px;">
                    此处以后显示相应的系统信息
                </div>
            </div>
        </div>   
    </body>  

</html>