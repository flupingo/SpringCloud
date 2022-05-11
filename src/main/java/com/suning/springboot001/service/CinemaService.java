package com.suning.springboot001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.suning.springboot001.entity.Cinema;
import com.suning.springboot001.to.CinemaTo;

import java.util.List;

public interface CinemaService extends IService<Cinema> {
    List<CinemaTo> selectInfo(Long cid);



}
