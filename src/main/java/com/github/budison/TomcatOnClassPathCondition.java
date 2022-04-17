package com.github.budison;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Kevin Nowak
 */
class TomcatOnClassPathCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        try {
            Class.forName("org.apache.catalina.startup.Tomcat");
        } catch (ClassNotFoundException e) {
            System.err.println("not found" + e.getMessage());
            return false;
        }
        return true;
    }
}
