<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--编辑交往记录</title>
</head>
<body>
<br/>
<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 编辑交往记录</div>
<br/><br/><br/>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back('删除客户信息');">返回</button>
    <button class="common_button" onclick="add('更改成功');">保存</button>
</div>

<table class="query_form_table">
    <tr>
        <th>时间</th>
        <td><input id="atvDate" name="atvDate" value="" /><span class="red_star">*</span></td>
        <th>地点</th>
        <td>
            <input id="atvPlace" name="atvPlace" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>概要</th>
        <td><input id="atvTitle" name="atvTitle" /><span class="red_star">*</span></td>
        <th>备注</th>
        <td><input id="atvRemark" name="atvRemark" /></td>
    </tr>
    <tr>
        <th>详细信息</th>
        <td colspan="3">
            <textarea id="atvDesc" name="atvDesc" cols="50" rows="6"> </textarea>
        </td>
    </tr>
</table>
</body>

</html>
