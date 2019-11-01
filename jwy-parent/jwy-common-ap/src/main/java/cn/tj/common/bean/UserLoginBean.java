package cn.tj.common.bean;

import java.io.Serializable;

public class UserLoginBean implements Serializable {
	/**
	 *  登陆实体类
	 */
private static final long serialVersionUID = 1L;

	public int userid ;
	public String username;
	public String password;
	public String logindate;
	public String registerdate;
	public UserLoginBean() {
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogindate() {
		return logindate;
	}
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	@Override
	public String toString() {
		return "UserLoginBean [userid=" + userid + ", username=" + username + ", password=" + password + ", logindate="
				+ logindate + ", registerdate=" + registerdate + "]";
	}

	
 
}
