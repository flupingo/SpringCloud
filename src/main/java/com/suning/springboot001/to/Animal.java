package com.suning.springboot001.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created：Jeffrey
 * date   ：2022/4/18 8:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    public String name;
    public int weight;

}
