package com.suning.springboot001.web.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/4/23 9:25
 */
@Slf4j
public class TestAPI {
    public static void main(String[] args) {


        List<Integer> integers = Arrays.asList(1, 2);
        int[] ints = new int[]{1, 2};
        List ints1 = Arrays.asList(ints);

        ArrayList<Integer> integers1 = Lists.newArrayList(1, 2);

        Collections.addAll(integers1, 3, 2);


        Entity entity = new Entity(1, "zhang", 12);

        Entity entity1 = Entity.builder().build();
        BeanUtils.copyProperties(entity, entity1);

        boolean notEmpty = StringUtils.isNotEmpty(" ");

        log.info("sdf{}", JSON.toJSONString(entity));


        System.out.println("");
    }


    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Entity implements Serializable {
        public transient int age;
        public String name;
        protected int eight;
    }
}
