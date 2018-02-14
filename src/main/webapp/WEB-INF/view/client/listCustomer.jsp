<%--
  客户视图页面
  User: kai
  Date: 2018/1/23
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <!-- 数据表格 -->
    <table id="listcustomer_table" style="width:100%;height:350px"></table>

    <div id="listcustomer_table_tb">
        <!-- CRUD按钮 -->
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
        </div>
        <div id="datagrid_listcustomer_search_form">
            <form id="listcustomer_table_search_form">
                <table class="query_form_table">
                    <tr>
                        <th>客户编号</th>
                        <td><input id="custId" name="custId" /></td>
                        <th>名称</th>
                        <td><input id="custName" name="custName" /></td>
                        <th>地区</th>
                        <td>
                            <select id="custRegion" name="custRegion">
                                <option value="">全部</option>
                                <option value="东北">东北</option>
                                <option value="华北">华北</option>
                                <option value="中南">中南</option>
                                <option value="华南">华南</option>
                                <option value="西部">西部</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>客户经理</th>
                        <td><input id="sysUserName" name="sysUserName" /></td>
                        <th>客户等级</th>
                        <td>
                            <select id="custLevelLabel" name="custLevelLabel">
                                <option value="">全部</option>
                                <option value="普通客户">普通客户</option>
                                <option value="大客户">大客户</option>
                                <option value="合作伙伴">合作伙伴</option>
                                <option value="战略合作伙伴">战略合作伙伴</option>
                            </select>
                        </td>
                        <th>操作</th>
                        <td>
                            <a href="javascript:;" id="user_list_search_a" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                            <a href="javascript:;" id="user_list_search_b" class="easyui-linkbutton" iconCls="icon-search">重置</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <script>
        /**
         * 请求后台数据生成数据表格
         */
        $('#user_table').datagrid({
            url:'customer/listcustomer',
            fitColumns:true,   //表格大小是否适应父容器
            pagination:true,   //是否显示底部分页工具栏
            rownumbers:true,   //是否显示行号
            singleSelect:true, //只允许选中一行
            toolbar: '#listcustomer_table_tb',    //工具栏
            columns:[[
                {field:'custId',title:'客户编号',width:100},
                {field:'custName',title:'客户名称',width:100},
                {field:'custRegion',title:'所在地区',width:100},
                {field:'sysUserName',title:'客户经理',width:100},
                {field:'custLevelLabel',title:'客户等级',width:100}
            ]]
        });


    </script>

<%--<script type="text/javascript">--%>
    <%--function operate(value,row,index){--%>
        <%--var e = '<a href="/gofcrm/customer/loadCustomer?custId='+row.custId+'" title="编辑">'+row.custName+'</a> ';--%>
        <%--var l = '<a href="" title="联系人" onclick="return confirm(\'联系人\')">⊙</a> ';--%>
        <%--var j = '<a href="" title="交往记录" onclick="return confirm(\'交往记录\')">⊙</a> ';--%>
        <%--var h = '<a href="" title="历史订单" onclick="return confirm(\'历史订单\')">⊙</a> ';--%>
        <%--var d = '<a href="" title="客户流失(删除)" onclick="return confirm(\'客户流失(删除)\')">⊙</a> ';--%>
        <%--return e+l+j+h+d;--%>
    <%--}--%>
<%--</script>--%>

</body>
</html>
