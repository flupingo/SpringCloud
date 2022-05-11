package com.suning.springboot001.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.Transient;

/**
 * Created：Jeffrey
 * date   ：2022/4/18 8:38
 */
@Data
public class Dog extends Animal {

    private String color;

    public Dog(String name, int weight, String color) {
        super(name, weight);
        this.color = color;

    }

    public static void main(String[] args) {
        Dog dog = new Dog("wangwang", 1, "黑色");
        System.out.println(dog.name);

    }
}
