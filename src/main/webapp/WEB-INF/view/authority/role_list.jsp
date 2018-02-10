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

    <div id="role_list_tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div id="datagrid_search_form">
            编号: <input class="easyui-textbox" type="text" style="width:100px" id="userId" name="roleId"/>
            名称: <input class="easyui-textbox" type="text" style="width:100px" id="userName" name="roleName"/>
            状态：
            <input id="role_flag" name="roleFlag"
                   panelHeight="auto" style="width:100px" />
            <a href="javascript:;" id="role_list_search_a" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </div>
    </div>

    <script>
        $('#role_table').datagrid({
            url:'role/show',
            fitColumns:true,   //表格大小是否适应父容器
            pagination:true,   //是否显示底部分页工具栏
            rownumbers:true,   //是否显示行号
            singleSelect:true, //只允许选中一行
            toolbar: '#role_list_tb',    //工具栏
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
                }}
            ]]
        });

        /**
         * 状态参数
         */
        $('#role_flag').combobox({
            url: 'common/combo/userFlagCombo.json',
            method: "get",
            valueField: 'id',
            textField: 'text',
            limitToList: true,
        });

        /**
         * 查询按钮点击事件
         */
        $("#role_list_search_a").click(function(){
            var role_id = $("#roleId").val();
            var role_name = $("#roleName").val();
            var role_flag = $("#roleFlag").val();
            // TODO 通知数据表格进行数据查询
            $('#role_table').datagrid("load",{
                roleId: role_id,
                roleName: role_name,
                roleFlag: role_flag
            });
        });

    </script>
</body>
</html>
