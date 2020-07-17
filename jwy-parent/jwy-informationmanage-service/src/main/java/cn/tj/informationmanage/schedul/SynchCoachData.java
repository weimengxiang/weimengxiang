package cn.tj.informationmanage.schedul;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.tj.service.api.CoachGttHanderService;
/**
 * 数据同步定时任务
 * @author lizhi
 *
 */
@Component
public class SynchCoachData {
	private static final Logger LOG = LogManager.getLogger(SynchCoachData.class);
	@Autowired
	private CoachGttHanderService coachGtthanderService;
	
	@Scheduled(fixedDelay = 20000)
	public void Task(){
		new Thread(new Runnable() {
			@Override
			public void run() {
            coachGtthanderService.SynchCoachData();
			}
		}).start();
	}
	
	public void Tsak1(){
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		newSingleThreadExecutor.submit(new Runnable() {
			public void run() {
				coachGtthanderService.SynchCoachData();
			}
		});
		newSingleThreadExecutor.shutdown();
		while (true) {
			if(newSingleThreadExecutor.isTerminated()){
				LOG.info("stop all success....");
				break;
			}
		}
	}
	
}
