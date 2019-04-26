package com.zwsec.service.mian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.zwsec.service.entity.UserEntity;

public class MakeExcelTest {

	final static String filePath ="D:\\jira\\attach\\"; 
	
	/**
	 * 产生要存储的集合
	 * 
	 * @return
	 */
	protected static List<UserEntity> getUserEntiry() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		UserEntity entity = new UserEntity("张胜男", "123456");
		UserEntity entity2 = new UserEntity("雷强", "12138");
		UserEntity entity3 = new UserEntity("孙德胜", "52912138");

		userList.add(entity3);
		userList.add(entity2);
		userList.add(entity);
		return userList;
	}

	public static void main(String[] args) {
		// 第一步，创建一个workBook对应的excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二步，在workBook中创建一个sheet对应的excel中的sheet
		HSSFSheet sheet = workbook.createSheet("漏洞信息详情表");
		// 第三步，在sheet表中添加表头第0行
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("用户名");
		cell = row.createCell(1);
		cell.setCellValue("密码");

		// 第五步，写入实体数据，
		// 实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值

		List<UserEntity> userList = getUserEntiry();

		for (int i = 0; i < userList.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 1);
			UserEntity userEntity = userList.get(i);
			row1.createCell(0).setCellValue(userEntity.getUserName());
			row1.createCell(1).setCellValue(userEntity.getPassWord());
		}

		// 将文件保存在指定位置

		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(filePath + getFileName());
			workbook.write(fos);
			System.out.println("写入成功！！！");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFileName() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddhhMMss");
		String date = simpleDateFormat.format(new Date());
		String fileName = "\\置维信息科技版权所有翻版必究" + date + ".xls";
		return fileName;
	}
}
