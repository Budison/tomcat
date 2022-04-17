package com.github.budison;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class Main {
    @Configuration
    @Import(DefaultConfig.class)
    public static class MyConfig {

    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MyConfig.class);
    }
}	
