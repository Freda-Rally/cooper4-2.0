package org.freda.cooper4.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config-Server 服务入口
 *
 * Created by rally on 2016/11/11.
 */
@EnableConfigServer
@SpringBootApplication
public class Application
{
    /**
     * config-server启动
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
