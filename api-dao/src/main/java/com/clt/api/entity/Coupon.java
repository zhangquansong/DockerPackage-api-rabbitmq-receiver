package com.clt.api.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.enums.FieldFill;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 卡劵表
 * </p>
 *
 * @author zhangquansong
 * @since 2019-01-09
 */
@Data
@Accessors(chain = true)
public class Coupon extends Model<Coupon> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("user_id")
	private Long userId;
	private BigDecimal money;
	@TableField("init_money")
	private BigDecimal initMoney;
	@TableField("create_time")
	private Date createTime;
	@TableField("update_time")
	private Date updateTime;
	@TableField("use_time")
	private Date useTime;
	@TableField("start_time")
	private Date startTime;
	@TableField("over_time")
	private Date overTime;
	private Integer type;
	private Integer status;
	@TableField("is_always")
	private Integer isAlways;
	@TableField("product_id")
	private Long productId;
	@TableField("investors_id")
	private Long investorsId;
	@TableField("use_range")
	private String useRange;
	private String note;
	private BigDecimal rate;
	@TableField("at_least")
	private BigDecimal atLeast;
	@TableField("use_range_type")
	private String useRangeType;
	@TableField("expiry_day")
	private Long expiryDay;
	@TableField("sender_id")
	private Long senderId;
	@TableField("is_delete")
	private Integer isDelete;
	private Long version;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Coupon{" +
			"id=" + id +
			", userId=" + userId +
			", money=" + money +
			", initMoney=" + initMoney +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", useTime=" + useTime +
			", startTime=" + startTime +
			", overTime=" + overTime +
			", type=" + type +
			", status=" + status +
			", isAlways=" + isAlways +
			", productId=" + productId +
			", investorsId=" + investorsId +
			", useRange=" + useRange +
			", note=" + note +
			", rate=" + rate +
			", atLeast=" + atLeast +
			", useRangeType=" + useRangeType +
			", expiryDay=" + expiryDay +
			", senderId=" + senderId +
			", isDelete=" + isDelete +
			", version=" + version +
			"}";
	}
}
