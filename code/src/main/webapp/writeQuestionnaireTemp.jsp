<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写问卷</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
    <form action="#" method="post">
        hello<input type="radio" name="question1" value="100">
        world<input type="radio" name="question1" value="200">
        <table>
            <caption>${questionnaire.questionnaireTitle}</caption>
            <c:forEach items="${questionAnswerList}" var="questionAnswer">
                <%--分隔作用 水平线--%>
                <tr><td colspan="2"><hr/></td></tr>
                <tr>
                    <%--问题题目--%>
                    <td>${questionAnswer.question.questionTitle}</td>
                </tr>
                <%--选项--%>
                <tr>
                    <td>
                        <c:forEach items="${questionAnswer.answerList}" var="answerList">
                            <input type="radio" name="${questionAnswer.question.questionID}">
                            ${answerList.answerText}
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
