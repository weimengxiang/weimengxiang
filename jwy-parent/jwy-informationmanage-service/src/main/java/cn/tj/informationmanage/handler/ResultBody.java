package cn.tj.informationmanage.handler;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author weimengxiang
 * 
 *  定义统一的，数据传输格式
 *
 */
public class ResultBody {
	/**
	 * 响应代码
	 */
	private String code;
	/**
	 * 响应信息
	 */
	private String message;
	/**
	 * 响应结果
	 */
	private Object result;
	
	public ResultBody(){
		
	}
	public ResultBody(BaseErrorInfoInterface errorInfo){
		this.code = errorInfo.getResultCode();
		this.message = errorInfo.getReultMsg();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	/**
	 * 成功
	 */
	public static ResultBody success(){
		return success();
	}
	/**
	 * 成功
	 */

	public static ResultBody success(Object data){
		ResultBody rb = new ResultBody();
		rb.setCode(CommonEnum.SUCCESS.getResultCode());
		rb.setMessage(CommonEnum.SUCCESS.getReultMsg());
		rb.setResult(data);
		return rb;
	}
	/**
	 * 失败,异常返回信息
	 */
	public static ResultBody error(BaseErrorInfoInterface errorinfo){
		ResultBody rb = new ResultBody();
		rb.setCode(errorinfo.getResultCode());
		rb.setMessage(errorinfo.getReultMsg());
		rb.setResult(null);
		return rb;
	}
	/**
	 * 失败，
	 * @param code ,msg
	 */
	public static ResultBody error(String code,String msg){
		ResultBody rb = new ResultBody();
		rb.setCode(code);
		rb.setMessage(msg);
		rb.setResult(null);
		return rb;
	}
	/**
	 * 失败
	 * 
	 */
	public static ResultBody error(String msg){
		ResultBody rb = new ResultBody();
		rb.setCode("-1");
		rb.setMessage(msg);
		rb.setResult(null);
		return rb;
	}
	
	public String toString(){
		return JSONObject.toJSONString(this);
	}
	
}

