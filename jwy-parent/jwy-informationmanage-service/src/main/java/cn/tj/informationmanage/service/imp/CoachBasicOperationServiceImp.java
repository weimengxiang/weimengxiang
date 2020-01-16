package cn.tj.informationmanage.service.imp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.base.Stopwatch;

import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.informationmanage.mapper.CoachBasicOperationMapper;
import cn.tj.informationmanage.service.CoachBasicOperationService;
import cn.tj.informationmanage.util.annotation.InterfaceMonitor;


@Service(version="1.0.0",retries=0)

public class CoachBasicOperationServiceImp implements CoachBasicOperationService {

	private static final Logger LOG = LogManager.getLogger(CoachBasicOperationServiceImp.class);

	@Autowired
	CoachBasicOperationMapper coachbasicoperationmapper;
	
	@Override
	public void AddCoach(CoachVO coachvo) {
		coachbasicoperationmapper.AddCoach(coachvo);
		
	}

	@Override
	public void DeleteCoachById(int coahcid) {
		coachbasicoperationmapper.DeleteCoachById(coahcid);	
	}

	@Override
	public void BatchDeleteCoach(List<Integer> list) {
		coachbasicoperationmapper.BatchDeleteCoach(list);		
	}

	@Override
	public List<CoachVO> QueryCoachById(int coahcid) {
		List<CoachVO> list = coachbasicoperationmapper.QueryCoachById(coahcid);
		return list;
	}

	@Override
	public List<CoachVO> QueryCoachCurrency(CoachVO coachvo) {
		List<CoachVO> list = coachbasicoperationmapper.QueryCoachCurrency(coachvo);
		return null;
	}

	@Override
	public void UpdateCoach(CoachVO coachvo) {
		coachbasicoperationmapper.UpdateCoach(coachvo);		
	}

	@Override
	@InterfaceMonitor()
	public void BatchAddCoach(List<CoachVO> list) {
		syschHander1();
		//syschHander2();
		//syschHander3();
		
	}
	
	public void syschHander3(){
		List<CoachVO> oldlist = GetMoniDataUtil(); 
		Stopwatch stopwatch = Stopwatch.createStarted();
		int count = 2000; //每条线程处理万条数据
		int listsize = oldlist.size();//总数据条数
		int runsize = (listsize/count)+1;//开启线程数
		ExecutorService exexutors = Executors.newFixedThreadPool(runsize);
		for(int i=0;i<runsize;i++){
			int startindex ;
		    int endindex ;
			//存放每个线程的执行数据
			if(runsize==(i+1)){
				 startindex = i*count;
				 endindex = oldlist.size();
				 LOG.info("数据段："+startindex+"----->"+endindex+"执行！.........");	
				final List<CoachVO> runlist =  splitList(oldlist, startindex, endindex);
				exexutors.execute(new testThead2(runlist));
			}else{
				 startindex = i*count;
				 endindex = (i+1)*count;
				 LOG.info("数据段："+startindex+"----->"+endindex+"执行！.........");	
				final List<CoachVO> runlist = splitList(oldlist, startindex, endindex);
				exexutors.execute(new testThead2(runlist));
			}
	
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
	//方式二
	public void syschHander2(){
		List<CoachVO> oldlist = GetMoniDataUtil(); 
		Stopwatch stopwatch = Stopwatch.createStarted();
		int count = 2000; //每条线程处理万条数据
		int listsize = oldlist.size();//总数据条数
		int runsize = (listsize/count)+1;//开启线程数
		ExecutorService exexutors = Executors.newFixedThreadPool(runsize);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>(runsize);
		for(int  i=0;i<runsize;i++){
			int startindex ;
		    int endindex ;
			//存放每个线程的执行数据
			if(runsize==(i+1)){
				 startindex = i*count;
				 endindex = oldlist.size();
				 LOG.info("数据段："+startindex+"----->"+endindex+"执行！.........");	
				final List<CoachVO> runlist =  splitList(oldlist, startindex, endindex);
				Callable<Integer> task1 = () -> {
		        	  coachbasicoperationmapper.BatchAddCoach(runlist);
		        	  return 1;
		            };
		            futures.add(exexutors.submit(task1));
			}else{
				 startindex = i*count;
				 endindex = (i+1)*count;
				 LOG.info("数据段："+startindex+"----->"+endindex+"执行！.........");	
				final List<CoachVO> runlist = splitList(oldlist, startindex, endindex);
				Callable<Integer> task1 = () -> {
		        	  coachbasicoperationmapper.BatchAddCoach(runlist);
		        	  return 1;
		            };
		            futures.add(exexutors.submit(task1));
			}

	           
	            
		}
		LOG.info(stopwatch.stop().elapsed(TimeUnit.MICROSECONDS));
		exexutors.shutdown();
	}
	
	//方式1
	public void syschHander1(){

		//获取一百万条数据
		List<CoachVO> oldlist = GetMoniDataUtil(); 
		Stopwatch stopwatch = Stopwatch.createStarted();
		int count = 2000; //每条线程处理万条数据
		int listsize = oldlist.size();//总数据条数
		int runsize = (listsize/count)+1;//开启线程数
		//int runsize = 10;
		ExecutorService exexutors = Executors.newFixedThreadPool(runsize);
		CountDownLatch star = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(runsize);
		LOG.info("总数据条数："+listsize+".....................................");
		LOG.info("开启线程数："+runsize+".....................................");
		
		for(int i=0;i<runsize;i++){
		    int startindex ;
		    int endindex ;
			List<CoachVO> runlist;//存放每个线程的执行数据
			if(runsize==(i+1)){
				 startindex = i*count;
				 endindex = oldlist.size();
				 runlist = splitList(oldlist, startindex, endindex);
			}else{
				 startindex = i*count;
				 endindex = (i+1)*count;
				 runlist = splitList(oldlist, startindex, endindex);
			}
			
		  LOG.info("数据段："+startindex+"----->"+endindex+"执行！.........");	
		  exexutors.execute(new testThead(runlist, star, end));
		}
		try {
			star.countDown();
			//end.await();
		}finally {
			LOG.info("花费时间："+stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)+"毫秒");
			exexutors.shutdown();
		}
	}
	//拆分数据
	public List<CoachVO> splitList(List<CoachVO> list,int start,int end){		
		List<CoachVO> spliList = new LinkedList<>();		
		for(int i=start;i<end;i++) {
			spliList.add(list.get(i));
		}
		return spliList;
	}
	class testThead2 implements Runnable{
		 private List<CoachVO> runlist;
    	 testThead2(List<CoachVO> runlist) {
     		this.runlist = runlist;
 		}
		@Override
		public void run() {
		
			try {
				coachbasicoperationmapper.BatchAddCoach(runlist);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
    class testThead implements Runnable{
    	 private List<CoachVO> runlist;
    	 private CountDownLatch begin;
    	 private CountDownLatch end;
    	testThead(List<CoachVO> runlist,CountDownLatch begin,CountDownLatch end) {
    		this.runlist = runlist;
            this.begin = begin;
            this.end = end;
		}
		@Override
		public void run() {
			try {
				LOG.info("线程名"+Thread.currentThread().getName());
				coachbasicoperationmapper.BatchAddCoach(runlist);
				begin.await(); //执行完等待
			} catch (Exception e) {
				LOG.info("错误异常"+e);
			}finally {
				
				end.countDown();
			}
			
		}
    	
    }
	
			//模拟获取一百万调数据
	public List<CoachVO> GetMoniDataUtil(){
				long start = System.currentTimeMillis();
				LOG.info("模拟生成数据开始时间 ：  "+start);
				List<CoachVO> list = new LinkedList<CoachVO>();
				for(int i=0;i<200000;i++){
					CoachVO  coach = new CoachVO();
					coach.setCoach_name("wmx");
					coach.setCoach_address(getaddress("广西"));
					coach.setCoach_age(1);
					coach.setCoach_idcard(getidcard());
					coach.setCoach_number("1234567890");
					coach.setCoach_sex("0");
					list.add(coach);
					coach = null; //gc回收
				}
				long end = System.currentTimeMillis();
				LOG.info("模拟生成数据结束,花费时间:"+(end-start)+"毫秒！");
				return list;
			}
	public String getaddress(String address){
				StringBuilder sb = new StringBuilder(address);

				Random random = new Random();
				String result="";
				for (int i=0;i<6;i++)
				{
					result+=random.nextInt(10);
				}
				
				return sb.append(result).toString();
				
			}
	public String getidcard(){
				StringBuilder sb = new StringBuilder();
				Random random = new Random();
				String result="";
				for (int i=0;i<15;i++)
				{
					result+=random.nextInt(10);
				}
				return sb.append(result).toString();
				
			}

 
	
	//ttps://blog.csdn.net/u010682330/article/details/81110494
	//https://blog.csdn.net/cheng9981/article/details/82387218		
}
