package cn.tj.informationmanage.service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.informationmanage.bean.DrivingVO;
import cn.tj.informationmanage.mapper.DrivingBasicOperationMapper;
import cn.tj.informationmanage.service.DrivingBasicOperationService;

@Service
public class DrivingBasicOperationServiceImp implements DrivingBasicOperationService{
    @Autowired
    DrivingBasicOperationMapper drivingbasicoperationmapper;
	@Override
	public void AddDriving(DrivingVO drivingvo) {
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String updatedate = SDF.format(new Date());
		drivingvo.setUpdatedate(updatedate);
		drivingbasicoperationmapper.AddDriving(drivingvo);		
	}

	@Override
	public void DeleteDriving(int drivingid) {
		drivingbasicoperationmapper.DeleteDriving(drivingid);		
	}

	@Override
	public void BatchDeleteDriving(List<Integer> list) {
		drivingbasicoperationmapper.BatchDeleteDriving(list);		
	}

	@Override
	public List<DrivingVO> QueryDrivingById(int drivingid) {
		List<DrivingVO> list = drivingbasicoperationmapper.QueryDrivingById(drivingid);
		return list;
	}

	@Override
	public List<DrivingVO> QueryDrivingCurrency(DrivingVO drivingvo) {
		List<DrivingVO> list = drivingbasicoperationmapper.QueryDrivingCurrency(drivingvo);
		return list;
	}

	@Override
	public void UpdateDriving(DrivingVO drivingvo) {
		drivingbasicoperationmapper.UpdateDriving(drivingvo);		
	}

	@Override
	public int BatchAddDriving(List<DrivingVO> drivingvolist) {
		int size = drivingbasicoperationmapper.BatchAddDriving(drivingvolist);
		return size;
	}
	

}
