package org.freda.cooper4.framework.sequence.generator;

import org.freda.cooper4.framework.sequence.exception.FormatException;

/**
 * Created by rally on 2017/4/11.
 */
public interface Format
{
    String format(Model model) throws FormatException;
}
