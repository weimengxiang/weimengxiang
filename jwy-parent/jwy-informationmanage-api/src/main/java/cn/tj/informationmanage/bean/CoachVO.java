package cn.tj.informationmanage.bean;

import java.io.Serializable;

public class CoachVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  public int coachid;
	  public int drivingid;
	  public String coach_name;
	  public int coach_age;
	  public String coach_address;
	  public String coach_sex;
	  public String coach_idcard;
	  public String coach_number;
	  public int coach_work_time;
	  public String updatedate;
	public CoachVO() {
		super();
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public int getDrivingid() {
		return drivingid;
	}
	public void setDrivingid(int drivingid) {
		this.drivingid = drivingid;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public int getCoach_age() {
		return coach_age;
	}
	public void setCoach_age(int coach_age) {
		this.coach_age = coach_age;
	}
	public String getCoach_address() {
		return coach_address;
	}
	public void setCoach_address(String coach_address) {
		this.coach_address = coach_address;
	}
	public String getCoach_sex() {
		return coach_sex;
	}
	public void setCoach_sex(String coach_sex) {
		this.coach_sex = coach_sex;
	}
	public String getCoach_idcard() {
		return coach_idcard;
	}
	public void setCoach_idcard(String coach_idcard) {
		this.coach_idcard = coach_idcard;
	}
	public String getCoach_number() {
		return coach_number;
	}
	public void setCoach_number(String coach_number) {
		this.coach_number = coach_number;
	}
	public int getCoach_work_time() {
		return coach_work_time;
	}
	public void setCoach_work_time(int coach_work_time) {
		this.coach_work_time = coach_work_time;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CoachVO [coachid=" + coachid + ", drivingid=" + drivingid + ", coach_name=" + coach_name
				+ ", coach_age=" + coach_age + ", coach_address=" + coach_address + ", coach_sex=" + coach_sex
				+ ", coach_idcard=" + coach_idcard + ", coach_number=" + coach_number + ", coach_work_time="
				+ coach_work_time + ", updatedate=" + updatedate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coach_address == null) ? 0 : coach_address.hashCode());
		result = prime * result + coach_age;
		result = prime * result + ((coach_idcard == null) ? 0 : coach_idcard.hashCode());
		result = prime * result + ((coach_name == null) ? 0 : coach_name.hashCode());
		result = prime * result + ((coach_number == null) ? 0 : coach_number.hashCode());
		result = prime * result + ((coach_sex == null) ? 0 : coach_sex.hashCode());
		result = prime * result + coach_work_time;
		result = prime * result + coachid;
		result = prime * result + drivingid;
		result = prime * result + ((updatedate == null) ? 0 : updatedate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoachVO other = (CoachVO) obj;
		if (coach_address == null) {
			if (other.coach_address != null)
				return false;
		} else if (!coach_address.equals(other.coach_address))
			return false;
		if (coach_age != other.coach_age)
			return false;
		if (coach_idcard == null) {
			if (other.coach_idcard != null)
				return false;
		} else if (!coach_idcard.equals(other.coach_idcard))
			return false;
		if (coach_name == null) {
			if (other.coach_name != null)
				return false;
		} else if (!coach_name.equals(other.coach_name))
			return false;
		if (coach_number == null) {
			if (other.coach_number != null)
				return false;
		} else if (!coach_number.equals(other.coach_number))
			return false;
		if (coach_sex == null) {
			if (other.coach_sex != null)
				return false;
		} else if (!coach_sex.equals(other.coach_sex))
			return false;
		if (coach_work_time != other.coach_work_time)
			return false;
		if (coachid != other.coachid)
			return false;
		if (drivingid != other.drivingid)
			return false;
		if (updatedate == null) {
			if (other.updatedate != null)
				return false;
		} else if (!updatedate.equals(other.updatedate))
			return false;
		return true;
	}
	  

}
