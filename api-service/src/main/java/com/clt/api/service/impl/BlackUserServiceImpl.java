package com.clt.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clt.api.entity.BlackUser;
import com.clt.api.mapper.BlackUserMapper;
import com.clt.api.service.BlackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName : BlackUserServiceImpl
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 5:49
 * @Description :黑名单基础curd操作业务实现类
 **/
@Service
@Transactional
public class BlackUserServiceImpl extends ServiceImpl<BlackUserMapper, BlackUser> implements BlackUserService {


    @Autowired
    private BlackUserMapper blackUserMapper;


    /**
     * 新增
     *
     * @param blackUser
     */
    @Override
    public void create(BlackUser blackUser) {
        this.insertOrUpdate(blackUser);
    }

    /**
     * 删除
     *
     * @param id 主键id
     */
    @Override
    public void delete(Integer id) {
        this.deleteById(id);
    }

    /**
     * 修改
     *
     * @param blackUser
     */
    @Override
    public void edit(BlackUser blackUser) {
        this.updateById(blackUser);
    }

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public List<BlackUser> listAll() {
        return this.selectList(null);
    }

    /**
     * 查询详情
     *
     * @param id 主键id
     * @return
     */
    @Override
    public BlackUser findById(Integer id) {
        return this.selectById(id);
    }

}