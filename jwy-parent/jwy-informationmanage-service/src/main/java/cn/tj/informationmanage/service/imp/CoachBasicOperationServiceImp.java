package cn.tj.informationmanage.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import cn.tj.informationmanage.bean.CoachVO;
import cn.tj.informationmanage.mapper.CoachBasicOperationMapper;
import cn.tj.informationmanage.service.CoachBasicOperationService;


@Service
public class CoachBasicOperationServiceImp implements CoachBasicOperationService {

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
	public void BatchAddCoach(List<CoachVO> list) {
		coachbasicoperationmapper.BatchAddCoach(list);
		
	}

}
