package com.suning.springboot001.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created：Jeffrey
 * date   ：2022/4/13 14:08
 */
//@Data
@NoArgsConstructor
public class SkuInfo {
    private Long skuId;
    private Long spuId;

    //    @TableField("skuName")
    private String skuName;
    private Double price;
    private Long saleCount;
    public SkuInfo(Long spuId, String skuName) {
        this.spuId = spuId;
        this.skuName = skuName;
    }
}
