package org.freda.cooper4.framework.datastructure.impl;

import org.freda.cooper4.framework.datastructure.Dto;
import org.freda.cooper4.framework.containers.enums.DtoConstantEnum;
import org.freda.cooper4.framework.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求Dto.
 *
 * Created by rally on 2017/4/11.
 */
public class RequestDto extends BaseDto
{
    /**
     * 获取当前对象.
     *
     * @param request request
     * @return Dto
     */
    public static Dto create(HttpServletRequest request, HttpServletResponse response)
    {
        Dto pDto = WebUtils.getParamsAsDto(request);

        pDto.put(DtoConstantEnum.HTTP_SERVLET_REQUEST.getKey(),request);

        pDto.put(DtoConstantEnum.HTTP_SERVLET_RESPONSE.getKey(),response);

        return pDto;
    }
}
