package com.clt.api.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName : BlackUser
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 5:48
 * @Description :黑名单实体类
 **/
@Data
@Accessors(chain = true)
@TableName("black_user")
public class BlackUser extends Model<BlackUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private Long userId;
    @TableField("black_user_ip")
    private String blackUserIp;
    @TableField("black_user_imei")
    private String blackUserImei;
    @TableField("user_login_name")
    private String userLoginName;
    @TableField("user_name")
    private String userName;
    @TableField("user_phone")
    private String userPhone;
    @TableField("user_sex")
    private Integer userSex;
    @TableField("user_id_card")
    private String userIdCard;
    @TableField("user_code")
    private String userCode;
    @TableField("user_type")
    private Integer userType;
    @TableField("user_address")
    private String userAddress;
    @TableField("black_user_description")
    private String blackUserDescription;
    @TableField("black_user_note")
    private String blackUserNote;
    @TableField("black_user_status")
    private Integer blackUserStatus;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("is_delete")
    private Integer isDelete;
    @TableField("black_user_version")
    private Long blackUserVersion;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BlackUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", blackUserIp=" + blackUserIp +
                ", blackUserImei=" + blackUserImei +
                ", userLoginName=" + userLoginName +
                ", userName=" + userName +
                ", userPhone=" + userPhone +
                ", userSex=" + userSex +
                ", userIdCard=" + userIdCard +
                ", userCode=" + userCode +
                ", userType=" + userType +
                ", userAddress=" + userAddress +
                ", blackUserDescription=" + blackUserDescription +
                ", blackUserNote=" + blackUserNote +
                ", blackUserStatus=" + blackUserStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", blackUserVersion=" + blackUserVersion +
                "}";
    }
}
