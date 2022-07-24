<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加问卷</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        //TODO 要设置问题和选项的个数（包括已删除的）上限为999个
        let questionCount = 0;
        let answerCount = 0;

        //添加选项
        function addAnswer() {
            answerCount++;
            if (answerCount >= 1000) {
                alert("Error:已创建选项数量过多");
                return;
            }
            //选项内容输入框
            let answer = document.createElement("input");
            answer.setAttribute("type", "text");
            answer.setAttribute("size", "60");
            answer.setAttribute("name", "answerIn" + answerCount);
            //删除选项按钮
            let delAnswerBtn = document.createElement("input");
            delAnswerBtn.setAttribute("type", "button");
            delAnswerBtn.setAttribute("value", "删除该选项");
            delAnswerBtn.setAttribute("name", "delAnswerBtn" + answerCount);
            let str = event.target.name;  //获取触发该事件的name
            //获取数字
            str = getLastNumsStr(str);
            // str=str.substr(str.length-1,1);//获取最后一个字符
            //选项的div
            let answerDiv = document.createElement("div");
            answerDiv.setAttribute("id", "answerDiv" + answerCount);
            answerDiv.appendChild(answer);
            answerDiv.appendChild(delAnswerBtn);

            let divTemp = document.getElementById("div" + str);
            divTemp.appendChild(answerDiv);
            //删除选项
            delAnswerBtn.onclick = function () {
                divTemp.removeChild(answerDiv);
            }
        }

        //提取最后几位的数字
        function getLastNumsStr(str) {
            for (let i = str.length - 3; i < str.length; i++) {
                let temp = str.substring(i, str.length);
                let n = Number(temp);
                console.log(n);
                if (!isNaN(n)) {
                    return n;
                }
            }
        }

        addQuestion = function () {
            questionCount++;
            let allQuestionDiv = document.getElementById("questionDiv");
            let questionDiv = document.createElement("div");
            questionDiv.setAttribute("id", "div" + questionCount);
            //问题题目输入框
            let questionTitleTx = document.createElement("input");
            questionTitleTx.setAttribute("type", "text");
            questionTitleTx.setAttribute("name", "questionTitleIn" + questionCount);
            questionTitleTx.setAttribute("size", "60");
            //添加选项按钮
            let addAnswerBtn = document.createElement("input");
            addAnswerBtn.setAttribute("type", "button");
            addAnswerBtn.setAttribute("value", "添加选项");
            addAnswerBtn.setAttribute("name", "addAnswerBtn" + questionCount);
            //删除问题按钮
            let delQuestionBtn = document.createElement("input");
            delQuestionBtn.setAttribute("type", "button");
            delQuestionBtn.setAttribute("value", "删除问题");
            delQuestionBtn.setAttribute("name", "delAnswerBtn" + questionCount);

            // let divTemp=document.getElementById("div"+str);
            //添加控件到网页
            questionDiv.innerHTML = "<hr/>问题题目";
            questionDiv.appendChild(questionTitleTx);
            questionDiv.appendChild(addAnswerBtn);
            questionDiv.appendChild(delQuestionBtn);
            allQuestionDiv.appendChild(questionDiv);
            //这段语句要放在 allQuestionDiv.appendChild(questionDiv);之后
            addAnswerBtn.onclick = function () {
                addAnswer(questionCount);
            }
            //删除问题
            delQuestionBtn.onclick = function () {
                allQuestionDiv.removeChild(questionDiv);
            }
        }
    </script>
</head>
<body align="center">
<span>问卷管理系统v1.0</span>
<form action="${pageContext.request.contextPath}/questionnaire/addQuestionnaire" method="post">
    <div id="div">
        添加问卷<br/>
        <label>
            问卷题目
            <input type="text" width="1000px" name="questionnaireTitle"/>
        </label><br/>
        <label>
            问卷简介
            <input type="text" maxlength="50" name="questionnaireDesc"/>
        </label><br/>
        <input type="button" value="添加问题" onclick="addQuestion()"/>
    </div>
    <div id="questionDiv"></div>
    <input type="submit" value="提交问卷"/>
</form>
</body>
</html>
