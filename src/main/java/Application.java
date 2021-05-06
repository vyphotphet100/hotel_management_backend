import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.hotelmanagement")
@EnableJpaRepositories("com.hotelmanagement.repository")
@EntityScan("com.hotelmanagement.entity")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableScheduling
public class Application {

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

}