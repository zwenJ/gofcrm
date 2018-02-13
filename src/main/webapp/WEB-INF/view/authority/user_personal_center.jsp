<%--
  Created by IntelliJ IDEA.
  User: jzw
  Date: 18-2-12
  Time: 下午1:29
  系统用户个人中心
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
    <table id="user_personal_center_table">
        <%--<tr>
            <td>用户头像</td>
            <td></td>
        </tr>--%>
        <tr>
            <td><strong>用户编号：</strong></td>
            <td><input class="easyui-textbox" type="text" disabled="disabled"
                       style="width:200px" id="user_personal_user_id" name="userId" value="${SysUser.userId}"/></td>
        </tr>
        <tr>
            <td><strong>用户名：</strong></td>
            <td><input class="easyui-textbox" type="text" disabled="disabled"
                       style="width:200px" id="user_personal_user_name" name="userName" value="${SysUser.userName}"/></td>
        </tr>
        <tr>
            <td><strong>用户职位：</strong></td>
            <td><input class="easyui-textbox" type="text" disabled="disabled"
                       style="width:200px" id="user_personal_user_role" name="userRole" value="${SysUser.userRole}"/></td>
        </tr>
        <tr id="_user_passwd_tr" style="height: auto" hidden="hidden">
            <td>
                <strong>用户密码：</strong>
                <br/>
                <br/>
                <br/>
            </td>
            <td>
                <form id="user_personal_center_form" method="post">
                    <table>
                        <tr>
                            <td style="text-align: right">原密码：</td>
                            <td><input class="easyui-validatebox" type="password"
                                       style="width:200px" id="user_password_old"  name="userPwdOld"
                                       data-options="required:true,validType:'userPwd[1]'"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right">新密码：</td>
                            <td><input class="easyui-validatebox" type="password"
                                       style="width:200px" id="user_password_new" name="userPwd"
                                       data-options="required:true,validType:'userPwd[2]'"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right">确认新密码：</td>
                            <td><input class="easyui-validatebox" type="password"
                                       style="width:200px" id="user_password_new_confirm"
                                       name="userPwdConfirm" data-options="required:true,validType:'userPwd[3]'"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
        <tr>
            <td><stron>操作：</stron></td>
            <td id="button_td">
                <a href="javascript:;" id="user_personal_center_a" class="easyui-linkbutton">修改密码</a>
                <a href="javascript:;" id="user_personal_center_b" class="easyui-linkbutton">保存修改</a>
                <a href="javascript:;" id="user_personal_center_c" class="easyui-linkbutton">取消修改</a>
            </td>
        </tr>
    </table>
    <script>
        $(function(){
            _base_hide();
        });
        /**
         * 修改信息按钮点击事件绑定
         *
         */
        $("#user_personal_center_a").click(function(){
            _base_show();
        });

        /**
         * 保存修改按钮点击事件绑定
         */
        $("#user_personal_center_b").click(function(){
            $("#user_personal_center_form").form("submit",{
                url:"user/update",
                onSubmit:function(parame){
                    //额外提交的必须参数
                    parame.userId = $("#user_personal_user_id").val();
                    //使用EasyUI内置的表单验证
                    return $("#user_personal_center_form").form("validate");
                },
                success:function (_result) {
                    var _result = eval("("+_result+")");
                    console.log(_result);

                    alert(_result.message);
                    if (true == _result.result) {
                        _base_hide();

                        /**
                         * 用于判断用户是否已经登陆
                         */
                        $.post("to/isLogin",{
                            id:1
                        },function(data){
                            //如果没有登陆则，给你重定向到index.html页面
                            if ("error" == data.trim()) {
                                location.href = "html/index.html";
                            }
                        });
                    }
                }
            });
        });

        /**
         * 取消修改按钮点击事件绑定
         */
        $("#user_personal_center_c").click(function(){
            //重置表单
            $("#user_personal_center_form").form("reset");
            //影藏表单
            _base_hide();
        });

        /**
         * 影藏
         * @private
         */
        function _base_hide(){
            $("#_user_passwd_tr").hide();
            $("#user_personal_center_b").hide();
        }

        /**
         * 显示
         * @private
         */
        function _base_show(){
            $("#_user_passwd_tr").show();
            $("#user_personal_center_b").show();
        }

    </script>
</body>
</html>
