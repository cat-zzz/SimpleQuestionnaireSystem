package cn.edu.syu.dao;

import cn.edu.syu.po.Answer;
import cn.edu.syu.po.AnswerUser;

import java.util.List;

public interface AnswerDao {
    /**
     * 查询一个问题下的所有选项
     */
    List<Answer> findAnswersByQuestionId(Integer id);

    /**
     * 添加选项
     */
    Integer addAnswer(Answer answer);

    AnswerUser findWrittenAnswerByQuestionId(Integer questionId, Integer userId);

    /**
     * 根据选项id查找选项
     */
    Answer findAnswerByAnswerId(Integer id);

    int updateAnswerByAnswerId(Answer answer);
}
