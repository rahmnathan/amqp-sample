package com.github.rahmnathan.amqp.consumer;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.connection.CachingConnectionFactory;

@SpringBootApplication
public class Executable {

    public static void main(String[] args) {
        SpringApplication.run(Executable.class, args);
    }

    @Bean(name = "cachedConnectionFactory")
    public CachingConnectionFactory jmsCachingConnectionFactory(){
        JmsConnectionFactory pool = new JmsConnectionFactory();
        pool.setRemoteURI("amqp://192.168.1.8:5672");
        pool.setUsername("guest");
        pool.setPassword("guest");

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(pool);
        return cachingConnectionFactory;
    }
}
