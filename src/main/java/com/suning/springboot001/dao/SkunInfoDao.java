package com.suning.springboot001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suning.springboot001.entity.SkuInfo;
import com.suning.springboot001.to.SkuInfoTo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface SkunInfoDao extends BaseMapper<SkuInfo> {
    List<SkuInfoTo> findSkuInfo();

    List<SkuInfoTo> findSkuInfo001(int skuId);

    List<HashMap> findSkuMap(int skuId);

    List<SkuInfoTo> findSku(@Param("skuName") String skuName);

    List<SkuInfo> selectSku(SkuInfo skuInfo);

    List<SkuInfo> selectByMap(HashMap<String, Object> hashMap);

    List<SkuInfo> selectIf(HashMap<String, Object> hashMap);

    List<SkuInfo> selectWhereAndIf(HashMap<String, Object> hashMap);

    List<SkuInfo> selectForEach(List<Integer> list);

    List<SkuInfo> selectForEachObject(List list);

    List<SkuInfo> selectByIds(String skuIds);

    List<SkuInfo> selectByIds001(@Param("skuIds") String skuIds);

    int insertSkuList(List<SkuInfo> list);

    List<SkuInfo> selectChoose(String skuName, int spuId);

}
