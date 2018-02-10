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
    <title>客户关系管理系统--新增客户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<br/>
<div class="page_title">客户信息管理 > 客户信息</div>
<div class="button_bar">
    <button class="common_button" onclick="help('');">帮助</button>

    <button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="">保存</button>
</div>
<table class="query_form_table">
    <tr>
        <th>客户编号</th>
        <td><input id="custId" name="custId" type="text" value="" /></td>
        <th>名称</th>
        <td><input id="custName" name="custName" type="text" value="" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>地区</th>
        <td>
            <select id="custRegion" name="custRegion">
                <option disabled="disabled">请选择...</option>
                <option selected>东北</option>
                <option>华北</option>
                <option>中南</option>
                <option>华南</option>
                <option>西部</option>
            </select>
            <span class="red_star">*</span></td>
        <th>客户经理</th>
        <td>
            <input id="custManagerId" name="custManagerId" type="text" value="" /><span class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>客户等级</th>
        <td>
            <select id="custLevel" name="custLevel">
                <option disabled="disabled">请选择...</option>
                <option>战略合作伙伴</option>
                <option>合作伙伴</option>
                <option>大客户</option>
                <option>重点开发客户</option>
                <option>普通客户</option>
            </select><span class="red_star">*</span>
        </td>
        <th>　</th>
        <td>　</td>
    </tr>
    <tr>
        <th>客户满意度</th>
        <td>
            <select id="custSatisfy" name="custSatisfy">
                <option value="5">☆☆☆☆☆</option>
                <option value="4">☆☆☆☆</option>
                <option value="3" selected="selected">☆☆☆</option>
                <option value="2">☆☆</option>
                <option value="1">☆</option></select><span class="red_star">*</span>
        </td>
        <th>客户信用度</th>
        <td>
            <select id="custCredit" name="custCredit">
                <option value="5">☆☆☆☆☆</option>
                <option value="4">☆☆☆☆</option>
                <option value="3" selected="selected">☆☆☆</option>
                <option value="2">☆☆</option>
                <option value="1">☆</option></select><span class="red_star">*</span>
        </td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table1">
    <tr>
        <th>地址</th>
        <td><input id="custAddr" name="custAddr" value=""  /><span class="red_star">*</span>
        </td>
        <th>邮政编码</th>
        <td><input id="custZip" name="custZip" value="" size="20" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>电话</th>
        <td>
            <input id="custTel" name="custTel" value="" size="20"  /><span class="red_star">*</span></td>
        <th>传真</th>
        <td>
            <input id="custFax" name="custFax" value="" size="20"  /><span class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>网址</th>
        <td>
            <input id="custWebsite" name="custWebsite" value="" size="20"  /><span class="red_star">*</span>
        </td>
        <th>　</th>
        <td>　</td>
    </tr>
</table>
<br />
<table class="query_form_table" id="table2">
    <tr>
        <th>营业执照注册号</th>
        <td><input id="custLicenceNo" name="custLicenceNo" value="" size="20" /></td>
        <th>法人</th>
        <td><input id="custChieftain" name="custChieftain" value="" size="20" /><span class="red_star">*</span>
        </td>
    </tr>
    <tr>
        <th>注册资金（万元）</th>
        <td>
            <input id="custBankroll" name="custBankroll" value="" size="20" /> </td>
        <th>年营业额</th>
        <td>
            <input id="custTurnover" name="custTurnover" value="" size="20" />
        </td>
    </tr>
    <tr>
        <th>开户银行</th>
        <td>
            <input id="custBank" name="custBank" value="" size="20" /><span class="red_star">*</span>
        </td>
        <th>银行帐号</th>
        <td><input id="custBankAccount" name="custBankAccount" value="" size="20" /><span class="red_star">*</span></td>
    </tr>
    <tr>
        <th>地税登记号</th>
        <td>
            <input id="custLocalTaxNo" name="custLocalTaxNo" value="" size="20" /></td>
        <th>国税登记号</th>
        <td><input id="custNationalTaxNo" name="custNationalTaxNo" value="" size="20" /></td>
    </tr>
</table>
<p>　</p>

</body>
</html>
