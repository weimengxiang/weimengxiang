package cn.tj.informationmanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.tj.informationmanage.bean.CoachVO;

@Mapper
public interface CoachBasicOperationMapper {

	void AddCoach(@Param("coachvo")CoachVO coachvo);

	void DeleteCoachById(@Param("coahcid")int coahcid);

	void BatchDeleteCoach(@Param("list")List<Integer> list);

	List<CoachVO> QueryCoachById(@Param("coahcid")int coahcid);

	List<CoachVO> QueryCoachCurrency(@Param("coachvo")CoachVO coachvo);

	void UpdateCoach(@Param("coachvo")CoachVO coachvo);
	
	void BatchAddCoach(@Param("coachvo_list")List<CoachVO> coachvo_list);

}
