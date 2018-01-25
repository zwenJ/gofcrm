<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--交往记录</title>
</head>
<body>
<br/>
<div class="page_title">客户信息管理 > 客户信息 > 交往记录 </div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="to('linkman_add.html');">新建</button>
    <button class="common_button" onclick="back('返回客户信息');">返回</button>
</div>
<table class="query_form_table">
    <tr>
        <th>客户编号</th>
        <td>KH071202001</td>
        <th>客户名称</th>
        <td>凯总信息科技有限公司</td>
    </tr>
</table>
<br />

<table class="easyui-datagrid" title="交往记录展示" style="width:100%;height:350px"
       data-options="singleSelect:true,fitColumns:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'atvDate',width:30,align:'center'">时间</th>
        <th data-options="field:'atvPlace',width:20,align:'center'">地点</th>
        <th data-options="field:'atvTitle',width:50,align:'center'">概要</th>
        <th data-options="field:'atvDesc',width:30,align:'center'">详细信息</th>
        <th data-options="field:'atvRemark',width:50,align:'center'">备注</th>
        <th data-options="field:'operate',width:25,align:'center'">操作</th>
    </tr>
    </thead>
</table>

</body>
</html>
