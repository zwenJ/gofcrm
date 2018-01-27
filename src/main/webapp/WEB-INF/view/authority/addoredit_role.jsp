<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/27
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加or修改角色</title>
</head>
<body>
    <br/>
    <br/>
    <br/>
  <c:form action="#" modelAttribute="sysRole">
      <table align="center" style="align-content: center;width: 100%">
          <tr>
              <td style="text-align: right;width: 50%">
                  <strong>职位名称：</strong>
              </td>
              <td style="text-align: left;width: 50%">
                  <c:input path="roleName" class="easyui-textbox" />
              </td>
          </tr>
          <tr>
              <td style="text-align: right;width: 50%">
                  <strong>职位描述：</strong>
              </td>
              <td style="text-align: left;width: 50%">
                  <c:input path="roleDesc" class="easyui-textbox" />
              </td>
          </tr>
          <tr>
              <td colspan="2" style="text-align: center">
                  <input type="submit" value="提交">
                  &nbsp;|&nbsp;
                  <input type="reset" value="清空">
              </td>
          </tr>
      </table>
  </c:form>
</body>
</html>
