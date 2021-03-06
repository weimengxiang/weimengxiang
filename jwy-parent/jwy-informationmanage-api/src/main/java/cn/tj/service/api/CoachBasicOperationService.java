package cn.tj.service.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.pagehelper.PageInfo;

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
		/**
		 *
		 * 分页查询数据 
		 * @param
		 * @return
		 */
		public PageInfo<CoachVO> QueryCoachDataAll(int pageNum,int pageSize);
		
		/**
		 * 教练表全表数据导出到Execl到本地
		 * @param
		 * @return
		 */
		public void  ExportExexlByCoach(String downloadType,String exportExcelName);
	
}
