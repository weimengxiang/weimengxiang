package cn.tj.informationmanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tj.informationmanage.bean.DrivingVO;

@Mapper
public interface DrivingBasicOperationMapper {

	void AddDriving(@Param("drivingvo")DrivingVO drivingvo);

	void DeleteDriving(@Param("drivingid")int drivingid);

	void BatchDeleteDriving(@Param("list")List<Integer> list);

	List<DrivingVO> QueryDrivingById(@Param("drivingid")int drivingid);

	List<DrivingVO> QueryDrivingCurrency(@Param("drivingvo")DrivingVO drivingvo);

	void UpdateDriving(@Param("drivingvo")DrivingVO drivingvo);

	int BatchAddDriving(@Param("drivingvolist")List<DrivingVO> drivingvolist);

	

}
