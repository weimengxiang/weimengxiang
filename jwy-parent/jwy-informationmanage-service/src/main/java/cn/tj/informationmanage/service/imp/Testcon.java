package cn.tj.informationmanage.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.service.api.CoachBasicOperationService;

@RestController
public class Testcon {
	@Autowired
	CoachBasicOperationService coachbasicoperationservice;
	@RequestMapping(value="add")
	public String tes(){
		coachbasicoperationservice.BatchAddCoach(new ArrayList<CoachVO>());
		return "asaa";
	}
}
