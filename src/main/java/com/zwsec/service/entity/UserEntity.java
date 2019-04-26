package com.zwsec.service.entity;

/**
 * UserEntity用于封装用户数据导出到Excel文件
 * @author ZUOSHICHAO
 *
 */
public class UserEntity {

	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserEntity(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
}
