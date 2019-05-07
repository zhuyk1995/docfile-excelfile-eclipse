package com.zwsec.twoexcel.response;

import java.io.Serializable;
import java.util.List;

import com.zwsec.twoexcel.pojo.DatEntity;

/**
* @author 作者: ZHUYAKANG
* @createDate 创建时间：2019年5月7日 下午6:40:29
*/
public class DataListRltFalse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1780417016994023380L;

	private String queryVersionName;
	
	private String queryVersionNum;
	
	private List<DatEntity> datas;

	public String getQueryVersionName() {
		return queryVersionName;
	}

	public void setQueryVersionName(String queryVersionName) {
		this.queryVersionName = queryVersionName;
	}

	public String getQueryVersionNum() {
		return queryVersionNum;
	}

	public void setQueryVersionNum(String queryVersionNum) {
		this.queryVersionNum = queryVersionNum;
	}

	public List<DatEntity> getDatas() {
		return datas;
	}

	public void setDatas(List<DatEntity> datas) {
		this.datas = datas;
	}
	
	

}
