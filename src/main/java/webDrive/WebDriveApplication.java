package webDrive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class WebDriveApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebDriveApplication.class);
    }
}
