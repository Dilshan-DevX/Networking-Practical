package org.example.np;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.np.config.appConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;
import java.sql.SQLOutput;

public class Main {

    private static final String API_PATH = "/api/v1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Main.SERVER_PORT);
        tomcat.getConnector();

        Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        Tomcat.addServlet(context,"API_Servlet", new ServletContainer(new appConfig()));
        context.addServletMappingDecoded(API_PATH + "/*", "API_Servlet");

        try {
            tomcat.start();
            System.out.println("Server started at http://localhost:"+SERVER_PORT+API_PATH);
            tomcat.getServer().await();
        }catch (LifecycleException e) {
            throw new RuntimeException(e);
        }


    }
}