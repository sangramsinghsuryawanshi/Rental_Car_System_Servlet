package com.RentCar.been;

public class ContactClass 
{
	 private int uId;
	 private String uname;
	 private String uemail;
	 private String usubject;
	 private String umessage;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUsubject() {
		return usubject;
	}
	public void setUsubject(String usubject) {
		this.usubject = usubject;
	}
	public String getUmessage() {
		return umessage;
	}
	public void setUmessage(String umessage) {
		this.umessage = umessage;
	}
	public ContactClass(int uId, String uname, String uemail, String usubject, String umessage) {
		super();
		this.uId = uId;
		this.uname = uname;
		this.uemail = uemail;
		this.usubject = usubject;
		this.umessage = umessage;
	}
	@Override
	public String toString() {
		return "ContactClass [uId=" + uId + ", uname=" + uname + ", uemail=" + uemail + ", usubject=" + usubject
				+ ", umessage=" + umessage + "]";
	}
	public ContactClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
