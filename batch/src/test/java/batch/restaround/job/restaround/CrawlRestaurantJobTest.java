package batch.restaround.job.restaround;

import batch.restaround.RestaroundBatchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.JobExecutionContextImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.mockito.Mockito.mock;

/**
 * @author 임세환
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaroundBatchApplication.class)
@EnableAutoConfiguration
public class CrawlRestaurantJobTest {

    private final Logger logger = LoggerFactory.getLogger(CrawlRestaurantJobTest.class);

    @Autowired @Qualifier("crawlRestaurantJob")
    private CrawlRestaurantJob crawlRestaurantJob;

    private TriggerFiredBundle firedBundle;

    @Test
    public void crawlRestaurantJobExecute(){
        JobDetail jobDetail = new JobDetailImpl();
        JobExecutionContext context = createContext(jobDetail);
        crawlRestaurantJob.setCrawlRestaurantJob(crawlRestaurantJob);
        crawlRestaurantJob.start(context);
    }


    @SuppressWarnings("serial")
    private final class StubJobExecutionContext extends JobExecutionContextImpl {
        private StubJobExecutionContext() {
            super(mock(Scheduler.class), firedBundle, mock(Job.class));
        }
    }

    private JobExecutionContext createContext(JobDetail jobDetail) {
        firedBundle = new TriggerFiredBundle(jobDetail, new SimpleTriggerImpl(), null, false, new Date(), new Date(), new Date(), new Date());
        return new StubJobExecutionContext();
    }


}
