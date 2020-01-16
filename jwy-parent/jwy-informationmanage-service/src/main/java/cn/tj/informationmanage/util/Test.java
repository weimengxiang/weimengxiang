package cn.tj.informationmanage.util;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tj.informationmanage.service.CoachBasicOperationService;
public class Test {
	@Autowired
	CoachBasicOperationService coachbasicoperationservice;
	
	 public static void main(String[] args) {
	
		
		 ExecutorService exexutors = Executors.newFixedThreadPool(20);
		 for(int i = 0; i<20; i++) {
			 exexutors.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 });
		 }
		 System.out.println("shutdowning");
		 exexutors.shutdown();
		 while (true) {
			boolean t = exexutors.isTerminated();
			System.out.println(t);
			if(t) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println("shutdowned");
		 
	}
}
