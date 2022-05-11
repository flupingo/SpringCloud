package com.suning.springboot001.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created：Jeffrey
 * date   ：2022/4/13 14:14
 */
@Data
@NoArgsConstructor
public class SpuInfo {
    private Long spuId;
    private String spuName;
    private String spuDescription;
    public SpuInfo(Long spuId, String spuName) {
        this.spuId = spuId;
        this.spuName = spuName;
    }
}
