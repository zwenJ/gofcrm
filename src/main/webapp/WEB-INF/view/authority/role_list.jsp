<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/27
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职位-角色</title>
</head>
<body>

<div id="tb">
    <table class="query_form_table">
        <tr>
            <th>编号</th>
            <td>
                <input class="easyui-textbox" id="custId" name="custId" />
            </td>
            <th>名称</th>
            <td>
                <input class="easyui-textbox" id="custName" name="custName"/>
            </td>
            <th>是否可用</th>
            <td>
                <select id="custRegion" name="custRegion"
                        class="easyui-combobox" style="width:200px;">
                    <option value="">全部</option>
                    <option value="0">可用</option>
                    <option value="1">不可用</option>
                </select>
            </td>
        </tr>
    </table>
</div>

<table id="role_table"></table>
<script>
    $('#role_table').datagrid({
        url:'role/show',
        fitColumns:true,   //表格大小是否适应父容器
        pagination:true,   //是否显示底部分页工具栏
        rownumbers:true,   //是否显示行号
        singleSelect:true, //只允许选中一行
        columns:[[
            {field:'roleId',title:'编号',width:100},
            {field:'roleName',title:'名称',width:100},
            {field:'roleDesc',title:'描述',width:100},
            {field:'roleFlag',title:'状态',width:100,formatter:function(value, row, index){
                switch (value) {
                    case 0:
                        return "可用";
                    case 1:
                        return "不可用";
                    default:
                        return "未知";
                }
            }},
            {field:'cz',title:'操作',width:100,align:'right'}
        ]],
        toolbar: [{
            iconCls: 'icon-search',
            handler: function(){alert('查询按钮')}
        },'-',{
            iconCls: 'icon-help',
            handler: function(){alert('帮助按钮')}
        }]
    });
</script>
</body>
</html>
