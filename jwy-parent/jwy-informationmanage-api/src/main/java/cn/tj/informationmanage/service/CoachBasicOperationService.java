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
		/**
		 * 新增教练
		 * @param coachvo
		 */
		public void AddCoach(CoachVO coachvo);
		/**
		 * 单条删除
		 * @param coahcid
		 */
		public void DeleteCoachById(int coahcid);
		/**
		 * 批量删除
		 * @param list
		 */
		public void BatchDeleteCoach(List<Integer> list);
		/**
		 * 根究id查询
		 * @param coahcid
		 * @return
		 */
		public List<CoachVO> QueryCoachById(int coahcid);
		/**
		 * 多条件查询
		 * @param coachvo
		 * @return
		 */
		public List<CoachVO> QueryCoachCurrency(CoachVO coachvo);
		/**
		 * 更新修改
		 * @param coachvo
		 */
		public void UpdateCoach(CoachVO coachvo);
		/**
		 * 批量新增
		 * @param list
		 * @return
		 */
		public void BatchAddCoach(List<CoachVO> list);
}
