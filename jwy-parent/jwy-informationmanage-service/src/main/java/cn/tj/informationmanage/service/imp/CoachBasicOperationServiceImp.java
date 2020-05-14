package cn.tj.informationmanage.service.imp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import cn.tj.service.api.TestServiceApi;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Stopwatch;

import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.informationmanage.mapper.CoachBasicOperationMapper;
import cn.tj.informationmanage.util.annotation.InterfaceMonitor;
import cn.tj.service.api.CoachBasicOperationService;


//@Service(version="2.0.0",retries=0)
@Service(
        version = "2.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")

public class CoachBasicOperationServiceImp implements CoachBasicOperationService{

	/**
	 * 
	 */

	private static final Logger LOG = LogManager.getLogger(CoachBasicOperationServiceImp.class);

	@Autowired
	CoachBasicOperationMapper coachbasicoperationmapper;
	@Reference(check = false)
	TestServiceApi testServiceApi;
	
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
        String str = testServiceApi.test(1);
        LOG.info("相互调用成功,返回后果。。。。。。。。。。。"+str);
		List<CoachVO> list = coachbasicoperationmapper.QueryCoachById(coahcid);
		list.forEach(a->System.out.println(a.coach_address));
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

	@Override
	public PageInfo<CoachVO> QueryCoachDataAll(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);//插件分页
		List<CoachVO> datalist = coachbasicoperationmapper.QueryCoachDataAll();
		LOG.info("------------"+datalist);
		PageInfo<CoachVO> pageinfo = new PageInfo<>(datalist);
		return pageinfo;
	}

	@Override
	public void ExportExexlByCoach(String downloadType,String exportExcelName ) {
		// TODO Auto-generated method stub
		List<CoachVO> coachlist = QueryCoachDataAll(1,10000).getList();
		String sheetName = "学生表";
		String[] headers = {"教练ID","驾校ID","教练名字","教练年龄","家庭住址","性别","身份证号码","电话号码","工作时间"};
		XSSFWorkbook work = null;
		try {
		 ExportExeclUtil(sheetName,headers,coachlist,exportExcelName,downloadType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 导出execl工具方法
	 * @param sheetName 表格 sheet 的名称
     * @param headers  标题名称
     * @param dataList 需要显示的数据集合
     * @param exportExcelName 导出excel文件的名字
	 * @throws Exception 
	 * 
	 */
	public void ExportExeclUtil(String shellName,String[] headders,List<CoachVO> datalist,String exportExcelName,String downloadType) throws Exception{
		//声明一个xsswordbook
		XSSFWorkbook work = new XSSFWorkbook();
		//生成一个表格
		XSSFSheet sheet = work.createSheet(shellName);
		sheet.setDefaultColumnWidth(15);
		//生成样式
		XSSFCellStyle style = work.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);//背景色
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		//生成字体
		XSSFFont font = work.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		
		style.setFont(font);
		// 设置表格标题栏的样式
		XSSFCellStyle titleStyle = work.createCellStyle();
		titleStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setBorderBottom(BorderStyle.THIN);
		titleStyle.setBorderLeft(BorderStyle.THIN);
		titleStyle.setBorderRight(BorderStyle.THIN);
		titleStyle.setBorderTop(BorderStyle.THIN);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 设置标题栏字体
		XSSFFont titleFont = work.createFont();
		titleFont.setColor(HSSFColor.WHITE.index);
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBold(true);
		// 把字体应用到当前的样式
		titleStyle.setFont(titleFont);
		
		//表格标题行
		XSSFRow row = sheet.createRow(0);
		for(int i = 0;i<headders.length;i++){
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(titleStyle);
			XSSFRichTextString text = new XSSFRichTextString(headders[i]);
			cell.setCellValue(text);
			
		}
		
		//产生数据行  教练ID","驾校ID","教练名字","教练年龄","家庭住址","性别","身份证号码","电话号码","工作时间
		Iterator<CoachVO> iterator = datalist.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			index++;
			Map<String, String> map = new LinkedHashMap<>();
			CoachVO coach = iterator.next();
			String Coachid =  String.valueOf(coach.getCoachid());
			String Drivingid =  String.valueOf(coach.getDrivingid());
			String Coach_name = coach.getCoach_name();
			String Coach_age = String.valueOf(coach.getCoach_age());
			String Coach_address = coach.getCoach_address();
			String Coach_sex = coach.getCoach_sex();
			String Coach_idcard = coach.getCoach_idcard();
			String Coach_number = coach.getCoach_number();
			String Coach_work_time = String.valueOf(coach.getCoach_work_time());
			map.put("Coachid",Coachid);
			map.put("Drivingid", Drivingid);
			map.put("Coach_name", Coach_name);
			map.put("Coach_age", Coach_age);
			map.put("Coach_address", Coach_address);
			map.put("Coach_sex", Coach_sex);
			map.put("Coach_idcard", Coach_idcard);
			map.put("Coach_number", Coach_number);
			map.put("Coach_work_time", Coach_work_time);
			
			row = sheet.createRow(index);
			int i=0;
			Iterator<Entry<String, String>> set = map.entrySet().iterator();
			while(set.hasNext()){
				XSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				XSSFRichTextString text = new XSSFRichTextString((set.next().getValue())+" ");
				cell.setCellValue(text);
				i++;
			}
			
		}
		
			WriteLocal(exportExcelName,work);
		
	}
	//下载到本地
	public void WriteLocal(String exportExcelName,XSSFWorkbook work){
		OutputStream out = null;
	    exportExcelName = exportExcelName+(new SimpleDateFormat("yyyyMMddhhmmss").format(System.currentTimeMillis()).toString());
		try {
			String tmpPath = "C:\\Users\\lizhi\\Desktop\\execl\\" + exportExcelName +  ".xlsx";
			out = new FileOutputStream(tmpPath);
			work.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(work != null){
				try {
					work.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
    //网页下载
	/*public void WriteWeb(String exportExcelName,XSSFWorkbook work){
		 OutputStream out = null;
			try {
				exportExcelName = exportExcelName+(new SimpleDateFormat("yyyyMMddhhmmss").format(System.currentTimeMillis()).toString());
				exportExcelName = new String(exportExcelName.getBytes(),"ISO8859-1");
				Response.setContentType("application/octet-stream;charset=ISO8859-1");
				Response.setHeader("Content-Disposition", "attachment;filename=" + exportExcelName);
				Response.addHeader("Pargam", "no-cache");
				Response.addHeader("Cache-Control", "no-cache");
				out = Response.getOutputStream();
				work.write(out);
				out.flush();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				if(work != null){
					try {
						work.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(out != null){
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}		
	}
 */
	
	//ttps://blog.csdn.net/u010682330/article/details/81110494
	//https://blog.csdn.net/cheng9981/article/details/82387218		
}
