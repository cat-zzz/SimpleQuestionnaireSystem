package cn.edu.syu.service.impl;

import cn.edu.syu.dao.QuestionnaireDao;
import cn.edu.syu.po.Questionnaire;
import cn.edu.syu.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireDao questionnaireDao;
    @Override
    public Integer addQuestionnaire(Questionnaire questionnaire) {
        return questionnaireDao.addQuestionnaire(questionnaire);
    }

    @Override
    public List<Questionnaire> findCreatedQuestionnaireByUserId(Integer userId) {
        return questionnaireDao.findQuestionnairesByUserId(userId);
    }

    @Override
    public List<Questionnaire> findWrittenQuestionnaireByUserId(Integer userId) {

        List<Integer> rows=questionnaireDao.findWrittenQuestionnairesByUserId(userId);
        List<Questionnaire> questionnaireList = new ArrayList<>();
        Questionnaire questionnaire;
        for (Integer i :
                rows) {
            questionnaire=questionnaireDao.findQuestionnaireByQuestnaireId(i);
            questionnaireList.add(questionnaire);
        }
        return questionnaireList;

    }

    @Override
    public Questionnaire findQuestionnaireByQuestnaireId(Integer id) {
        return questionnaireDao.findQuestionnaireByQuestnaireId(id);
    }

    @Override
    public List<Questionnaire> findLikeQuestionnaires(Integer id,String title) {
        return questionnaireDao.findLikeQuestionnaires(id,title);
    }

    @Override
    public int addQuestionnaireWrite(Integer userId, Integer questionnaireId) {
        return questionnaireDao.addQuestionnaireWrite(userId,questionnaireId);
    }
}
