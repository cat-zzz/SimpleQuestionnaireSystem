package cn.edu.syu.dao;

import cn.edu.syu.po.Question;

import java.util.List;

public interface QuestionDao {
    //问题列表
    List<Question> findQuestionsByQuestnaireID(Integer id);
    //问题数量
    Integer selectQuestionListCount(Question question);
    Question findQuestionById(Integer id);
    Integer addQuestion(Question question);
}
