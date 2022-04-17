package com.educoder.entity;

public class Shops {
	private String shopsId;
	private String shopsName;
	private String shopsManager;
	private String shopsAddress;
	private String shopsCreatetime;
	private String shopsClassify;
	private String shopsNums;
	private String shopspassword;

	public Shops() {

	}

	public Shops(String userId, String username, String password) {
		this.shopsId = userId;
		this.shopsName = username;
		this.shopspassword = password;
	}

	public String getShopspassword() {
		return shopspassword;
	}

	public void setShopspassword(String shopspassword) {
		this.shopspassword = shopspassword;
	}

	public String getShopsName() {
		return shopsName;
	}

	public void setShopsName(String shopsName) {
		this.shopsName = shopsName;
	}

	public String getShopsManager() {
		return shopsManager;
	}

	public void setShopsManager(String shopsManager) {
		this.shopsManager = shopsManager;
	}

	public String getShopsAddress() {
		return shopsAddress;
	}

	public void setShopsAdress(String shopsAddress) {
		this.shopsAddress = shopsAddress;
	}

	public String getShopsCreatetime() {
		return shopsCreatetime;
	}

	public void setShopsCreatetime(String shopsCreatetime) {
		this.shopsCreatetime = shopsCreatetime;
	}

	public String getShopsClassify() {
		return shopsClassify;
	}

	public void setShopsClassify(String shopsClassify) {
		this.shopsClassify = shopsClassify;
	}

	public String getShopsNums() {
		return shopsNums;
	}

	public void setShopsNums(String shopsNums) {
		this.shopsNums = shopsNums;
	}

	public String getShopsId() {
		return shopsId;
	}

	public void setShopsId(String shopsId) {
		this.shopsId = shopsId;
	}

	@Override
	public String toString() {
		return "shops [shopsId=" + shopsId + ", shopsName=" + shopsName + ", shopspassword=" + shopspassword
				+ ",shopsAdress=" + shopsAddress + " ]";
	}
}
