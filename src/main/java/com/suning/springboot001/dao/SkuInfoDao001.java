package com.suning.springboot001.dao;

import com.suning.springboot001.entity.SkuInfo;
import com.suning.springboot001.to.SkuInfoTo;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface SkuInfoDao001 {
    List<SkuInfo> selectByMap(HashMap hashMap);

    List<SkuInfo> selectByList(List skuList);

    int insertList(List skuList);

    List<SkuInfo>selectLike(String name);

    List<SkuInfoTo>selectResultMap();

}
