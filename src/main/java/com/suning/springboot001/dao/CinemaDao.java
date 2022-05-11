package com.suning.springboot001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suning.springboot001.entity.Cinema;
import com.suning.springboot001.to.CinemaTo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CinemaDao extends BaseMapper<Cinema> {
    List<CinemaTo> selectInfo(@Param("id") Long cid);
}
