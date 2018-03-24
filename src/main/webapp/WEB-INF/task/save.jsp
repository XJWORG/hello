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

            //回显完了数据后，设置一下验证功能
            $("input[name=pId]").validatebox({
                required:false,
                missingMessage:'请输入父项目ID'
            }); 
            //回显完了数据后，设置一下验证功能
            $("input[name=taskType]").validatebox({
                required:true,
                missingMessage:'任务类型'
            }); 
            $("input[name=taskName]").validatebox({
                required:true,
                missingMessage:'请输入任务名称'
            });

            $("input[name=context]").validatebox({
                required:false,
                missingMessage:'请输入任务详情'
            });
            $("input[name=importantLevel]").validatebox({
                required:true,
                missingMessage:'优先级'
            });
            $("input[name=kpiType]").validatebox({
                required:true,
                missingMessage:'kpi类型依据'
            });
            $("input[name=hardLevel]").validatebox({
                required:true,
                missingMessage:'难度系数'
            });
            $("textarea[name=action]").validatebox({
                required:true,
                missingMessage:'任务是否有效'
            });
            
            $("textarea[name=common]").validatebox({
                required:false,
                missingMessage:'请输入备注'
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
                        url: 'task_save.action',
                        success: function(){
                            //如果成功了，关闭当前窗口
                            parent.$("#win").window("close");
                            parent.$("iframe[title='任务管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
            <label for="pId">父任务Id:</label> <input type="text" name="pId" />   
        </div>   
        <div>   
            <label for="taskType">关联项目:</label> <input type="text" name="taskType" />   
        </div>   
        <div>   
            <label for="taskName">任务名称:</label> <input type="text" name="taskName" />   
        </div>   
        <div>   
            <label for="context">任务详述:</label> <input type="text" name="context" />   
        </div>   
        <div>   
            <label for="importantLevel">优先级:</label> <input type="text" name="importantLevel" />   
        </div>   
        <div>   
            <label for="kpiType">评估方式:</label> <input type="text" name="kpiType" />   
        </div>   
        <div>   
            <label for="hardLevel">难度系数:</label> <input type="text" name="hardLevel" />   
        </div>   
        <div>   
            <label for="active">有效:</label> 
                                                  是:<input type="radio" name="active" value="true" />
                                                  否:<input type="radio" name="active" value="false" />
                    
        </div>   
        <div>   
            <label for="common">备注:</label> <input type="text" name="common" />   
        </div>   
        
        <div>
            <a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
            <a id="reset" href="#" class="easyui-linkbutton">重 置</a>
        </div>
      </form>   
  </body>
</html>