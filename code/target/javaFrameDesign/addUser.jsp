<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<span>问卷管理系统v1.0</span>
    <div align="center">
<%--        前端请求的参数名（此处指form表单）必须要与绑定的pojo类中的属性名一样--%>
        <form action="addUser" method="post">
            <table>
                <tr>
                    <th colspan="2">
                        用户注册界面
                    </th>
                </tr>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="userName" placeholder="请输入用户名"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="userPwd" placeholder="请输入密码"></td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td><input type="text" name="userBirthday" placeholder="格式：2000-01-01"></td>
                </tr>
                <tr>
                    <td><input type="reset" value="重置"></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
                <tr>
                    <td colspan="2">${tips}</td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
