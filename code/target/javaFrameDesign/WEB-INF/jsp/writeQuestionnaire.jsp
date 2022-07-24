<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写问卷</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/questionnaire/writeQuestionnaire" method="post">
        <table>
            <caption>${questionnaire.questionnaireTitle}</caption>
            <input type="hidden" value="${questionnaire.questionnaireID}" name="questionnaireID"/>
            <c:forEach items="${questionAnswerList}" var="questionAnswer">
                <%--分隔作用 水平线--%>
                <tr><td><hr/></td></tr>
                <tr>
                        <%--问题题目--%>
                    <td style="text-align: left">${questionAnswer.question.questionTitle}</td>
                </tr>
                <%--选项--%>
                    <c:forEach items="${questionAnswer.answerList}" var="answerList">
                        <tr>
                            <td style="text-align: left">
                                <input type="radio" name="${questionAnswer.question.questionID}" value="${answerList.answerID}">
                                 ${answerList.answerText}
                            </td>
                        </tr>
                    </c:forEach>
            </c:forEach>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
