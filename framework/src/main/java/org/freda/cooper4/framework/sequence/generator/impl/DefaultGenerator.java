package org.freda.cooper4.framework.sequence.generator.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.freda.cooper4.framework.sequence.exception.SeqBaseException;
import org.freda.cooper4.framework.sequence.generator.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 整体生成器.
 *
 * Created by rally on 2017/4/11.
 */
public class DefaultGenerator implements Generator
{

    private static final Log log = LogFactory.getLog(DefaultGenerator.class);

    private Lock lock = new ReentrantLock();
    /**
     * 前缀
     */
    private Prefix prefix;
    /**
     * 格式化seq
     */
    private Format format;
    /**
     * 增长序列
     */
    private Sequence sequence;

    public DefaultGenerator()
    {
        this.prefix = new DefaultPrefix(false,null);

        this.format = new DefaultFormat();

        this.sequence = new DefaultSequence();
    }

    public DefaultGenerator(Prefix prefix, Format format, Sequence sequence)
    {
        this.prefix = prefix;

        this.format = format;

        this.sequence = sequence;
    }

    /**
     * 生成ID
     *
     * @param id
     * @return ID
     * @throws SeqBaseException
     */
    @Override
    public String create(String id) throws SeqBaseException
    {
        synchronized (id.intern())
        {
            Model model = sequence.next(id);

            return prefix.create(model) + format.format(model);
        }
    }
}
