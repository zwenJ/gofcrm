<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--服务归档</title>
</head>
<body>
<br/>
<div class="page_title">客户服务管理 &gt; 服务归档</div>
<br/><br/><br/>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="reload();">查询</button>
</div>
<table class="query_form_table">
    <tr>
        <th height="28">客户</th>
        <td><input /></td>
        <th height="28">概要</th>
        <td><input /></td>
        <th height="28">服务类型</th>
        <td>
            <select name="D1">
                <option>全部</option>
                <option>咨询</option>
                <option>建议</option>
                <option>投诉</option>
            </select>
        </td>
    </tr>
    <tr>
        <th height="32">创建日期</th>
        <td colspan="3">
            <input name="T2" size="10" /> - <input name="T1" size="10" /></td>
        <th height="32">状态</th>
        <td>
            <select name="D1">
                <option>全部</option>
                <option>新创建</option>
                <option>已分配</option>
                <option>已处理</option>
                <option>已反馈</option>
                <option>已归档</option>
            </select>
        </td>
    </tr>
</table>
<br />

<table id="dg" title="客户服务处理展示" style="width:100%;height:250px"
       data-options="rownumbers:true,fitColumns:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
    <thead>
    <tr style="background-color: #0000FF; color: #fafafa;">
        <th data-options="field:'svrId',width:20,align:'center'">服务单编号</th>
        <th data-options="field:'svrCustId',width:30,align:'center'">客户</th>
        <th data-options="field:'svrTitle',width:60,align:'center'">概要</th>
        <th data-options="field:'svrType',width:20,align:'center'">服务类型</th>
        <th data-options="field:'svrCreateId',width:20,align:'center'">创建人</th>
        <th data-options="field:'svrCreateDate',width:40,align:'center'">创建时间</th>
        <th data-options="field:'svrStatus',width:20,align:'center'">状态</th>
        <th data-options="field:'operate',width:25,align:'center'">操作</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    $(function(){
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
        pager.pagination({
            buttons:[{
                iconCls:'icon-search',
                handler:function(){
                    alert('查询');
                }
            },{
                iconCls:'icon-add',
                handler:function(){
                    alert('增加');
                }
            },{
                iconCls:'icon-edit',
                handler:function(){
                    alert('编辑');
                }
            }]
        });
    })
</script>

</body>
</html>
