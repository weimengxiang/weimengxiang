package cn.tj.informationmanage.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.informationmanage.bean.TraineeVO;
import cn.tj.informationmanage.mapper.TraineeBasicOperationMapper;
import cn.tj.service.api.TraineeBasicOperationService;

@Service
public class TraineeBasicOperationServiceImp implements TraineeBasicOperationService {

	@Autowired
	TraineeBasicOperationMapper traineebasicoperationmapper;
	@Override
	public void AddTrainee(TraineeVO Traineevo) {
		traineebasicoperationmapper.AddTrainee(Traineevo);
		
	}

	@Override
	public void DeleteTraineeById(int traineeid) {
		traineebasicoperationmapper.DeleteTraineeById(traineeid);
		
	}

	@Override
	public void BatchDeleteTrainee(List<Integer> list) {
		traineebasicoperationmapper.BatchDeleteTrainee(list);
		
	}

	@Override
	public List<TraineeVO> QueryTraineeById(int traineeid) {
		List<TraineeVO> listTrainne = traineebasicoperationmapper.QueryTraineeById(traineeid);
		return listTrainne;
	}

	@Override
	public List<TraineeVO> QueryTraineeCurrency(TraineeVO Traineevo) {
		List<TraineeVO> list = traineebasicoperationmapper.QueryTraineeCurrency(Traineevo);
		return list;
	}

	@Override
	public void UpdateTrainee(TraineeVO Traineevo) {
		traineebasicoperationmapper.UpdateTrainee(Traineevo);
	}

	@Override
	public void BatchAddTrainee(List<TraineeVO> list) {
		traineebasicoperationmapper.BatchAddTrainee(list);
	}

}
