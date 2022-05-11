package com.suning.springboot001.to;

import com.suning.springboot001.entity.SkuInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2022/4/26 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuInfoTo001 {
    private Long spuId;
    private List<SkuInfo> skuInfoList;
}
