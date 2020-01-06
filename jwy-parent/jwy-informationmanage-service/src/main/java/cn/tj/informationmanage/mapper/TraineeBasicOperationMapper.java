package cn.tj.informationmanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tj.informationmanage.bean.TraineeVO;

@Mapper
public interface TraineeBasicOperationMapper {

	void AddTrainee(@Param("traineevo")TraineeVO traineevo);

	void DeleteTraineeById(@Param("traineeid")int traineeid);

	void BatchDeleteTrainee(@Param("listid")List<Integer> listid);

	List<TraineeVO> QueryTraineeById(@Param("traineeid")int traineeid);

	List<TraineeVO> QueryTraineeCurrency(@Param("traineevo")TraineeVO traineevo);

	void UpdateTrainee(@Param("traineevo")TraineeVO traineevo);

	void BatchAddTrainee(@Param("list_traineevo")List<TraineeVO> list_traineevo);

}
