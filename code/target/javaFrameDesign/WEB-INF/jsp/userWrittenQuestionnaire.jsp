<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已填写问卷</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<span>问卷管理系统v1.0</span>
    <table align="center">
        <caption>已填写问卷</caption>
        <c:forEach items="${questionnaireList}" var="questionnaire">
            <tr>
                <td><hr/></td>
                <td>
                    <form action="${pageContext.request.contextPath }/questionnaire/findQuestions?questiNaireId=${questionnaire.questionnaireID}&type=2" method="post">
                        <input type="submit" value="${questionnaire.questionnaireTitle}" style="font-size: 20px">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
