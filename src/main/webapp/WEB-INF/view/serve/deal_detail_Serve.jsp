<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--服务处理</title>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="save('feedback.html');">保存</button>
</div>
<table class="query_form_table">
    <tr>
        <th>编号</th>
        <td></td>
        <th>服务类型</th>
        <td></td>
    </tr>
    <tr>
        <th>概要</th>
        <td colspan="3"></td>
    </tr>
    <tr>
        <th>客户</th>
        <td></td>
        <th>状态</th>
        <td>已分配</td>
    </tr>
    <tr>
        <th>服务请求</th>
        <td colspan="3"><br>
            　</td>
    </tr>
    <tr>
        <th>创建人</th>
        <td></td>
        <th>创建时间</th>
        <td></td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table3">
    <tr>
        <th>分配给</th>
        <td></td>
        <th>分配时间</th>
        <td></td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table1">
    <tr>
        <th>服务处理</th>
        <td colspan="3"><textarea id="svrResult" name="svrResult" rows="6" cols="50"></textarea><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>处理人</th>
        <td><input id="svrDealId" name="svrDealId" value="" readonly size="20" /><span class="red_star">*</span></td>
        <th>处理时间</th>
        <td><input id="svrDealDate" name="svrDealDate" readonly size="20" /><span class="red_star">*</span></td>
    </tr>
</table>
<br />
<table disabled class="query_form_table" id="table2">
    <tr>
        <th>处理结果</th>
        <td><input id="svrResult" name="svrResult" size="20" /><span class="red_star">*</span></td>
        <th>满意度</th>
        <td>
            <select name="svrSatisfy">
                <option disabled>请选择...</option>
                <option>☆☆☆☆☆</option>
                <option>☆☆☆☆</option>
                <option>☆☆☆</option>
                <option>☆☆</option>
                <option>☆</option>
            </select><span class="red_star">*</span></td>
    </tr>
</table>
<%--<script>--%>
    <%--setCurTime('t3');--%>
<%--</script>--%>

</body>
</html>
