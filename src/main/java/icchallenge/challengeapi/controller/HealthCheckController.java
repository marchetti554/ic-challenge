package icchallenge.challengeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {

    @Autowired
    private Environment env;

    private static final String STATUS_HEALTHY = "Healthy";

    private static final String SPRING_DATA_SOURCE_URL = "spring.datasource.url";

    private static final String PROPERTIES_KEY = "properties";
    private static final String AWS_URL_KEY = "aws.url";

    @GetMapping("/health")
    public String getHealthCheck() {
        return STATUS_HEALTHY;
    }

    @GetMapping("/health/all")
    public Map<String, ?> getHealthCheckAll() {
        return Map.of(PROPERTIES_KEY, System.getProperties(),
                AWS_URL_KEY, env.getProperty(SPRING_DATA_SOURCE_URL));
    }
}
