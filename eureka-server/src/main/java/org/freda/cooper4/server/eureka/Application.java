package org.freda.cooper4.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka-Server 入口
 *
 * Created by rally on 2016/11/29.
 */
@SpringBootApplication
@EnableEurekaServer
public class Application
{
    /**
     * Eureka-server启动
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
