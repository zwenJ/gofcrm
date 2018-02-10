<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <!-- 数据表格 -->
    <table id="user_table"></table>

    <div id="tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div id="datagrid_search_form">
            编号: <input class="easyui-textbox" type="text" style="width:100px" id="userId" name="userId"/>
            姓名: <input class="easyui-textbox" type="text" style="width:100px" id="userName" name="userName"/>
            职位:
            <input id="user_list_role" name="roleList"
                    panelHeight="auto" style="width:100px" />
            状态：
            <input id="user_flag" name="userFlag"
                   panelHeight="auto" style="width:100px" />
            <a href="javascript:;" id="search_a" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </div>
    </div>
    <script>
        /**
         * 请求后台数据生成数据表格
         */
        $('#user_table').datagrid({
            url:'user/show',
            fitColumns:true,   //表格大小是否适应父容器
            pagination:true,   //是否显示底部分页工具栏
            rownumbers:true,   //是否显示行号
            singleSelect:true, //只允许选中一行
            toolbar: '#tb',    //工具栏
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
                {field:'userRole',title:'职位',width:100}
            ]]
        });

        /**
         * 职位组合框
         */
        $('#user_list_role').combobox({
            url:'role/combo',
            valueField:'id',
            textField:'text',
            limitToList:true,
        });

        /**
         * 状态参数
         */
        $('#user_flag').combobox({
            url: 'common/combo/userFlagCombo.json',
            method: "get",
            valueField: 'id',
            textField: 'text',
            limitToList: true,
        });

        /**
         * 查询按钮点击事件
         */
        $("#search_a").click(function(){
            var user_id = $("#userId").val();
            var user_name = $("#userName").val();
            var user_list_role = $("#user_list_role").val();
            var user_flag = $("#user_flag").val();
            // TODO 通知数据表格进行数据查询
            $('#user_table').datagrid("load",{
                userId: user_id,
                userName: user_name,
                userRole: user_list_role,
                userFlag: user_flag
            });
        });

    </script>
</body>
</html>