<%--
  Created by IntelliJ IDEA.
  User: zwenJs
  Date: 2018/2/24
  Time: 14:55
  To change this template use File | Settings | File Templates.
  说明：添加数据字典条例
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
    <body>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
            <button class="common_button" onclick="submit_form();">保存</button>
        </div>
        <form id="dict_add_form" action="#" method="post">
            <table class="query_form_table">
                <tr>
                    <th>类别</th>
                    <td colspan="4">
                        <input id="dict_type_input" class="easyui-textbox" type="text" style="width:200px" name="dictType"/>
                        <span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）
                    </td>
                </tr>
                <tr>
                    <th>条目</th>
                    <td>
                        <input class="easyui-textbox" type="text" style="width:200px" name="dictItem"/>
                        <span class="red_star">*</span>
                    </td>
                    <th>值</th>
                    <td>
                        <input class="easyui-textbox" type="text" style="width:200px" name="dictValue"/>
                        <span class="red_star">*</span>
                    </td>
                </tr>
                <tr>
                    <th>是否可编辑</th>
                    <td colspan="4"><input type="checkbox" id="dict_is_edit" checked /></td>
                </tr>
            </table>
        </form>
        <script>

            /**
             * 职位组合框
             */
            ComboUtil.showCombobx({
                id:"#dict_type_input",
                url:"dict/getDictTypeList",
            });

            function submit_form() {
                $("#dict_add_form").form('submit', {
                    url: "dict/add",
                    onSubmit: function(parame){
                        //将是否可以修改转换成int类型提交
                        var isOk = $("#dict_is_edit").val();
                        parame.dictIsEditable = isOk=="on"?1:2;

                        //验证提交，如果不通过验证则不会提交
                        return $("#dict_add_form").form("validate");
                    },
                    success:function(_result){
                        //转换成对象
                        _result = eval("("+_result+")");
                        //弹出消息
                        alert(_result.message);

                        if (_result.result) {
                            //添加成功，关闭窗口
                            $('#win_main').window('close');
                        }
                    }
                });
            }
        </script>
    </body>
</html>
