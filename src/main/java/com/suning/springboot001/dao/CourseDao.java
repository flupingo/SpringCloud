package com.suning.springboot001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suning.springboot001.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao extends BaseMapper<Course> {
}
