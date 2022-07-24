<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户信息</title>
</head>
<body>
<table border=1>
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>生日</td>
    </tr>
    <tr>
        <td>${user.userID}</td>
        <td>${user.userName}</td>
        <td>${user.userPwd}</td>
        <td>${user.userBirthday}</td>
    </tr>
    <tr>
        <td>${USER.getUserID()}</td>
        <td>${USER.getUserName()}</td>
        <td>${USER.getUserPwd()}</td>
        <td>${USER.getUserBirthday()}</td>
    </tr>
</table>
</body>
</html>
