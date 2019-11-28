package cn.tj.informationmanage.service;

import java.util.List;
import cn.tj.informationmanage.bean.CoachVO;
/**
 * 
 * @author weimengxiang
 * 
 * 教练信息基本操作及管理公共接口
 *
 */
public interface CoachBasicOperationService {
		//新增教练
		public void AddCoach(CoachVO coachvo);
		//单条删除
		public void DeleteCoachById(int coahcid);
		//批量删除
		public void BatchDeleteCoach(List<Integer> list);
		//根究id查询
		public List<CoachVO> QueryCoachById(int coahcid);
		//多条件查询
		public List<CoachVO> QueryCoachCurrency(CoachVO coachvo);
		//更新修改
		public void UpdateCoach(CoachVO coachvo);
		//批量新增
		public void BatchAddCoach(List<CoachVO> list);
}
