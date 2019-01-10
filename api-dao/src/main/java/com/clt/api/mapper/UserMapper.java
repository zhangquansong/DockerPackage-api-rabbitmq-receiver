package com.clt.api.mapper;

import com.clt.api.base.SuperMapper;
import com.clt.api.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName : UserMapper
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:20
 * @Description :用户mapper
 **/
public interface UserMapper extends SuperMapper<User> {

    @Select("select * from user")
    Page<User> findByPage();//查询分页信息例子
}