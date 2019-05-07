package com.zwsec.twoexcel.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zwsec.enums.JiraEnum;
import com.zwsec.twoexcel.createdata.CreateDateEntity;
import com.zwsec.twoexcel.pojo.DatEntity;
import com.zwsec.twoexcel.util.ExcelUtil;

/**
 * 功能測試類
 * 
 * @author ZUOSHICHAO
 *
 */
public class TwoExcelMain {

	private static final String srcXlsPath = "/DocCreate/src/main/resources/model/jira.xls";
	private static final String desXlsPath = "D:\\jira\\attach\\";
	private static final String sheetName = "漏洞信息详情表";

	public static void main(String[] args) {
		CreateDateEntity createDateEntity = new CreateDateEntity();
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.setSrcXlsPath(srcXlsPath);
		excelUtil.setDesXlsPath(desXlsPath, getFileName());
		excelUtil.setSheetName(sheetName);
		excelUtil.getSheet();
		List<DatEntity> datEntities;
		for (int i = 0; i < 10; i++) {

			datEntities = createDateEntity.createDate(i);
			DatEntity datEntityMin = datEntities.get(0);
			DatEntity datEntityMax = datEntities.get(datEntities.size() - 1);
			// 最小值赋值
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 0,
					String.valueOf(datEntityMin.getRowNum() + 1));
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 1,
					String.valueOf(datEntityMin.getFileName()));
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 2, String.valueOf(datEntityMin.getLine()));
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 3,
					String.valueOf(datEntityMin.getShortName()));
			// 最大值赋值
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 4,
					String.valueOf(datEntityMax.getFileName()));
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 5, String.valueOf(datEntityMax.getLine()));
			excelUtil.setCellStrValue(i + JiraEnum.ROW_INDEX.getJiraNum(), 6,
					String.valueOf(datEntityMax.getShortName()));
		}
		// 导出
		excelUtil.exportToNewFile();
	}

	public static String getFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String fileName = sdf.format(new Date());
		return fileName;
	}
}
