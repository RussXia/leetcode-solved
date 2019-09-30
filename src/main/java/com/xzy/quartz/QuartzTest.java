package com.xzy.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author xiazhengyue
 * @since 2019-03-04
 */
@Slf4j
public class QuartzTest {

    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("myJob", "group1")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();

            JobDetail job2 = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("myJob2", "group1")
                    .usingJobData("jobSays", "Hello World!--2")
                    .usingJobData("myFloatValue", 3.1415926f)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .withIntervalInSeconds(5).repeatForever())
                    .build();

            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger2", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .withIntervalInSeconds(8).repeatForever())
                    .build();
            scheduler.scheduleJob(job,trigger);
            scheduler.scheduleJob(job2,trigger2);
        } catch (SchedulerException ex) {
            ex.printStackTrace();
        }

    }
}
