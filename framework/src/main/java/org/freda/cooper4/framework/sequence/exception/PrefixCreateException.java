package org.freda.cooper4.framework.sequence.exception;

/**
 * 前缀Exception
 *
 * Created by rally on 2017/4/11.
 */
public class PrefixCreateException extends SeqBaseException
{
    private static final String EXCEPTION_HEAD = "ID前缀创建异常:";

    public PrefixCreateException()
    {
        super("ID前缀创建异常!");
    }

    public PrefixCreateException(String message)
    {
        super(EXCEPTION_HEAD + message);
    }

    public PrefixCreateException(String message,Throwable throwable)
    {
        super(EXCEPTION_HEAD + message,throwable);
    }

    public PrefixCreateException(Throwable throwable)
    {
        super(throwable);
    }
}
