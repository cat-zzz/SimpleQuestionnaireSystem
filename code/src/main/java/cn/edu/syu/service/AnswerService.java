package cn.edu.syu.service;

import cn.edu.syu.po.Answer;
import cn.edu.syu.po.AnswerUser;

import java.util.List;

public interface AnswerService {
    List<Answer> findAnswersByQuestionID(Integer questionID);
    int addAnswer(Answer answer);
    AnswerUser findWrittenAnswer(Integer questionId, Integer userId);
    Answer findAnswerByAnswerId(Integer id);
    int updateAnswerByAnswerId(Answer answer);
}
