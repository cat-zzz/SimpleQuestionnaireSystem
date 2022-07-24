<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问卷详情</title>
    <link href="${pageContext.request.contextPath}/css/tables.css" rel="stylesheet" type="text/css">
</head>
<body>
<span>问卷管理系统v1.0</span>
<div align="center">
<table>
    <caption>${questionnaire.questionnaireTitle}</caption>
    <c:forEach items="${questionAnswerList}" var="questionAnswer">
        <%--分隔作用--%>
        <tr><td colspan="2"><hr/></td></tr>
        <%--问题题目--%>
        <tr>
            <td colspan="2">${questionAnswer.question.questionTitle}
                <c:choose>
                    <c:when test="${questionAnswer.question.questionType==1}">（单选）</c:when>
                    <c:when test="${questionAnswer.question.questionType==2}">（多选）</c:when>
                </c:choose>
            </td>
        </tr>
        <%--选项--%>
        <c:forEach items="${questionAnswer.answerList}" var="answerList">
            <tr>
                <td>
                    ${answerList.answerText}
                </td>
                <td>
                    <%--判断用户选的是哪个选项--%>
                    <c:if test="${questionAnswer.answerUser.answerID==answerList.answerID}">
                        √
                    </c:if>
                </td>
            </tr>
        </c:forEach>

    </c:forEach>
</table>
</div>
</body>
</html>
