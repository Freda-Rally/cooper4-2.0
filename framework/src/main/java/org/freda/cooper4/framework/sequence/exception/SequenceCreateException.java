package org.freda.cooper4.framework.sequence.exception;

/**
 * 增长序列Exception
 *
 * Created by rally on 2017/4/11.
 */
public class SequenceCreateException extends SeqBaseException
{
    private static final String EXCEPTION_HEAD = "序号创建异常:";

    public SequenceCreateException()
    {
        super("序号创建异常!");
    }

    public SequenceCreateException(String message)
    {
        super(EXCEPTION_HEAD + message);
    }

    public SequenceCreateException(String message,Throwable throwable)
    {
        super(EXCEPTION_HEAD + message,throwable);
    }

    public SequenceCreateException(Throwable throwable)
    {
        super(throwable);
    }
}
