package cn.tj.informationmanage.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import com.alibaba.dubbo.config.annotation.Service;
import cn.tj.informationmanage.mapper.CoachBasicOperationMapper;
import cn.tj.service.api.CoachGttHanderService;

@Service
public class CoachGttHanderServiceImp implements CoachGttHanderService{

	@Autowired
	private StringRedisTemplate redistemplate;
	@Autowired
	private CoachBasicOperationMapper coachbasicoperationmapper; 
	String coachID = "COACHKEY";
	@Override
	public int GttHander(int tager){
		
		int TAG = 0;//点赞
		int coachkey =Integer.parseInt(redistemplate.opsForValue().get(coachID));
		
		if(String.valueOf(tager) == null){
			tager = TAG;
			return 49;
		}
		synchronized (this) {
			//点赞
			if(tager ==  0){
				coachkey = coachkey + 1; 
				redistemplate.opsForValue().set(coachID, String.valueOf(coachkey));
			}else if(tager == 1){
				coachkey = coachkey - 1; 
				redistemplate.opsForValue().set(coachID, String.valueOf(coachkey));
			}	
		}
		return coachkey;
	}

	@Override
	public void SynchCoachData() {
		int dzsize =Integer.valueOf(redistemplate.opsForValue().get(coachID));
		
		coachbasicoperationmapper.updateCoachData(coachID,dzsize);
	}

}
