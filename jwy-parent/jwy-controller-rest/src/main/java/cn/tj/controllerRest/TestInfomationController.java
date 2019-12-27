package cn.tj.controllerRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.informationmanage.service.CoachBasicOperationService;
import cn.tj.informationmanage.service.TestService;

@RestController
@RequestMapping("/informationmanage")
public class TestInfomationController {
	
	
	@Reference
	CoachBasicOperationService coachbasicoperationservice;
	
	@RequestMapping(value="/addCoahc")
	public String addCoahc(){
		CoachVO  coach = new CoachVO();
		CoachVO  coach2 = new CoachVO();
		coach.setCoach_name("wmx");
		coach.setCoach_address("广西");
		coach.setCoach_age(1);
		coach.setCoach_idcard("233723826286333");
		coach.setCoach_number("1234567890");
		coach.setCoach_sex("0");
		
		coach2.setCoach_name("wmx");
		coach2.setCoach_address("广西");
		coach2.setCoach_age(1);
		coach2.setCoach_idcard("233723826286333");
		coach2.setCoach_number("1234567890");
		coach2.setCoach_sex("0");
		
		List<CoachVO> coachList = new ArrayList<CoachVO>();
		coachList.add(coach);
		coachList.add(coach2);
		coachbasicoperationservice.BatchAddCoach(coachList);
		
		return "";
	}
	
	


}
