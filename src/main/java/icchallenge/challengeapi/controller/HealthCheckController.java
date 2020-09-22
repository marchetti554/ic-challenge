package icchallenge.challengeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller in charge of application health related operations.
 *
 * @author Marco Marchetti
 */
@RestController
public class HealthCheckController {

    private static final String STATUS_HEALTHY = "Healthy";

    /**
     * Returns the application health status.
     *
     * @return a String indicating the application health
     */
    @GetMapping("/health")
    public String getHealthCheck() {
        return STATUS_HEALTHY;
    }
}
