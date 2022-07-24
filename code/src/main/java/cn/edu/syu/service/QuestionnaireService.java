package cn.edu.syu.service;
import cn.edu.syu.po.Questionnaire;

import java.util.List;

public interface QuestionnaireService {
    Integer addQuestionnaire(Questionnaire questionnaire);
    List<Questionnaire> findCreatedQuestionnaireByUserId(Integer userId);
    List<Questionnaire> findWrittenQuestionnaireByUserId(Integer userId);
    Questionnaire findQuestionnaireByQuestnaireId(Integer id);
    List<Questionnaire> findLikeQuestionnaires(Integer id,String title);
    int addQuestionnaireWrite(Integer userId,Integer questionnaireId);
}
