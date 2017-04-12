package org.freda.cooper4.framework.web;

import org.freda.cooper4.framework.datastructure.Dto;
import org.freda.cooper4.framework.datastructure.impl.BaseDto;
import org.freda.cooper4.framework.datastructure.impl.RequestDto;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * controller的基类
 *
 * Created by rally on 2017/4/11.
 */
public abstract class BaseController
{
    private HttpServletRequest request;

    private HttpServletResponse response;

    protected Dto params;

    /**
     * 请求将自动设置request 与 response
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response)
    {
        this.request = request;

        this.response = response;

        this.params = RequestDto.create(request,response);
    }

    /**
     * 获取一个Session属性对象
     *
     * @param sessionKey
     * @return
     */
    protected Object getSessionAttribute(String sessionKey)
    {
        HttpSession session = request.getSession(false);

        return session != null ? session.getAttribute(sessionKey) : null;
    }

    /**
     * 设置一个Session属性对象
     *
     * @param objSessionAttribute
     * @return
     */
    protected void setSessionAttribute(String sessionKey, Object objSessionAttribute)
    {
        HttpSession session = request.getSession();

        if (session != null)
            session.setAttribute(sessionKey, objSessionAttribute);
    }

    /**
     * 移除Session对象属性值
     *
     * @param sessionKey
     * @return
     */
    protected void removeSessionAttribute( String sessionKey)
    {
        HttpSession session = request.getSession();

        if (session != null)
            session.removeAttribute(sessionKey);
    }

    /**
     * 输出响应
     *
     * @param str
     * @throws IOException
     */
    protected void write(String str) throws IOException
    {
        response.getWriter().write(str);

        response.getWriter().flush();

        response.getWriter().close();
    }

    /**
     *
     * 交易成功提示信息
     *
     * @param pMsg
     *            提示信息
     * @return
     * @throws IOException
     */
    protected void setOkTipMsg(String pMsg) throws IOException
    {
        write(new BaseDto(true, pMsg).toJson());
    }

    /**
     *
     * 交易失败提示信息(特指：业务交易失败并不是请求失败)<br>
     * 和Form的submit中的failur回调对应,Ajax.request中的fail回调是值请求失败
     *
     * @param pMsg
     *            提示信息
     * @param response
     * @return
     * @throws IOException
     */
    protected void setErrTipMsg(String pMsg, HttpServletResponse response) throws IOException
    {
        write(new BaseDto(false, pMsg).toJson());
    }
}
