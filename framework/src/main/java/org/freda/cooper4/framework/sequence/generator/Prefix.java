package org.freda.cooper4.framework.sequence.generator;

import org.freda.cooper4.framework.sequence.exception.PrefixCreateException;

/**
 * Created by rally on 2017/4/11.
 */
public interface Prefix
{
    /**
     * 创建前缀
     * @return
     * @throws PrefixCreateException
     */
    String create(Model model) throws PrefixCreateException;
}
