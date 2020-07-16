package cn.tj.informationmanage.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;

import ch.qos.logback.classic.Logger;
import cn.tj.service.api.CoachGttHanderService;

@Service
public class CoachGttHanderServiceImp implements CoachGttHanderService{

	@Autowired
	private StringRedisTemplate redistemplate;
	
	@Override
	public int GttHander(int tager){
		
		int TAG = 0;//点赞
		int coachkey =Integer.parseInt(redistemplate.opsForValue().get("COACHKEY"));
		
		if(String.valueOf(tager) == null){
			tager = TAG;
			return 49;
		}
		synchronized (this) {
			//点赞
			if(tager ==  0){
				coachkey = coachkey + 1; 
				redistemplate.opsForValue().set("COACHKEY", String.valueOf(coachkey));
			}else if(tager == 1){
				coachkey = coachkey - 1; 
				redistemplate.opsForValue().set("COACHKEY", String.valueOf(coachkey));
			}	
		}
		return coachkey;
	}

}
