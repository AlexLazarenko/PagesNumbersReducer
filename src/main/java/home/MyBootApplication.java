package home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class using to start application
 * <p>
 * Application that assist user with getting reduced form
 * for arbitrary set of page numbers that user would like to print.
 *
 * @author Alex Lazarenko
 * @since 2019-12-11
 */

@SpringBootApplication
@EnableSwagger2
public class MyBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class);
    }
}
