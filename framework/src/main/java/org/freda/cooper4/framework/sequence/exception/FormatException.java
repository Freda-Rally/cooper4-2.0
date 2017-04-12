package org.freda.cooper4.framework.sequence.exception;

/**
 * 增长序列化格式化Exception
 *
 * Created by rally on 2017/4/11.
 */
public class FormatException extends SeqBaseException
{
    private static final String EXCEPTION_HEAD = "格式化序号异常:";

    public FormatException()
    {
        super("格式化序号异常!");
    }

    public FormatException(String message)
    {
        super(EXCEPTION_HEAD + message);
    }

    public FormatException(String message, Throwable throwable)
    {
        super(EXCEPTION_HEAD + message,throwable);
    }

    public FormatException(Throwable throwable)
    {
        super(throwable);
    }
}
