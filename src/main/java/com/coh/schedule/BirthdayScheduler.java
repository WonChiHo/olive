package com.coh.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.coh.service.MembershipService;

public class BirthdayScheduler implements Job{
	private MembershipService membershipService;
	public BirthdayScheduler() {
		membershipService = new MembershipService();
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		membershipService.publishBirthdayCoupon();
	}
}
