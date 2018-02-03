<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
                <th>职位</th>
                <td>
                    <select id="custRegion" name="custRegion"
                            class="easyui-combobox" style="width:200px;">
                    </select>
                    <script>
                        $('#custRegion').combobox({
                            url:'role/combo',
                            valueField:'id',
                            textField:'text',
                            limitToList:true,
                        });
                    </script>
                </td>
            </tr>
        </table>
    </div>

    <table id="user_table"></table>

    <script>
        $('#user_table').datagrid({
            url:'user/show',
            fitColumns:true,   //表格大小是否适应父容器
            pagination:true,   //是否显示底部分页工具栏
            rownumbers:true,   //是否显示行号
            singleSelect:true, //只允许选中一行
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
                {field:'cz',title:'操作',width:100,align:'right',formatter:function(value, row, index) {
                    var buttons = "<a id='btn' href='#' class='easyui-linkbutton' data-options=\"iconCls:'icon-edit'\">编辑</a>";
                        buttons += "&nbsp;|&nbsp;";
                        buttons += "<a id='btn' href='#' class='easyui-linkbutton' data-options=\"iconCls:'icon-search'\">其他</a>";
                    return buttons;
                }}
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