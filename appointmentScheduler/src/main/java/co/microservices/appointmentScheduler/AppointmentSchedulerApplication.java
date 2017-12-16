package co.microservices.appointmentScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppointmentSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentSchedulerApplication.class, args);
    }
}
