package com.suning.springboot001.web;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created：Jeffrey
 * date   ：2022/4/18 10:21
 */
public class Test001 {
    public static int count1 = 1;
    private static Test001 test001 = new Test001();
    public static int count2 = 5;



    private Test001() {
        count1++;
        count2++;
    }

    public static int getValue() {
        int i = 1;
        try {
            int a = i++;
            return i;
        } finally {
            i++;  //返回的不是这个i++的3
        }
    }


    public static Test001 getInstance() {
        return test001;
    }

    public static void main(String[] args) {
        Test001 person = Test001.getInstance();
        System.out.println(person.count1 + "," + person.count2);
        System.out.println(getValue());


        new ConcurrentHashMap<>().get(1);
    }


}
