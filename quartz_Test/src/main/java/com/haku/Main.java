package com.haku;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        //获取调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //包装任务内容
        JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();
        //定义触发器
        // Trigger trigger = newTrigger().withIdentity("TRIGGER1", "GROUP1").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
        Trigger trigger = newTrigger().withIdentity("TRIGGER1", "GROUP1").startNow().withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).build();
        //组装任务
        scheduler.scheduleJob(job, trigger);
        //启动调度器 开始调度
        scheduler.start();
        scheduler.shutdown();


    }
}
