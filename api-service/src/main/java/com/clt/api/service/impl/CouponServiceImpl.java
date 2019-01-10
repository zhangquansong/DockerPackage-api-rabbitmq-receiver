package com.clt.api.service.impl;

import com.clt.api.entity.Coupon;
import com.clt.api.mapper.CouponMapper;
import com.clt.api.service.CouponService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author zhangquansong
 * @since 2019-01-09
 */
@Service
@Transactional
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {


    @Autowired
    private CouponMapper couponMapper;



    /**
     * 新增
     *
     * @param coupon
     */
    @Override
    public void create(Coupon coupon) {
        this.insertOrUpdate(coupon);
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
     * @param coupon
     */
    @Override
    public void edit(Coupon coupon) {
        this.updateById(coupon);
    }

    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public List<Coupon> listAll() {
        return this.selectList(null);
    }

    /**
    * 查询详情
    *
    * @param id 主键id
    * @return
    */
    @Override
    public Coupon findById(Integer id) {
        return this.selectById(id);
    }

}