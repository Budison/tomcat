package com.github.budison;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin Nowak
 */
@Configuration
public class DefaultConfig {
    @Bean
    @Conditional(TomcatOnClassPathCondition.class)
    TomcatLauncher launch() {
        return new TomcatLauncher();
    }
}
