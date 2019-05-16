package com.run.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
//@ConfigurationProperties
// 使用  PropertySource获取配置文件中定义的数据 ，在该类中获取
// 使用 前缀的时候就可以不适用 @Value进行注入
@ConfigurationProperties(prefix = "web")
public class ServerSettings {
//    应用名称,有一个前缀，前缀可以配置去掉
//    @Value("${web.name}")
    private String name;

    //    域名地址
    private String domain;
    public ServerSettings(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    public ServerSettings() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
