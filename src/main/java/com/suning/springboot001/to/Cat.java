package com.suning.springboot001.to;

import lombok.Data;

/**
 * Created：Jeffrey
 * date   ：2022/4/18 8:39
 */
@Data
public class Cat extends Animal {
    public int height;

    public Cat(String name, int weight, int height) {
        super(name, weight);
        this.height = height;
    }
}
