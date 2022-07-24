<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
    <script>
        function checkPwd() {
            let userPwd=document.getElementsByName("userPwd").item(0);
            let userPwdAgain=document.getElementsByName("userPwdAgain").item(0);
            if (userPwd.value===""||userPwdAgain.value===""){
                alert("密码不能为空");
                return false;
            }
            if (userPwd.value!==userPwdAgain.value){  //判断两次密码是否一致
                alert("两次密码不一致");
                console.log(userPwd.value);
                console.log(userPwdAgain.value);
                return false;
            }
            let dateFormat =/^([1-9]\d{3})-(\d{2})-(\d{2})$/;//日期格式
            let birthday=document.getElementsByName("userBirthday").item(0).value;
            console.log(birthday);
            if(!dateFormat.test(birthday)){ //判断日期格式是否正确
                alert("日期格式不正确 如2021-06-01");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<span>问卷管理系统v1.0</span>
    <div align="center">
        <form action="updateUser" method="post">
            请输入新密码：
            <input type="password" name="userPwd" placeholder="密码为0-16字符组合" /><br/>
            请确认新密码：
            <input type="password" name="userPwdAgain" placeholder="密码为0-16字符组合" /><br/>
            &nbsp;&nbsp;&nbsp;&nbsp;请输入生日：
            <input type="text" name="userBirthday" placeholder="格式：yyyy-mm-dd"><br/>
            <input type="submit" value="确认提交" onclick="return checkPwd()">
        </form>
    </div>
</body>
</html>
