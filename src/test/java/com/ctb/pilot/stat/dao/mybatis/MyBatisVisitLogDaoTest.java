package com.ctb.pilot.stat.dao.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class MyBatisVisitLogDaoTest {

	@Autowired
	private VisitLogDao visitLogDao;

	@Test
	public void testInsertVisitLog() {
		VisitLog visitLog = new VisitLog();
		visitLog.setIp("1.2.3.4");
		visitLog.setReferer("referer");
		visitLog.setUri("/");
		visitLog.setUserAgent("userAgent");

		visitLogDao.insertVisitLog(visitLog);
	}

	@Test
	public void testGetDailyVisitLog() {
		List<DailyVisitLog> dailyVisitLog = visitLogDao.getDailyVisitLogs();
		System.out.println(dailyVisitLog);
	}

}