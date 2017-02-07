package org.freda.cooper4.server.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * 配置Oauth2 权限设置
 *
 * Created by rally on 2017/2/7.
 */
@Configuration
public class Auth2ServerConfigAdapter extends AuthorizationServerConfigurerAdapter
{
    /**
     * 具体授权是基于JDBC实现.
     *
     * @param clients clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                .secret("secret") // client_secret
                .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
                .scopes("app"); // 允许的授权范围
    }
}
