package cn.edu.syu.service;

import cn.edu.syu.po.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findQuestionsByQuestNaireID(Integer questionnaireID);
    Integer addQuestion(Question question);
}
