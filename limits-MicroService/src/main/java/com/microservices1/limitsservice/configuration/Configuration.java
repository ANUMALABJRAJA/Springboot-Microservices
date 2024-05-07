package com.microservices1.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits-service")
@Component
public class Configuration {
    private int minimum;
    private int maximun;

    public Configuration(int minimum, int maximun) {
        this.minimum = minimum;
        this.maximun = maximun;
    }

    public Configuration() {
    }

    public int getMinimun() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximun() {
        return maximun;
    }

    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }
}
