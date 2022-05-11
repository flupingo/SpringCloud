package com.suning.springboot001.to;

import com.suning.springboot001.entity.SkuInfo;
import lombok.Data;

import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/4/13 14:19
 */
@Data
public class SpuInfoTo {
    private Long spuId;
    private String spuName;
    private List<SkuInfo> skuInfoList;

}
