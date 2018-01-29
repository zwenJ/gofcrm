<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/23
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>

</head>
<body>
<table id="ta" class="easyui-datagrid" style="width:100%;height:350px"
       data-options="url:'/gofcrm/customer/listcustomer',
                         fitColumns:true,
                         singleSelect:true,
                         fitColumns:true,
                         toolbar:'#tb',
                         pagination:true">

    <thead>
    <tr>
        <th data-options="field:'custId',width:100,align:'center'">客户编号</th>
        <th data-options="field:'custName',width:140,align:'center'">客户名称</th>
        <th data-options="field:'custRegion',width:60,align:'center'">所在地区</th>
        <th data-options="field:'sysUserName',width:60,align:'center'">客户经理</th>
        <th data-options="field:'custLevelLabel',width:100,align:'center'">客户等级</th>
        <th data-options="field:'_operate',width:100,align:'center',formatter:operate">操作</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <div class="button_bar">
        <button class="common_button" onclick="fun_jljl()">帮助</button>
        <button class="common_button" onclick="doSearch()">查询</button>
    </div>
    <script>
        //客户信息模糊查询
        function doSearch() {
            $('#ta').datagrid('load',{
                custId: $('#custId').val(),
                custName: $('#custName').val(),
                custRegion: $('#custRegion').val(),
                sysUserName: $('#sysUserName').val(),
                custLevelLabel: $('#custLevelLabel').val()
            });
        }
        function fun_jljl(){
            var tab = $('#sys_tab').tabs('getSelected');
            // 获取选择的面板
            tab.panel('refresh', 'to/view/client/listActivity');
        }
    </script>
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
            <th>　</th>
            <td>　</td>
        </tr>
    </table>
</div>

<script type="text/javascript">
    function operate(value,row,index){
        var e = '<a href="/gofcrm/customer/loadCustomer?custId='+row.custId+'" title="编辑">'+row.custName+'</a> ';
        var l = '<a href="" title="联系人" onclick="return confirm(\'联系人\')">⊙</a> ';
        var j = '<a href="" title="交往记录" onclick="return confirm(\'交往记录\')">⊙</a> ';
        var h = '<a href="" title="历史订单" onclick="return confirm(\'历史订单\')">⊙</a> ';
        var d = '<a href="" title="客户流失(删除)" onclick="return confirm(\'客户流失(删除)\')">⊙</a> ';
        return e+l+j+h+d;
    }
</script>

<script type="text/javascript" src="mylib/js/common.js"></script>

</body>
</html>
