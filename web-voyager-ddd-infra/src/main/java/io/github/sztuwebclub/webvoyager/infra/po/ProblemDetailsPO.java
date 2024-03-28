package io.github.sztuwebclub.webvoyager.infra.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="problem_details")
public class ProblemDetailsPO {
    /**
     * 题目id
     */
    @NotNull(message="[题目id]不能为空")
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 题目描述
     */
    @NotNull(message="[题目描述]不能为空")
    private String description;
    /**
     * 输入提示
     */
    @NotNull(message="[输入提示]不能为空")
    private String hintInput;
    /**
     * 输出提示
     */
    @NotNull(message="[输出提示]不能为空")
    private String hintOutput;
    /**
     * 输入案例
     */
    @NotNull(message="[输入案例]不能为空")
    private String sampleInput;
    /**
     * 输出案例
     */
    @NotNull(message="[输出案例]不能为空")
    private String sampleOutput;
    /**
     * 提示
     */
    @NotNull(message="[提示]不能为空")
    private String hint;
    /**
     * 输入测试集
     */
    @NotNull(message="[输入测试集]不能为空")
    private String input;
    /**
     * 输出测试集
     */
    @NotNull(message="[输出测试集]不能为空")
    private String output;
}
