import com.mashape.unirest.http.exceptions.UnirestException;
import org.freda.cooper4.framework.utils.HttpUtils;
import org.junit.Test;

/**
 * Created by rally on 2016/11/21.
 */
public class HttpUtilsTest
{
    @Test
    public void headerTest() throws UnirestException
    {
        HttpUtils.post("",null,false);

        HttpUtils.post("",null,false);
    }
}
