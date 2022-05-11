package com.suning.springboot001.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.suning.springboot001.dao.AccountDao;
import com.suning.springboot001.dao.CinemaDao;
import com.suning.springboot001.dao.CourseDao;
import com.suning.springboot001.entity.Account;
import com.suning.springboot001.entity.Cinema;
import com.suning.springboot001.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务传播机制
 * Created：Jeffrey
 * date   ：2022/4/28 20:17
 */
@Service
@Slf4j
public class TestTransaction {

    @Autowired
    AccountDao accountDao;
    @Autowired
    CourseDao courseDao;

    @Autowired
    TestTransaction testTransaction;

    @Transactional
    public void tran1() {
        log.info("调用事务A");
        tran11();
        testTransaction.tran2();
        tran2();
        tran3();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void tran11() {
        accountDao.updateById(Account.builder().id(37L).money(1003L).build());
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void tran2() {
        log.info("调用事务B--1");
        courseDao.update(Course.builder().cid(1).cstatus(1).name("java003").user_id(1).build(),
                new UpdateWrapper<Course>().eq("cid", 1));
//        accountDao.updateById(Account.builder().id(36L).money(1002L).build());
        log.info("调用事务B--2");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void tran3() {
        log.info("调用事务C--1");
        int a = 3 / 0;
    }


}
