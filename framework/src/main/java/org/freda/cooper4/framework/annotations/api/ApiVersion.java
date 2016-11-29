package org.freda.cooper4.framework.annotations.api;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 接口版本自动适配注解
 *
 * Created by rally on 2016/11/15.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion
{
    /**
     * 版本号
     * @return
     */
    int value() default 1;
}
