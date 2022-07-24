package cn.edu.syu.service.impl;

import cn.edu.syu.dao.AnswerDao;
import cn.edu.syu.po.Answer;
import cn.edu.syu.po.AnswerUser;
import cn.edu.syu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service("answerService")
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerDao answerDao;
    @Override
    public List<Answer> findAnswersByQuestionID(Integer questionID) {
        return answerDao.findAnswersByQuestionId(questionID);
    }

    @Override
    public int addAnswer(Answer answer) {
        return answerDao.addAnswer(answer);
    }

    @Override
    public AnswerUser findWrittenAnswer(Integer questionId, Integer userId) {
        return answerDao.findWrittenAnswerByQuestionId(questionId,userId);
    }

    @Override
    public Answer findAnswerByAnswerId(Integer id) {
        return answerDao.findAnswerByAnswerId(id);
    }

    @Override
    public int updateAnswerByAnswerId(Answer answer) {
        return answerDao.updateAnswerByAnswerId(answer);
    }
}
