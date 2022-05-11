package com.suning.springboot001.request;

import lombok.Data;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/4/23 16:23
 */


@Data
public class PageRequest<T> {
    private List<T> data;
    private String name;

    public PageRequest() {

    }

    public static void main(String[] args) {
        System.out.println();




    }

}
