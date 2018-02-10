<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/21
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>客户关系管理系统--客户流失管理</title>
</head>
<body>
<br/>
<div class="page_title">客户流失管理</div>
<br/><br/><Br/>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>
    <button class="common_button" onclick="reload();">查询</button>
</div>
<table class="query_form_table">
    <tr>
        <th>客户</th>
        <td><input /></td>
        <th>客户经理</th>
        <td><input /></td>
        <th>状态</th>
        <td>
            <select>
                <option>全部</option>
                <option>预警</option>
                <option>暂缓流失</option>
                <option>确认流失</option>
            </select>
        </td>
    </tr>
</table>
<br />

<table id="dg" title="客户基本信息展示" style="width:100%;height:250px"
       data-options="rownumbers:true,fitColumns:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
    <thead>
    <tr style="background-color: #0000FF; color: #fafafa;">
        <th data-options="field:'lstCustId',width:20,align:'center'">编号</th>
        <th data-options="field:'kehu',width:40,align:'center'">客户</th>
        <th data-options="field:'kehujingli',width:25,align:'center'">客户经理</th>
        <th data-options="field:'lstLastOrderDate',width:80,align:'center'">上次下单时间</th>
        <th data-options="field:'lstLostDate',width:80,align:'center'">确认流失时间</th>
        <th data-options="field:'lstStatus',width:30,align:'center'">状态</th>
        <th data-options="field:'operate',width:40,align:'center'">操作</th>
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
