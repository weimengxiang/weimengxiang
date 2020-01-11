package cn.tj.informationmanage.service.imp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.informationmanage.mapper.CoachBasicOperationMapper;
import cn.tj.informationmanage.service.CoachBasicOperationService;
import cn.tj.informationmanage.util.annotation.InterfaceMonitor;


@Service
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
		//获取一百万条数据
		List<Object> oldlist = GetMoniDataUtil(); 
		int count = 1000; //每条线程处理一千条数据
		int listsize = oldlist.size();//总数据条数
		int runsize = (listsize/1000)+1;//开启线程数
		List<Object> runlist = null;//存放每个线程的执行数据
		ExecutorService exexutors = Executors.newFixedThreadPool(runsize);
		//创建计数器
		CountDownLatch star = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(runsize);
		//ttps://blog.csdn.net/u010682330/article/details/81110494
		
		
		coachbasicoperationmapper.BatchAddCoach(list);
		
	}
	
	//模拟获取一百万调数据
	public List<Object> GetMoniDataUtil(){
		long start = System.currentTimeMillis();
		LOG.info("模拟生成数据开始时间 ：  "+start);
		List<Object> list = new LinkedList<Object>();
		for(int i=0;i<1000000;i++){
			CoachVO  coach = new CoachVO();
			coach.setCoach_name("wmx");
			coach.setCoach_address(getaddress("广西"));
			coach.setCoach_age(1);
			coach.setCoach_idcard(getidcard());
			coach.setCoach_number("1234567890");
			coach.setCoach_sex("0");
			list.add(coach);
		}
		long end = System.currentTimeMillis();
		LOG.info("模拟生成数据结束,花费时间:"+(start-end)+"毫秒！");
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
	//拆分数据
	public List<CoachVO> splitList(List<CoachVO> list,int start,int end){
		
		List<CoachVO> spliList = new LinkedList<>();
		
		for(int i=start;i<end;i++) {
			spliList.add(list.get(i));
		}
		return spliList;
		
	}

}
