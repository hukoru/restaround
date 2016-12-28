package batch.restaround;

import batch.restaround.config.BatchScheduleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 배치 서버 어플리케이션에 시작점
 * @author 임세환
 */
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
@Import({BatchScheduleConfiguration.class})
public class RestaroundBatchApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestaroundBatchApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}
