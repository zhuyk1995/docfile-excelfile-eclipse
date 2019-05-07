package com.zwsec.controller;

import java.io.File;

/**
* @author 作者: ZHUYAKANG
* @createDate 创建时间：2019年5月7日 下午5:30:51
*/
public class ReadExcelPath {

	
	public static void main(String[] arge) {
		//String path = ReadExcelPath.class.getClassLoader().getResource("/model/jira.xls").getPath();
		String srcPath = "/DocCreate/src/main/resources/model/jira.xls";
		File file = new File(srcPath);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
		System.out.println(file.exists());
	}
}
