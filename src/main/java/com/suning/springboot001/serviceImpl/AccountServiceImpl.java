package com.suning.springboot001.serviceImpl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.suning.springboot001.dao.AccountDao;
import com.suning.springboot001.entity.Account;
import com.suning.springboot001.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created：Jeffrey
 * date   ：2022/4/30 10:16
 */
@Service
@Slf4j
public class AccountServiceImpl  extends ServiceImpl<AccountDao, Account> implements AccountService  {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;

    public void trySetPermits() {
        RSemaphore seck = redissonClient.getSemaphore("seck-semaphere");

        seck.trySetPermits(100);

        log.info("结束！！！");
    }

    public void tryAcquire() throws InterruptedException {
        RSemaphore seck = redissonClient.getSemaphore("seck-semaphere");
        seck.tryAcquire(1, 1000, TimeUnit.SECONDS);

        log.info("结束！！！");
    }

    public void readWriteLock() {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("seck-readWriteLock");
        //读锁
        RLock rLock = readWriteLock.readLock();
        rLock.lock();



        threadPoolExecutor.submit(()->{
            try {
                log.info(Thread.currentThread()+"上锁");
                rLock.lock();
                Thread.sleep(1000);
                rLock.unlock();
                log.info(Thread.currentThread()+"解锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolExecutor.submit(()->{
            try {
                log.info(Thread.currentThread()+"上锁");
                rLock.lock();
                Thread.sleep(1000);
                rLock.unlock();
                log.info(Thread.currentThread()+"解锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        //写锁
        RLock writeLock = readWriteLock.writeLock();


    }





}
