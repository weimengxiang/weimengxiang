package cn.tj.informationmanage.bean;

import java.io.Serializable;

public class DrivingVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int drivingid;
	public String drivingid_name;
	public String driving_person_name;
	public String driving_registered_address;
	public String driving_number;
	public String driving_registered_amount;
	public String updatedate;
	public DrivingVO() {
		super();
	}
	public int getDrivingid() {
		return drivingid;
	}
	public void setDrivingid(int drivingid) {
		this.drivingid = drivingid;
	}
	public String getDrivingid_name() {
		return drivingid_name;
	}
	public void setDrivingid_name(String drivingid_name) {
		this.drivingid_name = drivingid_name;
	}
	public String getDriving_person_name() {
		return driving_person_name;
	}
	public void setDriving_person_name(String driving_person_name) {
		this.driving_person_name = driving_person_name;
	}
	public String getDriving_registered_address() {
		return driving_registered_address;
	}
	public void setDriving_registered_address(String driving_registered_address) {
		this.driving_registered_address = driving_registered_address;
	}
	public String getDriving_number() {
		return driving_number;
	}
	public void setDriving_number(String driving_number) {
		this.driving_number = driving_number;
	}
	public String getDriving_registered_amount() {
		return driving_registered_amount;
	}
	public void setDriving_registered_amount(String driving_registered_amount) {
		this.driving_registered_amount = driving_registered_amount;
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
		return "DrivingVO [drivingid=" + drivingid + ", drivingid_name=" + drivingid_name + ", driving_person_name="
				+ driving_person_name + ", driving_registered_address=" + driving_registered_address
				+ ", driving_number=" + driving_number + ", driving_registered_amount=" + driving_registered_amount
				+ ", updatedate=" + updatedate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driving_number == null) ? 0 : driving_number.hashCode());
		result = prime * result + ((driving_person_name == null) ? 0 : driving_person_name.hashCode());
		result = prime * result + ((driving_registered_address == null) ? 0 : driving_registered_address.hashCode());
		result = prime * result + ((driving_registered_amount == null) ? 0 : driving_registered_amount.hashCode());
		result = prime * result + drivingid;
		result = prime * result + ((drivingid_name == null) ? 0 : drivingid_name.hashCode());
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
		DrivingVO other = (DrivingVO) obj;
		if (driving_number == null) {
			if (other.driving_number != null)
				return false;
		} else if (!driving_number.equals(other.driving_number))
			return false;
		if (driving_person_name == null) {
			if (other.driving_person_name != null)
				return false;
		} else if (!driving_person_name.equals(other.driving_person_name))
			return false;
		if (driving_registered_address == null) {
			if (other.driving_registered_address != null)
				return false;
		} else if (!driving_registered_address.equals(other.driving_registered_address))
			return false;
		if (driving_registered_amount == null) {
			if (other.driving_registered_amount != null)
				return false;
		} else if (!driving_registered_amount.equals(other.driving_registered_amount))
			return false;
		if (drivingid != other.drivingid)
			return false;
		if (drivingid_name == null) {
			if (other.drivingid_name != null)
				return false;
		} else if (!drivingid_name.equals(other.drivingid_name))
			return false;
		if (updatedate == null) {
			if (other.updatedate != null)
				return false;
		} else if (!updatedate.equals(other.updatedate))
			return false;
		return true;
	}
	
	

}
