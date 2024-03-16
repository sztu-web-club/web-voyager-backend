package io.github.sztuwebclub.webvoyager.domain.user;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UserRoleEnum {
    USER(1, "普通用户"),
    ADMIN(2, "普通管理员"),
    SYSTEM(3, "系统管理员");

    private int power;
    @EnumValue
    private String name;

    @Override
    public String toString() {
        return this.name;
    }
}
