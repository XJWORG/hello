<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    <style type="text/css">
        form div {
            margin:10px;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            //自定义验证方法向validatebox.defaults.rules中注册新函数
            $.extend($.fn.validatebox.defaults.rules,{
                //函数的名称：{函数的实现体(又是一个json对象，里面包括函数的实现，和错误消息的设置)} 
                format:{
                    //函数实现，如果返回为false，则验证失败
                    validator: function(value,param){
                        //获取当前文件的后缀名
                        var ext = value.substring(value.lastIndexOf('.') + 1);
                        //获取支持的文件后缀名，然后比较即可
                        var arr = param[0].split(",");
                        for(var i = 0; i < arr.length; i++) {
                            if(ext == arr[i])
                                return true;
                        }
                        return false;
                    },
                    //错误消息
                    message: '文件后缀必须为:{0}'
                }
            });
                
            $("input[name=projectname]").validatebox({
                required:true,
                missingMessage:'请输入项目名称'
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
            $("#submit").click(function(){
                //开启验证
                $("#ff").form("enableValidation");
                //如果验证成功，则提交数据
                if($("#ff").form("validate")) {
                    //调用submit方法提交数据
                    $("#ff").form('submit', {
                        url: 'project_save.action',
                        success: function(){
                            //如果成功了，关闭当前窗口
                            parent.$("#win").window("close");
                            parent.$("iframe[title='项目管理']").get(0).contentWindow.$("#dg").datagrid("reload");
                        }
                    });
                }
            });
            
            //注册button的事件
            $("#reset").click(function(){
                $("#ff").form("disableValidation");//重置不需要表单验证
                //重置当前表单数据
                $("#ff").form("reset");
            });
        });
    </script>
  </head>
  
  <body>
      <form title="添加项目" id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label>项目名称:</label> <input type="text" name="projectname" />
        </div>

        <div>
            <label>项目描述:</label> <input type="text" name="description" />
        </div>
  
        <div>
            <label>是否有效:</label>
            是:<input type="radio" name="active" checked="checked"value="true" />
            否:<input type="radio" name="active" value="false" />
                    
        </div>
         
     
        <div>
            <label>备注:</label>
            <textarea name="common" cols="40" rows="8"></textarea>
        </div>
        <div>
            <a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
            <a id="reset" href="#" class="easyui-linkbutton">重 置</a>
        </div>
      </form>   
  </body>
</html>