package com.zxc;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.naming.resources.VirtualDirContext;

import java.io.File;

/**
 * Description:
 * User: blkfhusky
 * Date: 2018-06-22
 * Time: 下午2:41
 */
public class Starter {

    public static void main(String[] args) throws Exception {
        final Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);
        tomcat.setBaseDir("/target/tomcat");
        final Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        context.setSessionCookieName("TKSESSID");
        final File additionWebInfClasses = new File("target/classes");
        final VirtualDirContext resources = new VirtualDirContext();
        resources.setExtraResourcePaths("/WEB-INF/classes=" + additionWebInfClasses);
        context.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();
    }

}
