<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    <style type="text/css">
        form div {
            margin:5px;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            //iframe中的datagrid对象
            var dg = parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg");
            
            //对商品类的下拉列表框进行远程加载
            $("#cc").combobox({   
                //将请求发送给categoryAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来
                url:'project_queryAll.action',  
                valueField:'sid',    
                textField:'type', //我们下拉列表中显示的是商品的类别名
                panelHeight:'auto', //自适应高度
                panelWidth:120,//下拉列表是两个组件组成的
                width:120, //要同时设置两个宽度才行
                editable:false, //下拉框不允许编辑
              //combobox继承combo继承validatebox，所以可以直接在这里设置验证
                required:true,
                missingMessage:'请选择所属类别'
            });  
            
            // 完成数据的回显，更新时，用户肯定先选择了要更新的那一行，首先我们得拿到那一行
            var rows = dg.datagrid("getSelections");
            //将拿到的那一行对应的数据字段加载到表单里，实现回显
            $("#ff").form('load',{
                sid:rows[0].sid,
                projectname:rows[0].projectname,
                description:rows[0].description,
                active:rows[0].active,
                common:rows[0].common
            });

            //回显完了数据后，设置一下验证功能
            $("input[name=projectname]").validatebox({
                required:true,
                missingMessage:'请输入类别名称'
            }); 
            $("input[name=description]").validatebox({
                required:true,
                missingMessage:'请输入项目描述'
            });

            $("textarea[name=action]").validatebox({
                required:true,
                missingMessage:'项目是否有效'
            });
            
            $("textarea[name=common]").validatebox({
                required:false,
                missingMessage:'请输入项目备注'
            });
            //窗体弹出默认时禁用验证
            $("#ff").form("disableValidation");
            //注册button的事件
            $("#btn").click(function(){
                //开启验证
                $("#ff").form("enableValidation");
                //如果验证成功，则提交数据
                if($("#ff").form("validate")) {
                    //调用submit方法提交数据
                    $("#ff").form('submit', {
                        url: 'project_update.action', //提交时将请求传给productAction的update方法执行
                        success: function(){
                            //如果成功了，关闭当前窗口，并刷新页面
                            parent.$("#win").window("close");
                            dg.datagrid("reload");
                        }
                    });
                }
            });
        });
    </script>
  </head>
  
  <body>
    <form title="更新项目" id="ff" method="post" enctype="multipart/form-data">
        <div>   
            <label for="projectname">项目名称:</label> <input type="text" name="projectname" />   
        </div>   
        <div>
            <label for="description">项目描述:</label> <input type="text" name="description" />
        </div>
        <div>
            <label for="open">有效项目:</label>
            是:<input type="radio" name="active" value="true" />
            否:<input type="radio" name="active" value="false" />
                    
        </div>
        <div>
            <label for="common">备注:</label>
            <textarea name="common" cols="40" rows="8"></textarea>
        </div>
        
        <div>
            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>  
            <input type="hidden" name="sid" />
        </div>  `
    </form>     
  </body>
</html>