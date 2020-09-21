package icchallenge.challengeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthcheckController {

    @Autowired
    private Environment env;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Hello World!";
    }

    @GetMapping("/test-aws")
    public Map<String, String> testAwsUrl() {
        return Map.of("awsUrl", env.getProperty("spring.datasource.url"));
    }
}
