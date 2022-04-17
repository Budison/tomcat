package com.github.budison;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.annotation.PostConstruct;

/**
 * @author Kevin Nowak
 */
class TomcatLauncher {
    @PostConstruct
    void start() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        final Context ctx = tomcat.addContext("", null);
        tomcat.addServlet(ctx, "siemano", new HelloServlet());
        ctx.addServletMappingDecoded("/", "siemano");
        tomcat.setPort(8080);
        tomcat.start();
        tomcat.getServer().await();

        new Thread( () -> tomcat.getServer().await(), "tomkacie-lives!").start();
    }
}
