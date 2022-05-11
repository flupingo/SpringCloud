package com.suning.springboot001.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created：Jeffrey
 * date   ：2022/4/13 9:19
 */
@Data
@AllArgsConstructor
@Builder
public class Cinema {
    private Long id;
    private String uid;
    private Long money;

}
