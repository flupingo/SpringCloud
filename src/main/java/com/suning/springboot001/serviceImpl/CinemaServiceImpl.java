package com.suning.springboot001.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.xdevapi.JsonArray;
import com.suning.springboot001.dao.CinemaDao;
import com.suning.springboot001.entity.Cinema;
import com.suning.springboot001.service.CinemaService;
import com.suning.springboot001.to.CinemaTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/4/13 9:47
 */
@Service
@Slf4j
public class CinemaServiceImpl extends ServiceImpl<CinemaDao, Cinema> implements CinemaService {
    @Autowired
    CinemaDao cinemaDao;

    @Override
    public List<CinemaTo> selectInfo(Long cid) {
        List<CinemaTo> cinemaToes = cinemaDao.selectInfo(cid);
        return cinemaToes;
    }

    @Transactional
    public void testTransaction() {
        log.info("开启事务的方法:testTransaction()");
    }

    public void testTransaction001() {
        testTransaction();
    }


    public static void main(String[] args) {
        Cinema cinema = new Cinema(1L, "sd", 200l);
        String ci = JSON.toJSONString(cinema);
        System.out.println(ci);

        String a = "[{\n" +
                "\t\t\"labelCD\": \"age\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"attr\": [{\n" +
                "\t\t\t\"12\": \"30%\",\n" +
                "\t\t\t\"21\": \"10%\"\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "]";
        //JSON数组--JSON组成的数组
        JSONArray jsonArray = JSONArray.parseArray(a);

        System.out.println(jsonArray);

        //获取JsonArray每个JSON对象，和value一样，也可以是其他数据类型
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        //JSON对象value根据数据类型获取
        String labelCD = jsonObject.getString("labelCD");//string类型的value
        System.out.println(labelCD);
        JSONObject jsonObject1 = jsonArray.getJSONObject(1);
        JSONArray attr = jsonObject1.getJSONArray("attr ");//json数组类型的value
        System.out.println(attr.getJSONObject(0));


    }
}
