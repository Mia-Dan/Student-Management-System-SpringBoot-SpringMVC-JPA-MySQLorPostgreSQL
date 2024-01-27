package org.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 其实这个小项目没必要用配置类：项目哪里用到@Value即可，总共也就4条，也不复用
@Data
@Component
@ConfigurationProperties(prefix = "alibaba.cloud")
public class AliOSSProperties {
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private Oss oss; // to match the structure of the properties in the application.yml file. // tested with pom.xml dependency: spring-boot-configuration-processor

    @Data
    public static class Oss {
        private String endpoint;
    }
}