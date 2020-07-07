package io.todo.todoappp.controllers;


import io.todo.todoappp.models.HealthCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HealthcheckController {
    private static String klass = HealthcheckController.class.getSimpleName();
    private static Logger logger = Logger.getLogger(klass);

    @GetMapping("health-check")
    public HealthCheck get() {
        final var healthcheck = new HealthCheck(true);
        logger.info(healthcheck.toString());
        return healthcheck;
    }
}
