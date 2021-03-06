package cn.tj.service.api;

import java.util.List;

import cn.tj.informationmanage.bean.DrivingVO;
/**
 * @weimengxiang
 * 
 * 驾校信息基本操作及管理公共接口
 */
public interface DrivingBasicOperationService{
	//新增驾校
	public void AddDriving(DrivingVO drivingvo);
	//单条删除
	public void DeleteDriving(int drivingid);
	//批量删除
	public void BatchDeleteDriving(List<Integer> list);
	//根究id查询
	public List<DrivingVO> QueryDrivingById(int drivingid);
	//多条件查询
	public List<DrivingVO> QueryDrivingCurrency(DrivingVO drivingvo);
	//更新修改
	public void UpdateDriving(DrivingVO drivingvo);
	//批量新增
	public int BatchAddDriving(List<DrivingVO> list_drivingvo);
	
	

}
