package com.clt.api.service;

import com.clt.api.entity.Coupon;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author zhangquansong
 * @since 2019-01-09
 */
public interface CouponService extends IService<Coupon> {

    /**
     * 新增
     *
     * @param coupon
     */
    void create(Coupon coupon);

    /**
     * 删除
     *
     * @param id 主键id
     */
    void delete(Integer id);

    /**
     * 修改
     *
     * @param coupon
     */
    void edit(Coupon coupon);


    /**
     * 列表(全部)
     *
     * @return
     */
    List<Coupon> listAll();

    /**
    * 通过id获取数据
    *
    * @param id 主键id
    * @return
    */
Coupon findById(Integer id);
}