package cn.tj.handler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author weimengxiang
 * 自定义异常类，处理业务逻辑异常
 *
 */
public class BizException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(BizException.class);
	
	/**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;
    
    public BizException(){
    	super();
    }
    
    public BizException(BaseErrorInfoInterface errorInfoInterface){
    	super(errorInfoInterface.getResultCode());
    	this.errorCode = errorInfoInterface.getResultCode();
    	this.errorMsg = errorInfoInterface.getReultMsg();
    }
    public BizException(BaseErrorInfoInterface errorInfoInterface,Throwable cause){
    	super(errorInfoInterface.getResultCode(),cause);
    	this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getReultMsg();
    }
    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public BizException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
   
    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
    
    

}
