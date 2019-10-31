package cn.tj.common.util;
import java.text.SimpleDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 * @auto WMX
 * 全局系统运行定时任务
 */
@Component
public class SysTaskSchedul {
	private static final Logger LOG = LogManager.getLogger(SysTaskSchedul.class);
	
    //可通过 scon 表达式对复杂时间进行设置
	@Scheduled(fixedDelay=20000000)
    public void Test() {
		LOG.info("--------------------------系统定时调度任务正常运行,调度任务开始--------------------");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		long a = System.currentTimeMillis();
		df.format(a);
		System.out.println(df.format(a));
		LOG.info("--------------------------系统定时调度任务正常运行,调度任务完成--------------------");
	}
}
