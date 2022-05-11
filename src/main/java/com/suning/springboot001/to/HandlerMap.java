package com.suning.springboot001.to;

import java.util.Calendar;
import java.util.HashMap;

public interface HandlerMap {
    String statisStartDate = "";
    String statisEndDate = "";
    String nextExecuteTime = "";

    //通过map接收，或者返回成员变量
    HashMap handler(String statisStartDate, String statisEndDate, String nextExecuteTime, String taskType);

    static void main(String[] args) {
        String name = "";
        HandlerMap handlerMap = (a, b, c, d) -> {
            String name1 = name;
            return null;
        };
        handlerMap.handler("", "", "", "");

        HashMap handler = ((HandlerMap) (statisStartDate, statisEndDate, nextExecuteTime, taskType) -> null).handler("", "", "", "");

    }
}
