package cn.tj.informationmanage.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HttpServletResponse getHttpServletResponse() {
		return HttpServletResponse;
	}
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		HttpServletResponse = httpServletResponse;
	}
	public HttpServletRequest getHttpServletRequest() {
		return HttpServletRequest;
	}
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		HttpServletRequest = httpServletRequest;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public HttpServletResponse HttpServletResponse;
	public HttpServletRequest HttpServletRequest;
	

}
