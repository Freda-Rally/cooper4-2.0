package org.freda.cooper4.server.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 项目入口
 *
 * Created by rally on 2017/2/7.
 */
@SpringBootApplication
@EnableAuthorizationServer
public class Application
{
    /**
     * Oauth2-server启动
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication springApplication = new SpringApplication(Application.class);

        springApplication.addListeners(new ApplicationPidFileWriter());

        springApplication.run(args);
    }
}
