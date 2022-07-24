package cn.edu.syu.service.impl;

import cn.edu.syu.dao.QuestionDao;
import cn.edu.syu.po.Question;
import cn.edu.syu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> findQuestionsByQuestNaireID(Integer questionnaireID) {
        return questionDao.findQuestionsByQuestnaireID(questionnaireID);
    }

    @Override
    public Integer addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }
}
