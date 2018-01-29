<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table id="user_table"></table>
<script>
    $('#user_table').datagrid({
        url:'user/show',
        fitColumns:true,
        pagination:true,
        columns:[[
            {field:'userId',title:'编号',width:100},
            {field:'userName',title:'姓名',width:100},
            {field:'userFlag',title:'状态',width:100,formatter:function(value, row, index) {
                switch (value) {
                    case 0:
                        return "可用";
                    case 1:
                        return "不可用";
                    default:
                        return "未知";
                }
            }},
            {field:'userAddId',title:'添加人',width:100},
            {field:'userRole',title:'职位',width:100},
            {field:'cz',title:'操作',width:100,align:'right'}
        ]]
    });
</script>
</body>
</html>