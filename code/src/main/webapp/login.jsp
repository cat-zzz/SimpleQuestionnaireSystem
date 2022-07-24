<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <%--导入jQuery 但是没有用到--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="javascript">
        function check(){
            let username=$("#userName").val();
            let password=$("#userPwd").val();
            if (username===""||password===""){
                ${"#loginDefeatTips"}.Text("账号或密码不能为空");
                return false;
            }
        }
        function jumpAddUser() {
            window.location.href="addUser.jsp"
        }
    </script>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
    <span>问卷管理系统v1.0</span>
    <div align="center">
        <form action="${pageContext.request.contextPath }/login" method="post" onsubmit="return check()">
            <table>
                <tr>
                    <th colspan="2">用户登录</th>
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
                    <td>验证码</td>
                    <td><input type="text" name="check_code" placeholder="请输入验证码"></td>
                    <td><img  src="${pageContext.request.contextPath}/checkServlet" ></td>
                </tr>
                <tr>
                    <td><input type="reset" value="重置" style="    background-color: #4ba0e8;
                                                                color: #ffffff;
                                                                -moz-border-radius: 5px;
                                                                -webkit-border-radius: 5px;
                                                                border-radius: 5px; /* future proofing */
                                                                text-align: center;border: 1px solid transparent;">
                    </td>
                    <td style="text-align: right"><input type="submit" value="登录" onclick="check()"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <span id="loginDefeatTips">${loginDefeatTips}</span>
                    </td>
                </tr>
            </table>
        </form>
        <div style="margin-right: 40px">
            <form action="${pageContext.request.contextPath}/addUser.jsp" method="post">
                <input type="submit" value="没有账户？立即注册">
            </form>
        </div>

    </div>
</body>
</html>
