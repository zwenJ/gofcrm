<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/1/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <base href="<%@include file="../../../common/basehead.jsp"%>"/>
    <title>客户关系管理系统--编辑客户信息</title>
</head>
<body>
<br/>
<form:form modelAttribute="customer" action="" method="post">
    <div class="button_bar">
        <button class="common_button" onclick="help('客户关系管理系统');">帮助</button>
        <button class="common_button" onclick="back();">返回</button>
        <button class="common_button" onclick="">保存</button>
    </div>
    <table class="query_form_table">
        <tr>
            <th>客户编号</th>
            <td><form:input path="custId"/></td>
            <th>名称</th>
            <td><form:input path="custName"/><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>地区</th>
            <td>
                <form:select path="custRegion">
                    <form:option value="东北" label="东北"/>
                    <form:option value="华北" label="华北"/>
                    <form:option value="华南" label="华南"/>
                    <form:option value="中南" label="中南"/>
                    <form:option value="西部" label="西部"/>
                </form:select>
                <span class="red_star">*</span></td>
            <th>客户经理</th>
            <td>
                <form:input path="sysUserName"/><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>客户等级</th>
            <td>
                <form:select path="custLevelLabel">
                    <form:option value="普通客户" label="普通客户"/>
                    <form:option value="大客户" label="大客户"/>
                    <form:option value="合作伙伴" label="合作伙伴"/>
                    <form:option value="战略合作伙伴" label="战略合作伙伴"/>
                </form:select><span class="red_star">*</span>
            </td>
            <th>　</th>
            <td>　</td>
        </tr>
        <tr>
            <th>客户满意度</th>
            <td>
                <form:select path="custSatisfy">
                    <form:option value="5" label="☆☆☆☆☆"/>
                    <form:option value="4" label="☆☆☆☆"/>
                    <form:option value="3" label="☆☆☆"/>
                    <form:option value="2" label="☆☆"/>
                    <form:option value="1" label="☆"/>
                </form:select><span class="red_star">*</span>
            </td>
            <th>客户信用度</th>
            <td>
                <form:select path="custCredit">
                    <form:option value="5" label="☆☆☆☆☆"/>
                    <form:option value="4" label="☆☆☆☆"/>
                    <form:option value="3" label="☆☆☆"/>
                    <form:option value="2" label="☆☆"/>
                    <form:option value="1" label="☆"/>
                </form:select><span class="red_star">*</span>
            </td>
        </tr>
    </table>
    <br/>
    <table class="query_form_table" id="table1">
        <tr>
            <th>地址</th>
            <td><form:input path="custAddr"/><span class="red_star">*</span>
            </td>
            <th>邮政编码</th>
            <td><form:input path="custZip" size="20"/><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>电话</th>
            <td>
                <form:input path="custTel" size="20"/><span class="red_star">*</span></td>
            <th>传真</th>
            <td>
                <form:input path="custFax" size="20"/><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>网址</th>
            <td>
                <form:input path="custWebsite" /><span class="red_star">*</span>
            </td>
            <th>　</th>
            <td>　</td>
        </tr>
    </table>
    <br/>
    <table class="query_form_table" id="table2">
        <tr>
            <th>营业执照注册号</th>
            <td><form:input path="custLicenceNo" size="20"/></td>
            <th>法人</th>
            <td><form:input path="custChieftain" size="20"/><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>注册资金（万元）</th>
            <td>
                <form:input path="custBankroll" size="20"/></td>
            <th>年营业额</th>
            <td>
                <form:input path="custTurnover" size="20"/>
            </td>
        </tr>
        <tr>
            <th>开户银行</th>
            <td>
                <form:input path="custBank" size="20"/><span class="red_star">*</span>
            </td>
            <th>银行帐号</th>
            <td><form:input path="custBankAccount" size="20"/><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>地税登记号</th>
            <td>
                <form:input path="custLocalTaxNo" size="20"/></td>
            <th>国税登记号</th>
            <td><form:input path="custNationalTaxNo" size="20"/></td>
        </tr>
    </table>
    <p>　</p>
</form:form>
</body>
</html>