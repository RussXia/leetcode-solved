package com.xzy.quartz;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * @author xiazhengyue
 * @since 2019-03-04
 */
@Data
@Slf4j
public class HelloJob implements Job {

    private String jobSays;

    private float myFloatValue;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("[Hello World----1111]");
        JobKey key = context.getJobDetail().getKey();
        log.info("[Job key: {}]", key);
//        JobDataMap dataMap = context.getMergedJobDataMap();  // Note the difference from the previous example
        log.info("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);

        log.info("[trigger name : {}]", context.getTrigger().getKey().getName());
    }
}
