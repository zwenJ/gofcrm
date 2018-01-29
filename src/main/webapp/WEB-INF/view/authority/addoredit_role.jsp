<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/27
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加or修改角色</title>
</head>
<body style="text-align: center; margin: auto">
    <form:form id="add_role_form" action="#" modelAttribute="sysRole">
        <table align="center">
            <tr>
                <td><strong>职位名称：</strong></td>
                <td><form:input path="roleName" class="easyui-textbox" style="width:300px;"/></td>
                <td rowspan="2" style="width: 300px;">
                    <div id="auth_div" class="easyui-panel"
                         data-options="closable:false,noheader:true,fit:true,
                            collapsible:false,minimizable:false,maximizable:false">
                        &nbsp;<strong>该角色的权限配置：</strong><br/>
                        <input id="auth_div_ul" name="authTreeList"/>
                        <script>
                            $(function(){
                                /**
                                 * 此处的一个逻辑是，你只能看到你能够赋予的权限
                                 * 这里使用Tree and combo的EasyUI控件，该控件是 树和下拉框的组合体完全继承自这两个控件
                                 */
                                $("#auth_div_ul").combotree({
                                    url:"auth/tree?apId=1",
                                    width:300,
                                    panelHeight:400,
                                    multiple:true,  //下拉框中定义是否支持多选的属性 true 支持多选
                                    checkbox:true,  //是否在每个节点之前显示复选框 true 显示多选框
                                });
                            });
                        </script>
                    </div>
                </td>
            </tr>
            <tr>
                <td><strong>职位描述：</strong></td>
                <td>
                    <form:textarea path="roleDesc" class="easyui-textbox"
                                   data-options="multiline:true"
                                   style="width:300px;height:400px"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a id="submit_a" href="javascript:form_submit();" class="easyui-linkbutton">提交</a>
                    <a id="reset_a" href="javascript:form_reset();" class="easyui-linkbutton">重置</a>
                </td>
            </tr>
        </table>
    </form:form>
    <script>
        /**
         * 提交表单
         */
        function form_submit(){
            // TODO 提交表单之前进行表达验证
            alert("请求提交表单");
            $('#add_role_form').form('submit', {
                    url:"role/addrole",
                onSubmit: function(param){

                    //这里可以添加额外提交的参数
                    var authTree = $('#auth_div_ul').combotree('tree');	// 获取树对象

                    //如果没有选中的权限，则不能提交
                    var selectAuth = authTree.combotree("getChecked");
                    if (undefined == selectAuth || null == selectAuth || selectAuth.length ==0 )
                    {
                        return false;
                    }

                    // 获取选中部分自权限的父节点
                    var selectAuthTree = authTree.tree('getChecked','indeterminate');
                    /**
                     *  判断是否有不确认的选项，如果有则选中它，进行表单提交
                     */
                    if (undefined != selectAuthTree &&
                        null != selectAuthTree &&
                        selectAuthTree.length > 0)
                    {
                        console.log(selectAuthTree);//控制台打印
                        var parentAuthId = []; //保存父权限的数组
                        //迭代保存父节点编号
                        $.each(selectAuthTree, function (index, value) {
                            parentAuthId.push(value.id);
                        })
                        param.parentAuthIds = parentAuthId;  //将这些不确定的父权限添加到表单中
                    }

                    //表单验证，该方式需要validate控件支持
                    return $("#add_role_form").form("validate");
                },
                success:function(data){
                    //提交成功
                    alert(data);
                }
            });
        }

        /**
         * 重置表单
         */
        function form_reset(){
            // TODO 重置表单进行询问
            if (confirm("确认要重置信息？"))
            {
                $('#add_role_form').form("reset");
            }
        }
    </script>
</body>
</html>
