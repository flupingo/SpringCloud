package com.suning.springboot001.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created：Jeffrey
 * date   ：2022/5/4 20:08
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("course")
@Data
public class Course {
    @TableId(value = "cid", type = IdType.AUTO)
    private int cid;
    @TableField("cname")
    private String name;
    @TableField("user_id")
    private int user_id;
    private int cstatus;

}
