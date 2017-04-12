package org.freda.cooper4.framework.sequence.generator.impl;

import org.freda.cooper4.framework.sequence.exception.FormatException;
import org.freda.cooper4.framework.sequence.generator.Format;
import org.freda.cooper4.framework.sequence.generator.Model;

import java.text.DecimalFormat;

/**
 *
 *
 * Created by rally on 2017/4/11.
 */
public class DefaultFormat implements Format
{
    @Override
    public String format(Model model) throws FormatException
    {
        if (model.getPattern() == null)
        {
            throw new FormatException("正则表达式为空.");
        }
        try
        {
            DecimalFormat df = new DecimalFormat(model.getPattern());

            return df.format(model.getSequence());
        }
        catch (Throwable e)
        {
            throw new FormatException("格式化出错.",e);
        }
    }
}
