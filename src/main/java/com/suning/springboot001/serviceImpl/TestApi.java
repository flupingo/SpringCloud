package com.suning.springboot001.serviceImpl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created：Jeffrey
 * date   ：2022/5/7 11:43
 */
@Slf4j
public class TestApi {
    public static void main(String[] args) {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        List<Integer> collect =integers.stream().map(i -> i + 1111).collect(Collectors.toList());
        System.out.println(collect);




        log.info("结束啦");

    }

}
