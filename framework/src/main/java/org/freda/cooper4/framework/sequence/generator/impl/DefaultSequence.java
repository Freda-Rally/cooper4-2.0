package org.freda.cooper4.framework.sequence.generator.impl;

import org.freda.cooper4.framework.sequence.generator.Model;
import org.freda.cooper4.framework.sequence.exception.SequenceCreateException;
import org.freda.cooper4.framework.sequence.generator.Sequence;
import org.freda.cooper4.framework.sequence.generator.Store;

/**
 * 序列.
 *
 * Created by rally on 2017/4/12.
 */
public class DefaultSequence implements Sequence
{
    private static final long MIN_VALUE = Long.MIN_VALUE;

    private static final long MAX_VALUE = Long.MAX_VALUE;

    /**
     * 存储
     */
    private Store store;
    /**
     * 是否允许循环使用.
     */
    private boolean cycle = false;

    public DefaultSequence()
    {
        this.store = new MemoryStore();
    }

    public DefaultSequence(Store store, boolean cycle)
    {
        this.store = store;

        this.cycle = cycle;
    }

    /**
     * 获取下一个
     *
     * @return 下一个
     * @throws SequenceCreateException
     */
    @Override
    public Model next(String sequenceId) throws SequenceCreateException
    {
        synchronized (store)
        {
            Model model = store.load(sequenceId);

            if (model.getSequence() < Math.max(MIN_VALUE,model.getMin()) ||
                    (model.getSequence() > Math.min(MAX_VALUE,model.getMax()) && !cycle))
            {
                throw new SequenceCreateException("sequence is out of bound. : " + model.getSequence());
            }
            model.setSequence(model.getSequence() + model.getStep());

            store.update(model);

            return model;
        }
    }


    public Store getStore()
    {
        return store;
    }

    public void setStore(Store store)
    {
        this.store = store;
    }
}
