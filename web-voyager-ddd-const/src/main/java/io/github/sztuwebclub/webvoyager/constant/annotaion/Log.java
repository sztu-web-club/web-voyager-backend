package io.github.sztuwebclub.webvoyager.constant.annotaion;

import io.github.sztuwebclub.webvoyager.constant.enumerate.BusinessTypeEnum;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    String content() default "";

    BusinessTypeEnum businessType() ;
}
