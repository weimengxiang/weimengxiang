package cn.tj.controllerRest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;

import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.service.api.CoachBasicOperationService;

@RestController
@RequestMapping("/informationmanage")
public class TestInfomationController {
	
	private static final Logger LOG = LogManager.getLogger(TestInfomationController.class);

	@Reference(version="2.0.0",retries = 0,timeout=2000000)
	CoachBasicOperationService coachbasicoperationservice;
	
	@RequestMapping(value="/addCoahc",produces = "application/json;charset=UTF-8")
	public String addCoahc(){
		new Runnable() {			
			@Override
			public void run() {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				coachbasicoperationservice.BatchAddCoach(new ArrayList<>());
			}
		}.run();
		return "success";
	}
	
	@RequestMapping(value="QueryCoachDataAll")
	public PageInfo<CoachVO> QueryCoachDataAll(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			@RequestParam(value="pageSize",defaultValue="15")int pageSize){
		return coachbasicoperationservice.QueryCoachDataAll(pageNum, pageSize);
		
	}
	@RequestMapping(value="ExeclExport")
	public void ExeclExport(HttpServletResponse Response,String exportExcelName,String downloadType){
	    coachbasicoperationservice.ExportExexlByCoach(downloadType,exportExcelName);
	   
	}
	@RequestMapping(value = "QueryCoachById")
	public void  QueryCoachById(){
		coachbasicoperationservice.QueryCoachById(1);
	}
	
}
