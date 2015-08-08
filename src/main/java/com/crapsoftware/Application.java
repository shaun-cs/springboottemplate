package com.crapsoftware;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;

/**
 * Main Application - should be at the root of the package above all other classes
 *
 * Spring Boot favors Java-based configuration. Although it is possible to call SpringApplication.run() with an XML source,
 * it is generally recommended that the primary source is a @Configuration class.
 * Usually the class that defines the main method is also a good candidate as the primary @Configuration.
 * Not all @Configuration needs to be put into a single class. The @Import annotation can be used to import
 * additional configuration classes. Alternatively, you can use @ComponentScan to automatically pickup 
 * all Spring components, including @Configuration classes.
 * If XML based configuration must be used, the recommendation is to still start with a @Configuration class,
 * and then use additional @ImportResource annotations to load XML configuration files.
 * 
 * Spring Boot auto-configuration attempts to automatically configure the Spring application based on the jar dependencies 
 * that have been added. For example, if HSQLDB is on the classpath, and there is no manual configuration of any database 
 * connection beans, then it will auto-configure an in-memory database.
 * You need to opt-in to auto-configuration by adding the @EnableAutoConfiguration or @SpringBootApplication annotations 
 * to one of your @Configuration classes.
 * 
 * Auto-configuration is noninvasive; you can start to define your own configuration to replace specific parts of the auto-configuration.
 * For example, if you add your own DataSource bean, the default embedded database support will back away.
 * If you need to find out what auto-configuration is currently being applied, and why, starting your application with the --debug switch
 * will log an auto-configuration report to the console.
 * If you find that specific auto-configure classes are being applied that you don’t want, you can use the exclude attribute of @EnableAutoConfiguration to disable them:
 * e.g. @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
 * 
 * You are free to use any of the standard Spring Framework techniques to define your beans and their injected dependencies.
 * For simplicity, we often find that using @ComponentScan to find your beans, in combination with @Autowired constructor 
 * injection works well.
 * If you structure your code as suggested above (locating your application class in a root package), 
 * you can add @ComponentScan without any arguments. 
 * All of your application components (@Component, @Service, @Repository, @Controller etc.) will be automatically 
 * registered as Spring Beans.
 * 
 * Many Spring Boot developers always have their main class annotated with @Configuration, @EnableAutoConfiguration and @ComponentScan. 
 * Since these annotations are so frequently used together (especially if you follow the best practices above), 
 * Spring Boot provides a convenient @SpringBootApplication alternative.
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan 
 * with their default attributes
 * 
 * If you use the Spring Boot Maven or Gradle plugins to create an executable jar you can run your application using java -jar:
 * e.g. java -jar target/myproject-0.0.1-SNAPSHOT.jar
 * It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:
 * e.g. java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/myproject-0.0.1-SNAPSHOT.jar
 * The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. 
 * Applications run in an exploded form, and you can edit resources for instant “hot” reload:
 * e.g. mvn spring-boot:run
 * You might also want to use the useful operating system environment variable:
 * export MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=128M -Djava.security.egd=file:/dev/./urandom
 * (The “egd” setting is to speed up Tomcat startup by giving it a faster source of entropy for session keys.)
 */
@Configuration //indicates this is a configuration class i.e. instead of doing all the configuration in XML
@EnableAutoConfiguration //implicitly defines a base “search package” i.e. class will be used to search for @Entity items in JPA apps
@ComponentScan //Using a root package also allows this to be used without needing to specify a basePackage attribute
public class Application 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
}
