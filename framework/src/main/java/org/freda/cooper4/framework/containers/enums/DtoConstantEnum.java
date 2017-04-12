package org.freda.cooper4.framework.containers.enums;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Dto中特殊变量的枚举类
 *
 * Created by rally on 2017/4/11.
 */
public enum DtoConstantEnum
{
    /**
     * request
     */
    HTTP_SERVLET_REQUEST("_CONSTANT_HTTP_SERVLET_REQUEST", HttpServletRequest.class),
    /**
     * response
     */
    HTTP_SERVLET_RESPONSE("_CONSTANT_HTTP_SERVLET_RESPONSE", HttpServletResponse.class);

    private String key;

    private Class value;

    DtoConstantEnum(String key,Class value)
    {
        this.key = key;

        this.value = value;
    }


    public String getKey()
    {
        return key;
    }

    public Class getValue()
    {
        return value;
    }
}
