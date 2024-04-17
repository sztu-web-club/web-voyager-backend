package io.github.sztuwebclub.webvoyager.bootstrap.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
public class ZookeeperConfig implements Serializable
{
    private static final long serialVersionUID = -9025878246972668136L;
    @Value("${zookeeper.baseSleepTime}")
    private int baseSleepTime;
    @Value("${zookeeper.maxRetries}")
    private int maxRetries;
    @Value("${zookeeper.connectString}")
    private String connectString;
    @Value("${zookeeper.connectionTimeoutMs}")
    private int connectionTimeoutMs;
    @Value("${zookeeper.sessionTimeoutMs}")
    private int sessionTimeoutMs;

    @Bean
    public CuratorFramework createWithOptions()
    {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                .retryPolicy(new ExponentialBackoffRetry(baseSleepTime, maxRetries))
                .build();
        client.start();
        return client;
    }
}
