package com.clt.api.param;

import com.clt.api.annotation.EncryptFiled;
import com.clt.api.param.base.BaseParam;
import com.clt.api.security.DESEncryptType;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName : UserCreateParam
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:13
 * @Description : 创建用户信息param
 **/
@Data
public class UserCreateParam extends BaseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "登录名称不能为空")
    private String userLoginName;
    private String userName;
    private String userPhone;
    private Integer userSex;
    private String userIdCard;
    private String userFace;
    private String userCode;
    @NotNull(message = "用户类型不能为空")
    private Integer userType;
    @EncryptFiled(DESEncryptType.PASSWORD)
    private String userPassword;
    private String userAddress;

}
