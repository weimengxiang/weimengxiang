package cn.tj.informationmanage.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author weimengxiang
 * 
 *  全局异常处理类
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {
	
	private static final Logger LOG = LogManager.getLogger(CommonExceptionHandler.class);
	
	 /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
	@ExceptionHandler(value = BizException.class)
	@ResponseBody
	public  ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
		LOG.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }
	/**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
	@ExceptionHandler(value=NullPointerException.class)
	@ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        LOG.error("发生空指针异常！原因是:",e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATH);
    }
	 /**
     * 处理其他异常
	  * @param req
	  * @param e
	  * @return
	  */
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req,Exception e){
		 LOG.error("未知异常！原因是:",e);
	     return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
