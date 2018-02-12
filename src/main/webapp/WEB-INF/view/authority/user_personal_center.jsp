<%--
  Created by IntelliJ IDEA.
  User: jzw
  Date: 18-2-12
  Time: 下午1:29
  系统用户个人中心
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
    <table id="user_personal_center_table">
        <tr>
            <td>用户头像</td>
            <td></td>
        </tr>
        <tr>
            <td><strong>用户编号：</strong></td>
            <td><input class="easyui-textbox" type="text" disabled="disabled"
                       style="width:200px" id="user_id" name="userId" value=""/></td>
        </tr>
        <tr>
            <td><strong>用户名：</strong></td>
            <td><input class="easyui-textbox" type="text" disabled="disabled"
                       style="width:200px" id="user_name" name="userName" value=""/></td>
        </tr>
        <tr>
            <td><strong>用户职位：</strong></td>
            <td><input class="easyui-textbox" type="text" disabled="disabled"
                       style="width:200px" id="user_role" name="userRole" value=""/></td>
        </tr>
        <tr style="height: auto" hidden="hidden">
            <td>
                <strong>用户密码：</strong>
                <br/>
                <br/>
                <br/>
            </td>
            <td>
                <table>
                    <tr>
                        <td style="text-align: right">原密码：</td>
                        <td><input class="easyui-textbox" type="password" disabled="disabled"
                                   style="width:200px" id="user_password_old" name="userPwdOld" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">新密码：</td>
                        <td><input class="easyui-textbox" type="password" disabled="disabled"
                                   style="width:200px" id="user_password_new" name="userPwd" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">确认新密码：</td>
                        <td><input class="easyui-textbox" type="password" disabled="disabled"
                                   style="width:200px" id="user_password_new_confirm"
                                   name="userPwdConfirm" value=""/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><stron>操作：</stron></td>
            <td>
                <a href="javascript:;" id="user_personal_center_a" class="easyui-linkbutton">修改信息</a>
                <a href="javascript:;" id="user_personal_center_b" class="easyui-linkbutton">保存修改</a>
            </td>
        </tr>
    </table>
</body>
</html>
