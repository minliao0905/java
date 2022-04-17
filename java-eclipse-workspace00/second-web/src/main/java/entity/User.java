package entity;

public class User {
	private String userId;
	private String userName;
	private String passWord;
	private String userHeadImg;

	public User() {
	}

	public User(String userId, String passWord) {
		this.userId = userId;
		this.passWord = passWord;
	}

	public User(String userId) {
		this.userId = userId;
	}

	public User(String userId, String userName, String passWord) {
		this.userId = userId;
		this.passWord = passWord;
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserHeadImg() {
		return userHeadImg;
	}

	public void setUserHeadImg(String userHeadImg) {
		this.userHeadImg = userHeadImg;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + passWord + ", userHeadImg="
				+ userHeadImg + "]";
	}
}
