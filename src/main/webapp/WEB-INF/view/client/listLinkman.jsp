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
    <title>客户关系管理系统--联系人</title>
</head>
<body>
<br/>
<div class="page_title">客户信息管理 > 客户信息 > 联系人 </div>
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

<table class="easyui-datagrid" title="联系人展示" style="width:100%;height:350px"
       data-options="singleSelect:true,fitColumns:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'lkmName',width:15,align:'center'">姓名</th>
        <th data-options="field:'lkmSex',width:15,align:'center'">性别</th>
        <th data-options="field:'lkmPostion',width:20,align:'center'">职位</th>
        <th data-options="field:'lkmTel',width:22,align:'center'">办公电话</th>
        <th data-options="field:'lkmMobile',width:22,align:'center'">手机</th>
        <th data-options="field:'lkmMemo',width:30,align:'center'">备注</th>
        <th data-options="field:'operate',width:25,align:'center'">操作</th>
    </tr>
    </thead>
</table>

</body>
</html>
