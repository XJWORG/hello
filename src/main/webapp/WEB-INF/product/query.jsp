<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    
    <style type="text/css">
        body {
            margin: 1px;
        }
        
        .searchbox{
            marigin: -3px;
        }
    </style>
    
    <script type="text/javascript">
        $(function(){
            $('#dg').datagrid({   
                //请求数据的url地址，后面会改成请求我们自己的url
                //url:'datagrid_data.json',
                url:'product_queryJoinCategory.action',
                loadMsg:'Loading......',
                queryParams:{name:''},//参数
                //width:300,
                fitColumns:true,//水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置
                //显示斑马线
                striped:true,
                //当数据多的时候不换行
                nowrap:true,
                singleSelect: false, //如果为真，只允许单行显示，全显功能失效
                //设置分页
                pagination:true,
                //设置每页显示记录数
                pageSize:5,
                //设置可选显示记录数
                pageList:[5,10,15,20],
                //指定标识字段，在删除，更新时使用。如果配置此字段，翻页、换页时不会影响选中打的项
                idField:'id',
                //添加删除按钮-本次重点
                toolbar: [{
                	iconCls: 'icon-add',
                	text: '添加商品',
                	handler: function(){
                		parent.$("#win").window({ //因为win是在query的父页面中，所以这里要先调parent定位到aindex页面
                			title: "添加商品",
                			width: 350,
                			heiht: 150,
                			content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height="100%" />'
                		});
                	}
                } , '-' , {
                	iconCls: "icon-edit",
                	text: "更新类别",
                	handler: function(){
                		//判断是否有选中行记录，使用getSelections获取选中的所有行
                		var rows = $("#dg").datagrid("getSelections");
                		if(rows.length==0){
                			$.messager.show({//语法类似于java中的静态方法，直接对象调用
                				title: '错误提示',
                				msg: '至少要选择一条记录',
                				timeout: 2000,
                				showType: 'slide',
                			});
                		} else if(rows.length!=1){
                			//弹出提示信息
                			$.messager.show({
                				title: '错误提示',
                				msg: '每次只能更新一条记录',
                				timeout: 2000,
                				showType: 'slide',
                			});
                		} else {
                			//1.弹出更新的弹框
                			parent.$('#win').window({
                				title: '更新类别',
                				width: 350 ,
                				height: 250,
                				content: '<iframe src="send_category_update.action" frameborder="0" width="100%" height="100%" />',
                			});
                		}
                	}
                } ,'-' , {
                	iconCls: 'icon-remove',
                	text: '删除商品',
                	handler: function(){
                		//判断是否有选中行，使用getSelections获知选中行
                		var rows = $('#dg').datagrid('getSelections');
                		if(rows.length==0){
                			$.messager.show({
                				title: '错误提示',
                				msg: '至少应包含一条记录',
                				timeout: 2000,
                				showType: 'slide',
                			});
                		} else {
                			$.messager.confirm('删除确认','您确定要删除吗？', function(r){
                				if(r){
                					//1.从获取的记录中获取响应的id，拼接id的值，然后发送给后台
                					var ids = '';
                					for(var i=0;i<rows.length;i++){
                						ids += rows[i].id +",";
                					}
                					ids = ids.substr(0,ids.lastIndexOf(','));
                					//2,发送ajax请求
                					$.post('product_deleteByIds.action', {ids:ids}, function(result){
                						if(result == "true"){
                							$('#dg').datagrid("uncheckAll");
                							$('#dg').datagrid('reload');
                						} else {
                							$.messager.show({
                								title: '删除异常',
                								msg: '删除失败，请检查操作',
                								timeout: 2000 , 
                								showType: 'slide',
                							});
                						}
                					},"text" );
                			
                				}
                			});
                		}
                	}
                } ,'-' ,{
                	text: '<input id="ss" name="search" />'
                }],
                
                
                rowStyler: function(index,row){
                    console.info("index" + index + "," + row)
                    if(index % 2 == 0) {
                        return 'background-color:#fff;';
                    } else {
                        return 'background-color:#ff0;';
                    }
                    
                },
                //同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
                frozenColumns:[[
                    {field:'checkbox',checkbox:true},
                    {field:'id',title:'编号',width:200}                 
                ]],
                //配置datagrid的列字段 
                //field：列字段的名称，与json的key捆绑
                //title：列标题，是显示给人看的
                columns:[[                     
                    {field:'name',title:'商品名称',width:100,
                        //用来格式化当前列的值，返回的是最终的数据
                        formatter: function(value,row,index){
                            return "<span title=" +　value + ">" + value + "</span>";
	                    }
	                },    
                    {field:'price',title:'价格',width:100,
	                	formatter: function(value,row,index){
	                        return "<span title=" +　value + ">" + value + "</span>";
                    }
                    },
                    {field:'remark',title:'商品说明',width:200,
                    	formatter: function(value,row,index){
                            return "<span title=" + value + ">" + value + "</span>";
                        }
                    }
                ]]    
            }); 
            $('#ss').searchbox({
                //触发事件查询
                searcher: function(value, name){
                    $('#dg').datagrid('load', { //参数name指定为用户输入的value
                        name: value
                    });
                },
                prompt: '请输入搜索关键字'
            });
        });
    </script>
  </head>
  
  <body>
    <table id="dg"></table>
  </body>
</html>