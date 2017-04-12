package org.freda.cooper4.framework.sequence.generator;

import org.freda.cooper4.framework.sequence.exception.SequenceCreateException;

/**
 * Created by rally on 2017/4/11.
 */
public interface Sequence
{
    /**
     *
     * 获取下一个
     *
     * @return 下一个
     * @throws SequenceCreateException
     */
    Model next(String sequenceId)throws SequenceCreateException;
}
