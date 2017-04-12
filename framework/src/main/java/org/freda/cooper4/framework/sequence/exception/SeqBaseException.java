package org.freda.cooper4.framework.sequence.exception;

/**
 * 序列父类Exception
 *
 * Created by rally on 2017/4/11.
 */
public class SeqBaseException extends RuntimeException
{
    public SeqBaseException()
    {
        super("ID发生异常.");
    }

    public SeqBaseException(String message,Throwable throwable)
    {
        super(message,throwable);
    }

    public SeqBaseException(String message)
    {
        super(message);
    }

    public SeqBaseException(Throwable throwable)
    {
        super(throwable);
    }
}
