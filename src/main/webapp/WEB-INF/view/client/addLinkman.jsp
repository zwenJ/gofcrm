<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--新建联系人</title>
</head>
<body>
<br/>
<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 新建联系人</div>
<br/><br/><br/>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="add('点击保存');">保存</button>
</div>
<table class="query_form_table">
    <tr>
        <th>姓名</th>
        <td><input id="lkmName" name="lkmName" value="" /><span class="red_star">*</span></td>
        <th>性别</th>
        <td>
            <input type="radio" name="lkmSex" checked />男
            <input type="radio" name="lkmSex" />女
        </td>
    </tr>
    <tr>
        <th>职位</th>
        <td><input id="lkmPostion" name="lkmPostion" value="" /><span class="red_star">*</span></td>
        <th>办公电话</th>
        <td><input id="lkmTel" name="lkmTel" value="" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>手机</th>
        <td><input id="lkmMobile" name="lkmMobile" value="" /></td>
        <th>备注</th>
        <td><input id="lkmMemo" name="lkmMemo" value="" /></td>
    </tr>
</table>
</body>

</html>
