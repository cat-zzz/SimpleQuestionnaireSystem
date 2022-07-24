package cn.edu.syu.controller;

import cn.edu.syu.po.*;
import cn.edu.syu.service.AnswerService;
import cn.edu.syu.service.AnswerUserService;
import cn.edu.syu.service.QuestionService;
import cn.edu.syu.service.QuestionnaireService;
import cn.edu.syu.utils.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("questionnaire")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionnaireService questionnaireService;
    @Autowired
    AnswerUserService answerUserService;

    @RequestMapping("/addQuestionnaireJump")
    public String addQuestionnaireJump(){
        return "addQuestionnaire";
    }

    /**
     * 添加问卷
     */
    @RequestMapping("/addQuestionnaire")
    public String addQuestionnaire(Questionnaire questionnaire, HttpServletRequest request, HttpSession session) {
        Enumeration enu=request.getParameterNames();//获取所有参数名
        //1.添加问卷
        LocalDate date = LocalDate.now();//设置创建日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        questionnaire.setQuestionnaireCreateTime(date.format(formatter));
        User user= (User) session.getAttribute("USER");
        questionnaire.setUserID(user.getUserID());
        questionnaireService.addQuestionnaire(questionnaire);

        //2.添加问题
        //3.添加选项
        String answerPara;
        String questionParaName=(String)enu.nextElement();
        while(enu.hasMoreElements()){
            if(questionParaName.contains("questionTitleIn")){   //获取问题题目
                Question question=new Question();
                question.setQuestionnaireID(questionnaire.getQuestionnaireID());
                question.setQuestionTitle(request.getParameter(questionParaName));
                question.setQuestionType(1);
                //添加问题题目
                questionService.addQuestion(question);
                System.out.println("1:"+question.getQuestionTitle());
                while (enu.hasMoreElements()){  //获取选项
                    answerPara= (String) enu.nextElement();
                    if (answerPara.contains("answerIn")){
                        //添加选项
                        Answer answer=new Answer();
                        answer.setAnswerText(request.getParameter(answerPara));
                        answer.setQuestionID(question.getQuestionID());
                        answer.setPoll(0);
                        answerService.addAnswer(answer);
                        System.out.println("2:"+questionParaName+"  "+answerPara);
                    }else {
//                        questionParaName=(String)enu.nextElement();//找个半天这个错误 answerPara存的是questionTitleIn，因为只有这样才可能跳转到else里面
                        questionParaName=answerPara;
                        System.out.println("3:"+questionParaName+"  "+answerPara);
                        break;
                    }
                }
            } else {
                System.out.println("4:"+questionParaName);
                questionParaName=(String)enu.nextElement();
            }
        }

        return "main";
    }

    /**
     * 根据id查找并显示问卷
     */
    @RequestMapping("/findQuestions")
    public String findQuestions(String questiNaireId,String type, HttpSession session,Model model){
        List<Answer> answerListTemp = null; //一个问题下的选项
        List<Question> questionList= questionService.findQuestionsByQuestNaireID(Integer.parseInt(questiNaireId));
        List<QuestionAnswer> questionAnswerList=new ArrayList<QuestionAnswer>();//所有问题及其选项
        User user= (User) session.getAttribute("USER");
        Questionnaire questionnaire=questionnaireService.findQuestionnaireByQuestnaireId(Integer.valueOf(questiNaireId));//问卷相关信息
        for (int i = 0; i < questionList.size(); i++) {
            Question question=questionList.get(i);
            QuestionAnswer questionAnswer=new QuestionAnswer(); //一个问题及其选项
            AnswerUser answerUser=new AnswerUser();
            answerListTemp = answerService.findAnswersByQuestionID(question.getQuestionID());
            answerUser=answerService.findWrittenAnswer(question.getQuestionID(),user.getUserID());//用户选择的选项
            questionAnswer.setAnswerUser(answerUser);
            questionAnswer.setQuestion(question);
            questionAnswer.setAnswerList(answerListTemp);
            questionAnswerList.add(i,questionAnswer);
        }
        model.addAttribute("questionnaire",questionnaire);
        model.addAttribute("questionAnswerList",questionAnswerList);
        if(type.equals("1")){   //发布者查看问卷详情
            return "showQuestions";

        }else if(type.equals("2")){ //填写者查看问卷详情
            return "showWrittenQuestions";
        }else { //填写问卷
            return "writeQuestionnaire";
        }
    }

    /**
     * 查看用户已发布问卷
     */
    @RequestMapping("findCreatedQuestionnaires")
    public String findCreatedQuestionnaires(HttpSession session,Model model){
        User user= (User) session.getAttribute("USER");
        List<Questionnaire> questionnaireList=questionnaireService.findCreatedQuestionnaireByUserId(user.getUserID());
        model.addAttribute("questionnaireList",questionnaireList);
        return "userCreatedQuestionnaire";
    }
    /**
     * 查看用户已填写问卷
     */
    @RequestMapping("findWrittenQuestionnaires")
    public String findWrittenQuestionnaires(HttpSession session,Model model){
        User user= (User) session.getAttribute("USER");
        List<Questionnaire> questionnaireList=new ArrayList<>();
        questionnaireList=questionnaireService.findWrittenQuestionnaireByUserId(user.getUserID());
        model.addAttribute("questionnaireList",questionnaireList);
        return "userWrittenQuestionnaire";
    }
    @RequestMapping("searchQuestionnaireJump")
    public String searchQuestionnaireJump(){
        return "searchQuestionnaire";
    }

    //TODO 只显示未填写的问卷，嵌套查询  已实现
    /**
     * 搜索问卷（模糊搜索和根据id搜索）
     */
    @RequestMapping("findLikeQuestionnaires")
    public String findLikeQuestionnaires(String searchName,HttpSession session,Model model){
        List<Questionnaire> questionnaireList;
        Questionnaire questionnaire;
        String searchResult="";
        User user= (User) session.getAttribute("USER");
        if (searchName.equals("")){
            return "searchQuestionnaire";
        }
        if (util.isNumber(searchName)){ //输入的是问卷id
            questionnaire=questionnaireService.findQuestionnaireByQuestnaireId(Integer.valueOf(searchName));
            questionnaireList=questionnaireService.findWrittenQuestionnaireByUserId(user.getUserID());
            boolean temp=false;
            for (Questionnaire q :
                    questionnaireList) {
                if (questionnaire.getQuestionnaireID() == q.getQuestionnaireID()){
                    temp=true;
                    break;
                }
            }
            if(temp){   //查询的问卷用户已填写
                searchResult="您已填写过该问卷";
                model.addAttribute("type",2);
            }else {
                model.addAttribute("type",3);
            }
            if(questionnaire==null){
                searchResult="未查询到问卷";
            }
            model.addAttribute("questionnaire",questionnaire);
        }else{  //输入的是关键词，进行模糊查询
            questionnaireList=questionnaireService.findLikeQuestionnaires(user.getUserID(),searchName);
            if (questionnaireList.size()<=0){
                searchResult="未查询到问卷";
            }
            model.addAttribute("type",3);
            model.addAttribute("questionnaireList",questionnaireList);
        }
        model.addAttribute("searchResult",searchResult);
        return "searchQuestionnaire";
    }

    /**
     * 填写问卷
     */
    @RequestMapping("writeQuestionnaire")
    public String writeQuestionnaire(HttpServletRequest request,HttpSession session){
        Enumeration enu=request.getParameterNames();
        AnswerUser answerUser=new AnswerUser();
        int userId=((User) session.getAttribute("USER")).getUserID();//获取用户id
        int questionnaireId= Integer.parseInt(request.getParameter((String) enu.nextElement()));//获取问卷id
        answerUser.setUserID(userId);
        while (enu.hasMoreElements()){
            String questionParam= (String) enu.nextElement();   //问题id，在jsp页面命名时就是以id命名的
            String answerParam = request.getParameter(questionParam);//所选选项id
            //赋值
            answerUser.setQuestionID(Integer.parseInt(questionParam));
            answerUser.setAnswerID(Integer.parseInt(answerParam));
            //System.out.println(answerUser.getAnswerID()+" "+answerUser.getUserID()+"  "+answerUser.getQuestionID());
            answerUserService.addAnswerUser(answerUser);//添加answerUser
            Answer answer=answerService.findAnswerByAnswerId(Integer.valueOf(answerParam));
            int poll=answer.getPoll();
            answer.setPoll(++poll);
            answerService.updateAnswerByAnswerId(answer);//更新poll值
        }
        questionnaireService.addQuestionnaireWrite(userId,questionnaireId);
        return "main";
    }
    /**
     * 仅测试
     */
    @RequestMapping("questionnaireTest")
    public String questionnaireTest(){
//        Questionnaire questionnaire=new Questionnaire();
//        questionnaire.setQuestionnaireID(3);
//        questionnaire.setQuestionnaireTitle("1111");
//        questionnaire.setQuestionnaireDesc("2222");
//        questionnaire.setUserID(1);
//        questionnaire.setQuestionnaireCreateTime("2020-05-20");
//        questionnaireService.addQuestionnaire(questionnaire);
        AnswerUser answerUser=new AnswerUser();
        answerUser.setAnswerID(7);
        answerUser.setQuestionID(3);
        answerUser.setUserID(1);
        answerUserService.addAnswerUser(answerUser);
        return "main";
    }
}
