package cn.tj.informationmanage.bean;

import java.io.Serializable;

public class TraineeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  public int traineeid;
	  public int coachid;
	  public String trainee_name;
	  public int trainee_age;
	  public String trainee_address;
	  public String trainee_idcard;
	  public String trainee_number;
	  public String trainee_sex;
	  public String updatedate;
	public TraineeVO() {
		super();
	}
	public int getTraineeid() {
		return traineeid;
	}
	public void setTraineeid(int traineeid) {
		this.traineeid = traineeid;
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public String getTrainee_name() {
		return trainee_name;
	}
	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}
	public int getTrainee_age() {
		return trainee_age;
	}
	public void setTrainee_age(int trainee_age) {
		this.trainee_age = trainee_age;
	}
	public String getTrainee_address() {
		return trainee_address;
	}
	public void setTrainee_address(String trainee_address) {
		this.trainee_address = trainee_address;
	}
	public String getTrainee_idcard() {
		return trainee_idcard;
	}
	public void setTrainee_idcard(String trainee_idcard) {
		this.trainee_idcard = trainee_idcard;
	}
	public String getTrainee_number() {
		return trainee_number;
	}
	public void setTrainee_number(String trainee_number) {
		this.trainee_number = trainee_number;
	}
	public String getTrainee_sex() {
		return trainee_sex;
	}
	public void setTrainee_sex(String trainee_sex) {
		this.trainee_sex = trainee_sex;
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
		return "TraineeVO [traineeid=" + traineeid + ", coachid=" + coachid + ", trainee_name=" + trainee_name
				+ ", trainee_age=" + trainee_age + ", trainee_address=" + trainee_address + ", trainee_idcard="
				+ trainee_idcard + ", trainee_number=" + trainee_number + ", trainee_sex=" + trainee_sex
				+ ", updatedate=" + updatedate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coachid;
		result = prime * result + ((trainee_address == null) ? 0 : trainee_address.hashCode());
		result = prime * result + trainee_age;
		result = prime * result + ((trainee_idcard == null) ? 0 : trainee_idcard.hashCode());
		result = prime * result + ((trainee_name == null) ? 0 : trainee_name.hashCode());
		result = prime * result + ((trainee_number == null) ? 0 : trainee_number.hashCode());
		result = prime * result + ((trainee_sex == null) ? 0 : trainee_sex.hashCode());
		result = prime * result + traineeid;
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
		TraineeVO other = (TraineeVO) obj;
		if (coachid != other.coachid)
			return false;
		if (trainee_address == null) {
			if (other.trainee_address != null)
				return false;
		} else if (!trainee_address.equals(other.trainee_address))
			return false;
		if (trainee_age != other.trainee_age)
			return false;
		if (trainee_idcard == null) {
			if (other.trainee_idcard != null)
				return false;
		} else if (!trainee_idcard.equals(other.trainee_idcard))
			return false;
		if (trainee_name == null) {
			if (other.trainee_name != null)
				return false;
		} else if (!trainee_name.equals(other.trainee_name))
			return false;
		if (trainee_number == null) {
			if (other.trainee_number != null)
				return false;
		} else if (!trainee_number.equals(other.trainee_number))
			return false;
		if (trainee_sex == null) {
			if (other.trainee_sex != null)
				return false;
		} else if (!trainee_sex.equals(other.trainee_sex))
			return false;
		if (traineeid != other.traineeid)
			return false;
		if (updatedate == null) {
			if (other.updatedate != null)
				return false;
		} else if (!updatedate.equals(other.updatedate))
			return false;
		return true;
	}

}
