import cn.edu.syu.po.Questionnaire;
import cn.edu.syu.service.QuestionnaireService;
import cn.edu.syu.service.impl.QuestionnaireServiceImpl;
import org.junit.Test;

import javax.annotation.Resource;

public class Test01 {
    @Test
    public void gqlTest01(){
        QuestionnaireService questionnaireService = new QuestionnaireServiceImpl();
        Questionnaire questionnaire=new Questionnaire();
        questionnaire.setQuestionnaireID(3);
        questionnaire.setQuestionnaireDesc("1111");
        questionnaire.setQuestionnaireTitle("2222");
        questionnaire.setQuestionnaireCreateTime("2021-06-01");
        questionnaire.setUserID(1);
        questionnaireService.addQuestionnaire(questionnaire);

    }
}
