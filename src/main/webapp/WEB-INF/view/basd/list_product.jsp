<%--
  产品信息 视图
  User: jzw
  Date: 18-2-15
  Time: 下午12:57
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
    <table id="product_table"></table>

    <div id="product_table_tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div id="datagrid_product_search_form">
            <form id="product_table_search_form">
                名称: <input class="easyui-textbox" type="text" style="width:100px" id="prod_name" name="prodName"/>
                型号: <input class="easyui-textbox" type="text" style="width:100px" id="prod_type" name="prodType"/>
                批次: <input class="easyui-textbox" type="text" style="width:100px" id="prod_batch" name="prodBatch"/>
                <a href="javascript:;" id="product_list_search_a" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                <a href="javascript:;" id="product_list_search_b" class="easyui-linkbutton" iconCls="icon-search">重置</a>
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
            id:"#product_table",
            url:"product/show",
            toolbar:"#product_table_tb",
        },[[
            {field:'prodId',title:'编号',width:100},
            {field:'prodName',title:'名称',width:100},
            {field:'prodType',title:'型号',width:100},
            {field:'prodBatch',title:'等级/批次',width:100},
            {field:'prodUnit',title:'单位',width:100},
            {field:'prodPrice',title:'单价（元）',width:100},
            {field:'prodMemo',title:'备注',width:100}
        ]]);


        /**
         * 查询按钮点击事件
         */
        $("#product_list_search_a").click(function(){
            var prod_name = $("#prod_name").val();
            var prod_type = $("#prod_type").val();
            var prod_batch = $("#prod_batch").val();
            // TODO 通知数据表格进行数据查询
            $('#product_table').datagrid("load",{
                prodName: prod_name,
                prodType: prod_type,
                prodBatch: prod_batch
            });
        });

        /**
         * 重置表单按钮
         */
        $("#product_list_search_b").click(function(){
            $("#product_table_search_form").form("reset");
            $('#product_table').datagrid('load',{
                prodName: '',
                prodType: '',
                prodBatch: ''
            });
        });

    </script>

</body>
</html>
