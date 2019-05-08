package com.zwsec.twoexcel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.RichTextString;

/**
 * 第二次尝试excel根据模板导出
 * 
 * 共分为六步完成根据模板导出 Excel操作 第一步、设置 excel 模板的路径 第二步，设置要生成 excel 文件路径
 * 第三步，设置模板中那个Sheet列 第四步，获取所读取 excel 模板的对像 第五步，设置数据（分为六种） 第六步，完后导出
 * 
 * @author ZHUYK
 *
 */
public class ExcelUtil {
	// 模板路径
	private String srcXlsPath = "";
	// 生成文件路径
	private String desXlsPath = "";

	private String sheetName = "";

	POIFSFileSystem fs = null;

	HSSFWorkbook wb = null;

	HSSFSheet sheet = null;

	/**
	 * 第一步、设置 excel 模板的路径
	 * 
	 * @param srcXlsPath
	 */
	public void setSrcXlsPath(String srcXlsPath) {
		this.srcXlsPath = srcXlsPath;
	}

	/**
	 * 第二步，设置要生成 excel 文件路径
	 * 
	 * @param desXlsPath
	 */
	public void setDesXlsPath(String desXlsPath,String fileName) {
		File filePath = new File(desXlsPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		this.desXlsPath = desXlsPath + fileName + ".xls";
	}

	/**
	 * 第三步，设置模板中那个Sheet列
	 * 
	 * @param sheetName
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * 第四步，获取所读取 excel 模板的对象
	 */
	public void getSheet() {
		try {

			File fi = new File(srcXlsPath);
			if (!fi.exists()) {
				System.out.println("模板文件" + srcXlsPath + "不存在!");
				return;
			}
			fs = new POIFSFileSystem(new FileInputStream(fi));
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 第五步，设置数据（分为六种） 设置字符串类型的数据
	 * 
	 * @param rowIndex-- 行值
	 * @param cellnum-- 列值
	 * @param value-- 字符串类型的数值
	 */
	public void setCellStrValue(int rowIndex, int cellnum, String value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		System.out.println(rowIndex);
		cell.setCellValue(value);
	}

	/**
	 * 第五步，设置数据（分为六种） 设置日期/时间类型的数据
	 * 
	 * @param rowIndex-- 行值
	 * @param cellnum-- 列值
	 * @param value-- 日期/时间类型的数值
	 */
	public void setCellDateValue(int rowIndex, int cellnum, Date value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步，设置数据（分为六种） 设置浮点类型的数据
	 * 
	 * @param rowIndex-- 行值
	 * @param cellnum-- 列值
	 * @param value-- 浮点类型的数值
	 */
	public void setCellDoubleValue(int rowIndex, int cellnum, double value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步，设置数据（分为六种） 设置Bool类型的数据
	 * 
	 * @param rowIndex-- 行值
	 * @param cellnum-- 列值
	 * @param value-- Bool类型的数值
	 */
	public void setCellBoolValue(int rowIndex, int cellnum, boolean value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步，设置数据（分为六种） 设置日历类型的数据
	 * 
	 * @param rowIndex-- 行值
	 * @param cellnum-- 列值
	 * @param value-- 日历类型的数值
	 */
	public void setCellCalendarValue(int rowIndex, int cellnum, Calendar value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步，设置数据（分为六种） 设置富文本类型的数据
	 * 
	 * @param rowIndex-- 行值
	 * @param cellnum-- 列值
	 * @param value-- 富文本类型的数值
	 */
	public void setCellRichTextStrValue(int rowIndex, int cellnum, RichTextString value) {
		HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第六步，完后导出 完成导出
	 */
	public void exportToNewFile() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(desXlsPath);
			wb.write(out);
			out.close();
			System.out.println("导出完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
