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
        ]]
    });
</script>
</body>
</html>
