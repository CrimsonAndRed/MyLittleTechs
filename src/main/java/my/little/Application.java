package my.little;

import ch.qos.logback.core.util.Loader;
import io.micronaut.runtime.Micronaut;
import ch.qos.logback.classic.util.ContextInitializer;

import java.net.URL;


public class Application {

    public static void main(String[] args) {
        configureLogger();
        Micronaut
                .build(args)
                .banner(false)
                .start();
    }

    public static void configureLogger() {
        String micronautEnvironments = System.getenv("MICRONAUT_ENVIRONMENTS");

        if (micronautEnvironments != null && !micronautEnvironments.isEmpty()) {
            String[] envs = micronautEnvironments.split(",");
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            for (String env : envs) {
                String logfile = "logback-" + env + ".xml";
                URL result = Loader.getResource(logfile, loader);
                if (result != null) {
                    System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, logfile);
                }
            }
        }
    }
}
