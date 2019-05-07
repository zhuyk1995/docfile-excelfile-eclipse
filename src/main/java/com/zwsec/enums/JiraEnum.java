package com.zwsec.enums;
/**
* @author 作者: ZHUYAKANG
* @createDate 创建时间：2019年5月7日 下午2:42:45
*/
public enum JiraEnum {

	ROW_INDEX("行号",2);
	
	/** 行信息*/
	private String jiraInfo;
	/** 行数*/
	private Integer jiraNum;
	public String getJiraInfo() {
		return jiraInfo;
	}
	public void setJiraInfo(String jiraInfo) {
		this.jiraInfo = jiraInfo;
	}
	public Integer getJiraNum() {
		return jiraNum;
	}
	public void setJiraNum(Integer jiraNum) {
		this.jiraNum = jiraNum;
	}
	private JiraEnum(String jiraInfo, Integer jiraNum) {
		this.jiraInfo = jiraInfo;
		this.jiraNum = jiraNum;
	}
	
	
}
