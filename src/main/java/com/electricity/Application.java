package com.electricity;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        setDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env){
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if(StringUtils.isBlank(contextPath)){
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        }catch (UnknownHostException e){
            log.warn("The host name could not be determined, using 'localhost' as fallback");
        }

        log.info("""
                
                ----------------------------------------------------------
                \tApplication '{}' is running! Access URLs:
                \tLocal: \t\t{}://localhost{}{}
                \tExternal: \t{}://{}:{}{}
                \tProfile(s): \t{}
                -------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles().length == 0 ? env.getDefaultProfiles() : env.getActiveProfiles());
    }

    private static void setDefaultProfile(SpringApplication app){
        final String profileProperty = "spring.profiles.default";
        final Map<String, Object> properties = new HashMap<>();
        properties.put(profileProperty, "dev");
        app.setDefaultProperties(properties);
    }
}
