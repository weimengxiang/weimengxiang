package cn.tj.service.api;

import java.util.List;

import cn.tj.informationmanage.bean.TraineeVO;

/**
 * 
 * @author weimengxiang
 * 普通用户，学员
 *
 */
public interface TraineeBasicOperationService {
	/**
	 * 新增学员
	 * @param Traineevo
	 */
	public void AddTrainee(TraineeVO Traineevo);
	/**
	 * 单条删除
	 * @param coahcid
	 */
	public void DeleteTraineeById(int traineeid);
	/**
	 * 批量删除
	 * @param list
	 */
	public void BatchDeleteTrainee(List<Integer> list);
	/**
	 * 根究id查询
	 * @param coahcid
	 * @return
	 */
	public List<TraineeVO> QueryTraineeById(int traineeid);
	/**
	 * 多条件查询
	 * @param Traineevo
	 * @return
	 */
	public List<TraineeVO> QueryTraineeCurrency(TraineeVO Traineevo);
	/**
	 * 更新修改
	 * @param Traineevo
	 */
	public void UpdateTrainee(TraineeVO Traineevo);
	/**
	 * 批量新增
	 * @param list
	 * @return
	 */
	public void BatchAddTrainee(List<TraineeVO> list);
}
