package com.suning.springboot001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suning.springboot001.entity.SpuInfo;
import com.suning.springboot001.to.SpuInfoTo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfo> {

    List<SpuInfoTo> findSpuInfo();


}
