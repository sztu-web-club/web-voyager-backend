package io.github.sztuwebclub.webvoyager.infra.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.sztuwebclub.webvoyager.infra.enumerate.UserRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

import java.util.Date;

/**
* 
* @TableName user
*/
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="user")
public class UserPO implements Serializable {

    /**
    * 主键ID
    */
    @NotNull(message="[主键ID]不能为空")
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 姓名
    */
    @NotBlank(message="[姓名]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    private String username;
    /**
    * 年龄
    */
    @NotNull(message="[年龄]不能为空")
    private Integer entryYear;
    /**
    * 邮箱
    */
    @NotBlank(message="[邮箱]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    private String userid;
    /**
    * 密码
    */
    @NotBlank(message="[密码]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    private String password;
    /**
    * 用户昵称
    */
    @NotBlank(message="[用户昵称]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    private String nickname;
    /**
    * 账号创建时间
    */
    @NotNull(message="[账号创建时间]不能为空")
    private Date createTime;
    /**
    * 统一认证用户id
    */
    @Size(max= 30,message="编码长度不能超过30")
    private String ssoId;
    /**
    * 统一认证真实姓名
    */
    @Size(max= 30,message="编码长度不能超过30")
    private String realName;
    /**
    * 专业
    */
    @Size(max= 30,message="编码长度不能超过30")
    private String major;
    /**
    * 用户角色
    */
    @NotNull(message="[用户角色]不能为空")
    private UserRoleEnum role;
}
