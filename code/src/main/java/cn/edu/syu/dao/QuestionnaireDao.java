package cn.edu.syu.dao;

import cn.edu.syu.po.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {
    Integer addQuestionnaire(Questionnaire questionnaire);
    List<Questionnaire> findQuestionnairesByUserId(Integer userId);
    List<Integer> findWrittenQuestionnairesByUserId(Integer userId);
    Questionnaire findQuestionnaireByQuestnaireId(Integer id);
    //模糊查询
    List<Questionnaire> findLikeQuestionnaires(Integer id,String title);
    int addQuestionnaireWrite(Integer userId,Integer questionnaireId);
}
