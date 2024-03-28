package io.github.sztuwebclub.webvoyager.infra.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
/**
* 
* @TableName problem
*/
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="problem")
public class ProblemPO implements Serializable {

    /**
    * 题目id
    */
    @NotNull(message="[题目id]不能为空")
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 题目标题
    */
    @NotBlank(message="[题目标题]不能为空")
    @Size(max= 200,message="编码长度不能超过200")
    private String title;
    /**
    * 题目提示
    */
    @Size(max= 65535,message="编码长度不能超过65535")
    private String hint;
    /**
    * 题目时间限制(s)
    */
    @NotNull(message="[题目时间限制(s)]不能为空")
    private Double timeLimit;
    /**
    * 题目内存限制(MB)
    */
    @NotNull(message="[题目内存限制(MB)]不能为空")
    private Integer memoryLimit;
    /**
    * 平台上解出本题的用户数
    */
    @NotNull(message="[平台上解出本题的用户数]不能为空")
    private Integer totalSolved;
    /**
    * 平台上本题的提交数
    */
    @NotNull(message="[平台上本题的提交数]不能为空")
    private Integer totalSubmit;
    /**
    * 本题作者的id
    */
    @NotNull(message="[本题作者的id]不能为空")
    private Integer authorId;
    /**
     * 本题作者的昵称
     */
    @NotNull(message = "[本题作者的昵称]不能为空")
    private String authorName;
}
