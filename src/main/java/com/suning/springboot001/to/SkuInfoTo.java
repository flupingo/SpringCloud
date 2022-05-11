package com.suning.springboot001.to;

import com.suning.springboot001.entity.SpuInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created：Jeffrey
 * date   ：2022/4/13 20:37
 */
@Data
@NoArgsConstructor
public class SkuInfoTo {
    private String name;
    private Long skuId;
    private SpuInfo spuInfo;


}
