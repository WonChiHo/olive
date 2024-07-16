package com.coh.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public class ScheduleRegister {
	private Scheduler scheduler;
	public ScheduleRegister() {
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		try {

			scheduler = new StdSchedulerFactory().getScheduler();
			
			scheduler.scheduleJob(
					newJob(DefaultSchedule.class)
                    .withIdentity("defaultSchedule", "group1")
                    .build(),
            newTrigger()
                    .withIdentity("defaultTrgger", "group1")
                    .withSchedule(cronSchedule("0 0 0 1 * ?"))
                    .build());
			
			scheduler.scheduleJob(
					newJob(BirthdayScheduler.class)
                    .withIdentity("birthdaySchedule", "group2")
                    .build(),
            newTrigger()
                    .withIdentity("birthdayTrgger", "group2")
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
                    .build());
			
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void shutdownScheduler() {
		 try {
	            scheduler.shutdown();
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	}

}
