package cn.edu.syu.service.impl;

import cn.edu.syu.dao.AnswerUserDao;
import cn.edu.syu.po.AnswerUser;
import cn.edu.syu.service.AnswerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("answerUserService")
@Transactional
public class AnswerUserServiceImpl implements AnswerUserService {
    @Autowired
    private AnswerUserDao answerUserDao;
    @Override
    public int addAnswerUser(AnswerUser answerUser) {
        return answerUserDao.addAnswerUser(answerUser);
    }
}
