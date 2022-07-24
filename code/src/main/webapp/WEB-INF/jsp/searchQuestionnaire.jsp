<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索问卷</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div>问卷管理系统v1.0</div>
    <div>
        <form action="${pageContext.request.contextPath }/questionnaire/findLikeQuestionnaires" method="post">
            <input type="text" placeholder="输入关键字或问卷id" name="searchName"/>
            <input type="submit" value="搜索"/>
        </form>
    </div>
    <div>${searchResult}</div>
    <!--根据id查询的结果-->
    <c:if test="${questionnaire!=null}">
        <div align="center">
            <form action="${pageContext.request.contextPath }/questionnaire/findQuestions?questiNaireId=${questionnaire.questionnaireID}&type=${type}" method="post">
                <input type="submit" value="${questionnaire.questionnaireTitle}" style="font-size: 20px">
            </form>
        </div>
    </c:if>
    <!--模糊查询的结果-->
    <table align="center">
        <c:forEach items="${questionnaireList}" var="questionnaireItem">
            <tr>
                <td><hr/></td>
                <td>
                    <form action="${pageContext.request.contextPath }/questionnaire/findQuestions?questiNaireId=${questionnaireItem.questionnaireID}&type=${type}" method="post">
                        <input type="submit" value="${questionnaireItem.questionnaireTitle}" style="font-size: 20px">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>