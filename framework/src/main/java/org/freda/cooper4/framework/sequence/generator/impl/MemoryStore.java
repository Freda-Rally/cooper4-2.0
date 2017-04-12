package org.freda.cooper4.framework.sequence.generator.impl;

import org.apache.commons.collections.map.HashedMap;
import org.freda.cooper4.framework.sequence.generator.Model;
import org.freda.cooper4.framework.sequence.exception.StoreException;
import org.freda.cooper4.framework.sequence.generator.Store;

import java.util.Map;

/**
 * 内存存储器
 *
 * Created by rally on 2017/4/11.
 */
public class MemoryStore implements Store
{
    private static final Map<String,Model> SEQ_DATA = new HashedMap();
    /**
     * 更新
     *
     * @throws StoreException
     */
    @Override
    public void update(final Model model) throws StoreException
    {
        SEQ_DATA.put(model.getSequenceId(),model);
    }

    /**
     * 加载当前最大.
     *
     * @param pSequenceId
     * @throws StoreException
     */
    @Override
    public Model load(final String pSequenceId) throws StoreException
    {
        Model model = SEQ_DATA.get(pSequenceId);

        if (model == null)
        {
            Model newModel = new DefaultModel(pSequenceId);

            SEQ_DATA.put(pSequenceId,newModel);

            return newModel;
        }
        return model;
    }
}
