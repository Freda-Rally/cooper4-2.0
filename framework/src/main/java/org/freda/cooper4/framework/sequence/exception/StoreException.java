package org.freda.cooper4.framework.sequence.exception;

/**
 * 存储Exception
 *
 * Created by rally on 2017/4/11.
 */
public class StoreException extends SeqBaseException
{
    private static final String EXCEPTION_HEAD = "序号存储异常:";

    public StoreException()
    {
        super("存储触发需要异常.");
    }

    public StoreException(String message, Throwable cause)
    {
        super(EXCEPTION_HEAD + message, cause);
    }

    public StoreException(String message)
    {
        super(EXCEPTION_HEAD + message);
    }

    public StoreException(Throwable cause)
    {
        super(cause);
    }
}
