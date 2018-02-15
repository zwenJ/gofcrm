<%--
  Created by IntelliJ IDEA.
  User: jzw
  Date: 18-2-15
  Time: 下午4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <!-- 数据表格 -->
    <table id="dict_table"></table>

    <div id="dict_table_tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div id="datagrid_dict_search_form">
            <form id="dict_table_search_form">
                类别: <input class="easyui-textbox" type="text" style="width:100px" id="dict_type" name="dictType"/>
                条目: <input class="easyui-textbox" type="text" style="width:100px" id="dict_item" name="dictItem"/>
                值:<input class="easyui-textbox" type="text" style="width:100px" id="dict_value" name="dictValue"/>
                <a href="javascript:;" id="dict_list_search_a" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                <a href="javascript:;" id="dict_list_search_b" class="easyui-linkbutton" iconCls="icon-search">重置</a>
            </form>
        </div>
    </div>
    <script>
        /**
         * 请求后台数据生成数据表格
         * @param config     基础配置参数
         * @param columns[]  列定义
         */
        DatagridUtil.showDefaultDatagrid({
            id:"#dict_table",
            url:"dict/show",
            toolbar:"#dict_table_tb",
        },[[
            {field:'dictId',title:'编号',width:100},
            {field:'dictType',title:'类别',width:100},
            {field:'dictItem',title:'条目',width:100},
            {field:'dictValue',title:'值',width:100},
            {field:'dictIsEditable',title:'是否可编辑',width:100,formatter:function(value, row, index) {
                    switch (value) {
                        case 1:
                            return "可编辑";
                        default:
                            return "不可编辑";
                    }
                }},
        ]]);


        /**
         * 查询按钮点击事件
         */
        $("#dict_list_search_a").click(function(){
            var dict_type = $("#dict_type").val();
            var dict_item = $("#dict_item").val();
            var dict_value = $("#dict_value").val();
            // TODO 通知数据表格进行数据查询
            $('#dict_table').datagrid("load",{
                dictType: dict_type,
                dictItem: dict_item,
                dictValue: dict_value,
            });
        });

        /**
         * 重置表单按钮
         */
        $("#dict_list_search_b").click(function(){
            $("#dict_table_search_form").form("reset");
            $('#dict_table').datagrid('load',{
                dictType: '',
                dictItem: '',
                dictValue: '',
            });
        });
    </script>
</body>
</html>
