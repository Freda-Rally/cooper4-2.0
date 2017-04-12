import org.freda.cooper4.framework.sequence.generator.Generator;
import org.freda.cooper4.framework.sequence.generator.impl.DefaultGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rally on 2017/4/11.
 */
public class SeqGeneratorTest
{

    public static void main(String[] args)
    {
        ExecutorService pool = Executors.newFixedThreadPool(1000);

        Generator generator = new DefaultGenerator();

        for (int i=0;i<100000;i++)
        {
            final int d = i%2;

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generator.create("RUN" + d));
                }
            });
        }


    }
}
