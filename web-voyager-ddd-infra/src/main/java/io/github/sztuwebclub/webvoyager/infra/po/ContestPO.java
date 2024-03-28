package io.github.sztuwebclub.webvoyager.infra.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="contest")
public class ContestPO {
    /**
     * 比赛ID
     */
    @NotNull(message="[比赛id]不能为空")
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 比赛名称
     */
    @NotBlank(message="[比赛名称]不能为空")
    @Size(max= 200,message="编码长度不能超过200")
    private String username;
    /**
     * 比赛开始时间
     */
    @NotNull(message="[比赛开始时间]不能为空")
    private Date startTime;
    /**
     * 比赛结束时间
     */
    @NotNull(message="[比赛结束时间]不能为空")
    private Date endTime;
    /**
     * 比赛描述
     */
    @NotBlank(message="[比赛描述]不能为空")
    @Size(max= 65535,message="编码长度不能超过65535")
    private String description;
    /**
     * 是否公开
     */
    @NotNull(message = "[是否公开]不能为空")
    private Integer ispriate;
}
