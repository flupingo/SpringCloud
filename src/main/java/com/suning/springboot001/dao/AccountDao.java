package com.suning.springboot001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suning.springboot001.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AccountDao extends BaseMapper<Account> {
    List<Account> selectByHashMap(HashMap hashMap);

    List<Account> selectByParam(@Param("money1") Integer money);

    int updateByMyId(Long id, String uid, Long money);

    List<Account> listByParams(List list);

    int insertSingle(String uid, Long money);


}
