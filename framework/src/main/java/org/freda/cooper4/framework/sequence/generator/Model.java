package org.freda.cooper4.framework.sequence.generator;

import java.io.Serializable;

/**
 * Created by rally on 2017/4/11.
 */
public abstract class Model implements Serializable
{
    /**
     * 序列唯一标识
     */
    private String sequenceId;
    /**
     * 序列最小
     */
    private long min;
    /**
     * 序列最大
     */
    private long max;
    /**
     * 步伐
     */
    private long step;
    /**
     * 当前序列值
     */
    private long sequence;
    /**
     * 序列格式化
     */
    private String pattern;
    /**
     * 前缀
     */
    private String prefix;


    public Model(String sequenceId)
    {
        this.sequenceId = sequenceId;

        this.min = 0L;

        this.max = Long.MAX_VALUE;

        this.sequence = 0;

        this.step = 1;

        this.pattern = "";

        this.prefix = "";
    }

    public String getSequenceId()
    {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    public long getMin()
    {
        return min;
    }

    public void setMin(long min)
    {
        this.min = min;
    }

    public long getMax()
    {
        return max;
    }

    public void setMax(long max)
    {
        this.max = max;
    }

    public long getSequence()
    {
        return sequence;
    }

    public void setSequence(long sequence)
    {
        this.sequence = sequence;
    }

    public String getPattern()
    {
        return pattern;
    }

    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public long getStep()
    {
        return step;
    }

    public void setStep(long step)
    {
        this.step = step;
    }
}
