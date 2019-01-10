package com.clt.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.clt.api.entity.BlackUser;

import java.util.List;

/**
 * @ClassName : BlackUserService
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 5:50
 * @Description : 黑名单用户基础业务curd操作接口
 **/
public interface BlackUserService extends IService<BlackUser> {

    /**
     * 新增
     *
     * @param blackUser
     */
    void create(BlackUser blackUser);

    /**
     * 删除
     *
     * @param id 主键id
     */
    void delete(Integer id);

    /**
     * 修改
     *
     * @param blackUser
     */
    void edit(BlackUser blackUser);


    /**
     * 列表(全部)
     *
     * @return
     */
    List<BlackUser> listAll();

    /**
     * 通过id获取数据
     *
     * @param id 主键id
     * @return
     */
    BlackUser findById(Integer id);
}