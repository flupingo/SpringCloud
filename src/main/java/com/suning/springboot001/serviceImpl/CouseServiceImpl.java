package com.suning.springboot001.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.suning.springboot001.dao.CourseDao;
import com.suning.springboot001.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created：Jeffrey
 * date   ：2022/5/4 20:38
 */
@Slf4j
@Service
public class CouseServiceImpl {
    @Autowired
    CourseDao courseDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void tran2() {
        log.info("调用事务B--1");
        courseDao.update(Course.builder().cid(1).cstatus(1).name("java002").user_id(1).build(),
                new UpdateWrapper<Course>().eq("cid", 1));
//        accountDao.updateById(Account.builder().id(36L).money(1002L).build());
        log.info("调用事务B--2");
    }

}
