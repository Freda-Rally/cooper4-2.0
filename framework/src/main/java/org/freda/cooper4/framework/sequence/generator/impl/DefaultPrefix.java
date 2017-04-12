package org.freda.cooper4.framework.sequence.generator.impl;

import org.freda.cooper4.framework.sequence.exception.PrefixCreateException;
import org.freda.cooper4.framework.sequence.generator.Model;
import org.freda.cooper4.framework.sequence.generator.Prefix;
import org.freda.cooper4.framework.utils.DateUtils;

/**
 * 前缀生成器.
 *
 * Created by rally on 2017/4/11.
 */
public class DefaultPrefix implements Prefix
{
    /**
     * 是否需要加日期
     */
    private boolean withDate = false;
    /**
     * 日期格式.
     */
    private String datePattern = "yyyyMMdd";

    public DefaultPrefix(){}

    public DefaultPrefix(boolean withDate,String datePattern)
    {
        this.withDate = withDate;

        if (datePattern != null && !datePattern.equals(""))
            this.datePattern = datePattern;
    }

    /**
     * 生成前缀.
     * @return
     * @throws PrefixCreateException
     */
    @Override
    public String create(Model model) throws PrefixCreateException
    {
        try
        {
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(model.getPrefix());

            if (withDate)
            {
                stringBuffer.append(DateUtils.getCurrentTime(datePattern));
            }
            return stringBuffer.toString();
        }
        catch (Exception e)
        {
            throw new PrefixCreateException("prefix create failed!");
        }
    }
    public boolean isWithDate()
    {
        return withDate;
    }

    public void setWithDate(boolean withDate)
    {
        this.withDate = withDate;
    }

    public String getDatePattern()
    {
        return datePattern;
    }

    public void setDatePattern(String datePattern)
    {
        this.datePattern = datePattern;
    }
}
