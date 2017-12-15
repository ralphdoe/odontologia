package co.microservices.costCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CostCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostCenterApplication.class, args);
    }
}
