package org.freda.cooper4.framework.lock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Distributed Lock used by redis
 *
 * Created by rally on 2017/4/13.
 */
public class RedisDistributedLock implements Lock
{
    private static final Log log = LogFactory.getLog(RedisDistributedLock.class);

    protected StringRedisTemplate redisTemplate;

    private String lock_key ;

    public static final String LOCKED = "LOCKED";

    private static final long TIME_OUT = 30000;

    private volatile boolean locked = false;


    public RedisDistributedLock(String lock , StringRedisTemplate redisTemplate)
    {
        this.lock_key = "_LOCK_" + lock.toUpperCase();
    }

    @Override
    public void lock()
    {
        try
        {
            final Random r = new Random();

            while (true)
            {
                if (tryLock())
                {
                    break;
                }
                Thread.sleep(3,r.nextInt(500));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("lock failed!",e);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException
    {

    }

    @Override
    public boolean tryLock()
    {
        if (redisTemplate.getConnectionFactory().getConnection().setNX(lock_key.getBytes(),LOCKED.getBytes()))
        {
            redisTemplate.expire(lock_key,TIME_OUT,TimeUnit.MILLISECONDS);

            locked = true;

            log.debug("lock RedisLock[" + lock_key + "].");

            return true;
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
    {
        long nano = System.nanoTime();

        try
        {
            final Random r = new Random();

            while ((System.nanoTime() - nano) < unit.toMillis(time))
            {
                if (tryLock())
                {
                    break;
                }
                Thread.sleep(3,r.nextInt(500));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("lock failed!",e);
        }


        return false;
    }

    @Override
    public void unlock()
    {
        if (locked)
        {
            log.debug("unlock RedisLock[" + lock_key + "].");

            redisTemplate.delete(lock_key);
        }
    }

    @Override
    public Condition newCondition()
    {
        return null;
    }
}
