package com.suning.springboot001;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suning.springboot001.aop.Star;
import com.suning.springboot001.dao.AccountDao;
import com.suning.springboot001.dao.SkuInfoDao001;
import com.suning.springboot001.dao.SkunInfoDao;
import com.suning.springboot001.dao.SpuInfoDao;
import com.suning.springboot001.entity.Account;
import com.suning.springboot001.entity.SkuInfo;
import com.suning.springboot001.entity.User;
import com.suning.springboot001.service.CinemaService;
import com.suning.springboot001.serviceImpl.AccountServiceImpl;
import com.suning.springboot001.serviceImpl.CinemaServiceImpl;
import com.suning.springboot001.serviceImpl.TestTransaction;
import com.suning.springboot001.to.Animal;
import com.suning.springboot001.to.CinemaTo;
import com.suning.springboot001.to.SkuInfoTo;
import com.suning.springboot001.to.SpuInfoTo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.base.Joiner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class Springboot001ApplicationTests {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    SpuInfoDao spuInfoDao;
    @Autowired
    SkunInfoDao skunInfoDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    private Star star;
    @Autowired
    CinemaServiceImpl cinemaService001;
    @Autowired
    User user;
    @Autowired
    SkuInfoDao001 skuInfoDao001;

    @Autowired
    TestTransaction testTransaction;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AccountServiceImpl accountService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testAccountDao() {
        HashMap map = new HashMap<>();
        map.put("money", 1000);
//        List list01 = accountDao.selectByHashMap(map);
        List list02 = accountDao.selectByParam(1000);

        accountDao.update(Account.builder().uid("2").money(100L).build(), new UpdateWrapper<Account>().eq("id", "37"));
        accountDao.updateByMyId(37L, "2", 200L);
        accountDao.selectById(1L);
        accountService.listByIds(Lists.newArrayList(1, 3));

        accountService.list(new QueryWrapper<Account>().eq("money", "100"));
        accountDao.listByParams(Lists.newArrayList("3", "6", "12"));
        accountDao.insertSingle("3", 30L);
        accountService.saveBatch(Lists.newArrayList(Account.builder().uid("3").money(101L).build()));
        accountService.updateBatchById(Lists.newArrayList(Account.builder().uid("3").money(101L).build()));

        Map<Object, Object> hashMap = new HashMap<>();

        //收集List<id>
        accountService.removeByIds(Lists.newArrayList(40));


        log.info("结束！！！");
    }

    @Test
    public void testRedis() throws InterruptedException {
//        accountService.trySetPermits();
//        accountService.tryAcquire();
//        accountService.readWriteLock();

        user.getAge();
        log.info("结束啦");

    }


    @Test
    public void testRedisApi() {
        ListOperations listOperations = redisTemplate.opsForList();
//        listOperations.leftPushAll("list",2,3,5);
//        listOperations.rightPop("list");
//        listOperations.rightPushAll("list",Lists.newArrayList(7,8));
//        listOperations.range("list",1,5);
//        listOperations.index("key",6);


        HashOperations hash = redisTemplate.opsForHash();
        hash.putAll("hash", Maps.newHashMap("name", "zhangsan"));
        Map hash1 = hash.entries("hash");

        log.info("结束");


    }

    @Test
    public void testTran() {
//        accountDao.updateById(Account.builder().id(37L).money(1000L).build());
        testTransaction.tran1();
        log.info("执行完成！！！");
    }

    @Test
    public void testRabbitMq() {
//        for (int i = 0; i < 10; i++) {
        rabbitTemplate.convertAndSend("exchange_topic", "atguigu001", "test00");
//        }
        rabbitTemplate.convertAndSend("exchange_topic", "atguigu001", Account.builder().id(1L).money(100L).build());


        log.info("结束啦");
    }

    @Test
    public void contextLoads() throws Exception {
        PageHelper.startPage(1,2);
        List<CinemaTo> cinemaToes = cinemaService.selectInfo(1L);
        PageInfo<CinemaTo> cinemaToPageInfo = new PageInfo<>(cinemaToes);


        System.out.println("=+=" + cinemaToes);

        Object.class.getConstructor(String.class).newInstance("spuId", "skuList");

    }

    @Test
    public void testAop() {
//        cinemaService001.testTransaction();
//        cinemaService001.testTransaction001();

        star.laugh("歌曲！！！");
        star.sing("我是一个好人！！！");
    }

    @Test
    public void testSkuInfo001() {
        List<SkuInfoTo> skuInfoTos = skuInfoDao001.selectResultMap();


        List<SkuInfo> skuInfos1 = skuInfoDao001.selectLike("黑色");

        List list001 = new ArrayList();
        list001.add(new SkuInfo(11L, "12"));
        list001.add(new SkuInfo(11L, "13"));
        skuInfoDao001.insertList(list001);


        HashMap hashMap = new HashMap();
        hashMap.put("skuId", "1");
//        hashMap.put("spuId", "11");
//        PageHelper.startPage(2,4);
        List<SkuInfo> skuInfos = skuInfoDao001.selectByMap(hashMap);
//        PageInfo<SkuInfo> pageInfo = new PageInfo<>(skuInfos);

        List list = Lists.newArrayList(1, 2);
        skuInfoDao001.selectByList(list);
        log.info("结束");
    }


    /**
     *
     */
    @Test
    public void testMarketing() {
        Joiner joiner = Joiner.on("12").skipNulls();
        System.out.println(joiner);
        ArrayList<Integer> integers = Lists.newArrayList(1, 2);
        System.out.println(integers);

        // 2.生成验证码
        String code = String.valueOf((int) ((1 + Math.random() * 9) * 100000));

        log.info("日志{},++++{}", "info我来看看", "再次看看");
        log.error("日志{}", "error我来看看");

        ArrayList<BigDecimal> bigDecimals = Lists.newArrayList(new BigDecimal(12), new BigDecimal(13));
        BigDecimal bigDecimal = bigDecimals.stream().map(t -> new BigDecimal(1)).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);

    }


    @Test
    public void TestSpuInfo() {
        List<SpuInfoTo> spuInfo = spuInfoDao.findSpuInfo();
        System.out.println(spuInfo);
    }

    @Test
    public void TestSkuInfo() {
        List<HashMap> skuMap = skunInfoDao.findSkuMap(1);

        //1.指定要展示的页码和分页策略(每页展示多少)
        Page<Object> page01 = PageHelper.startPage(5, 4);
        //2.需要分页的数据
        List<SkuInfo> skuInfos4 = skunInfoDao.selectChoose("", 13);
        //3.分页后数据，指定导航页码要展示的数量
        PageInfo<SkuInfo> pageInfo = new PageInfo<>(skuInfos4, 2);


        List list12 = new ArrayList();
        list12.add(new SkuInfo(1L, "小米001"));
        list12.add(new SkuInfo(2L, "小米002"));

        skunInfoDao.insertSkuList(list12);


//        List<SkuInfoTo> skuInfo001 = skunInfoDao.findSkuInfo001(1);

        Page<Object> page02 = PageHelper.startPage(1, 2);
        List<SkuInfo> skuInfos3 = skunInfoDao.selectByIds001("1,2");
        List<SkuInfo> skuInfos2 = skunInfoDao.selectByIds("1,2");


        SkuInfo skuInfo1 = new SkuInfo(1L, "1");
        List list11 = new ArrayList();
        list11.add(new SkuInfo(1L, "1"));
        list11.add(new SkuInfo(2L, "1"));
        List<SkuInfo> skuInfos1 = skunInfoDao.selectForEachObject(list11);


        List list = new ArrayList();
        List list5 = skunInfoDao.selectForEach(list);
        list.add(1);
        list.add(2);
        List list3 = skunInfoDao.selectForEach(list);

        HashMap hashMap = new HashMap();
        hashMap.put("skuName", "黑色");
        skunInfoDao.selectWhereAndIf(hashMap);
        hashMap.put("skuName", "");
        skunInfoDao.selectWhereAndIf(hashMap);

        List list2 = skunInfoDao.selectByMap(hashMap);
        List list1 = skunInfoDao.selectIf(hashMap);
        List<SkuInfo> skuInfos = skunInfoDao.selectSku(new SkuInfo(1L, "黑色"));

        List<SkuInfoTo> sku = skunInfoDao.findSku("亮黑色");

        List<SkuInfoTo> skuInfo = skunInfoDao.findSkuInfo();
        System.out.println(skuInfo);


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.get(1);
    }
}
