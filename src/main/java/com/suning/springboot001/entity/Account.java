package com.suning.springboot001.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created：Jeffrey
 * date   ：2022/4/30 10:14
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("account")
public class Account {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String uid;
    private Long money;
}
