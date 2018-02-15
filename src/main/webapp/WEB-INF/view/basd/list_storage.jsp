<%--
  库存信息（仓库） 视图
  User: jzw
  Date: 18-2-15
  Time: 下午13:57
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
    <table id="storage_table"></table>

    <div id="storage_table_tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div id="datagrid_storage_search_form">
            <form id="storage_table_search_form">
                产品: <input class="easyui-textbox" type="text" style="width:100px" id="stk_prod_id" name="stkProdId"/>
                仓库: <input class="easyui-textbox" type="text" style="width:100px" id="stk_warehouse" name="stkWarehouse"/>
                <a href="javascript:;" id="storage_list_search_a" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                <a href="javascript:;" id="storage_list_search_b" class="easyui-linkbutton" iconCls="icon-search">重置</a>
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
            id:"#storage_table",
            url:"storage/show",
            toolbar:"#storage_table_tb",
        },[[
            {field:'stkId',title:'序号',width:100},
            {field:'stkProdId',title:'产品',width:100},
            {field:'stkWarehouse',title:'仓库',width:100},
            {field:'stkWare',title:'货位',width:100},
            {field:'stkCount',title:'件数',width:100},
            {field:'stkMemo',title:'备注',width:100},
        ]]);


        /**
         * 查询按钮点击事件
         */
        $("#storage_list_search_a").click(function(){
            var stk_prod_id = $("#stk_prod_id").val();
            var stk_warehouse = $("#stk_warehouse").val();
            // TODO 通知数据表格进行数据查询
            $('#storage_table').datagrid("load",{
                stkProdId: stk_prod_id,
                stkWarehouse: stk_warehouse,
            });
        });

        /**
         * 重置表单按钮
         */
        $("#storage_list_search_b").click(function(){
            $("#storage_table_search_form").form("reset");
            $('#storage_table').datagrid('load',{
                stkProdId: '',
                stkWarehouse: ''
            });
        });

    </script>

</body>
</html>
