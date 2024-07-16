package com.coh.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.coh.service.MembershipService;

public class DefaultSchedule implements Job{
	private MembershipService membershipService;
	
	
	public DefaultSchedule() {
		membershipService = new MembershipService();
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//여기에 앞으로 실행할 잡 등록
		membershipService.updateUsersLevel();
	}
	
	
	
}
