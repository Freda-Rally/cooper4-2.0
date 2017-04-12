package org.freda.cooper4.framework.sequence.generator;

import org.freda.cooper4.framework.sequence.exception.SeqBaseException;

/**
 * 发生器接口.
 *
 * Created by rally on 2017/4/11.
 */
public interface Generator
{
    /**
     *
     * 生成ID
     *
     * @return ID
     * @throws SeqBaseException
     */
    String create(String id) throws SeqBaseException;
}
