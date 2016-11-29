import org.freda.cooper4.framework.annotations.api.ApiVersion;

/**
 * Created by rally on 2016/11/15.
 */

public class AnnotationTest
{
    @ApiVersion(2)
    public void run()
    {

    }

    public static void main(String[] args)
    {
        new AnnotationTest();
    }
}
