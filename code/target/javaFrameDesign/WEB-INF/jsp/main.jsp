<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
    <span>问卷管理系统v1.0</span>
    <div align="center">
        <table>
            <tr>
                <td>用户名</td>
                <td>${USER.userName}</td>
            </tr>
            <tr>
                <td>生日</td>
                <td>${USER.userBirthday}</td>
            </tr>
            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/questionnaire/updateUserJump" method="post">
                        <input type="submit" value="修改信息">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/questionnaire/addQuestionnaireJump" method="post">
                        <input type="submit" value="新建问卷">
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/questionnaire/findCreatedQuestionnaires" method="post">
                        <input type="submit" value="查看已发布问卷">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/questionnaire/findWrittenQuestionnaires" method="post">
                        <input type="submit" value="查看已填写问卷">
                    </form>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form action="${pageContext.request.contextPath}/questionnaire/searchQuestionnaireJump" method="post">
                        <input type="submit" value="填写问卷">
                    </form>
                </td>
            </tr>
        </table>
    </div>
    <%--小彩蛋--%>
    <div id="hideHeart" ondblclick="window.location = 'http://localhost:8080/javaFrameDesign/hideJump.jsp'"
         style="margin-bottom: 10px;width: 800px;height: 300px">
    </div>
</body>
</html>
