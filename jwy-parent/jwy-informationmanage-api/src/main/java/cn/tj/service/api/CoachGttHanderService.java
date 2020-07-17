package cn.tj.service.api;

/**
 * 
 * 基于redis点赞处理接口
 * @author lizhi
 *
 */
public interface CoachGttHanderService {
    /**
     * 点赞处理主方法
     * @param tager
     * @return
     */
	public int GttHander(int tager);
    /**
     * 同步数据到mysql
     */
	public void SynchCoachData();
}
