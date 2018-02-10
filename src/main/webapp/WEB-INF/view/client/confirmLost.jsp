<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--确认客户流失</title>
</head>
<body>
<br/>
<div class="page_title">客户流失管理 &gt; 确认流失</div>
<br/><br/><br/>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>

    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="to('暂缓流失');">暂缓流失</button>
    <button class="common_button" onclick="save('保存');">保存</button>
</div>
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td></td>
        <th>客户</th>
        <td></td>
    </tr>
    <tr>
        <th>客户经理</th>
        <td></td>
        <th>上次下单时间</th>
        <td></td>
    </tr>
    <tr>
        <th>暂缓措施</th>
        <td colspan="3"></td>
    </tr>
    <tr>
        <th>流失原因</th>
        <td colspan="3">
            <textarea id="lstReason" name="lstReason" rows="6" cols="50"></textarea><span class="red_star">*</span></td>
    </tr>
</table>
<br />
</body>

</html>
