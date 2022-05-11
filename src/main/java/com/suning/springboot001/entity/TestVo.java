package com.suning.springboot001.entity;

import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/4/16 22:07
 */
public class TestVo {
    private String labelCd;
    private List<AgeDis> list;


    public class AgeDis {
        private int age;
        private int count;
    }
}
