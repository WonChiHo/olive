package com.coh.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.coh.schedule.ScheduleRegister;

@WebListener
public class Observer implements ServletContextListener {
	private ScheduleRegister sr;
	public static int userCount = 0;

	@Override
	public void contextInitialized(ServletContextEvent e) {
		e.getServletContext().setAttribute("userCount", userCount);
		sr = new ScheduleRegister();
		sr.execute();
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		sr.shutdownScheduler();
	}

	public static synchronized void incrementCount() {
		userCount++;
	}

	// 사용자 수를 감소시킴
	public static synchronized void decrementCount() {
		userCount--;
	}

	// 현재 사용자 수 반환
	public static synchronized int getCount() {
		return userCount;
	}
}
